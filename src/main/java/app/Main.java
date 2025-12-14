package app;

import app.config.HibernateConfig;
import app.utils.Populator;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.UnauthorizedResponse;
import io.javalin.security.RouteRole; // VIGTIG IMPORT
import jakarta.persistence.EntityManagerFactory;
import org.jetbrains.annotations.NotNull; // Bruges af Javalin internt

import java.util.Set;

public class Main {

    // 1. Enum SKAL implementere RouteRole
    public enum Role implements RouteRole {
        ANYONE, USER, ADMIN
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        Populator.populate(emf);
        Routes routes = new Routes(emf);

        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableRouteOverview("/routes");
            config.bundledPlugins.enableCors(cors -> {
                cors.addRule(it -> it.anyHost());
            });

            config.http.defaultContentType = "application/json";
            config.router.apiBuilder(routes.getRoutes());

        }).beforeMatched(ctx -> {

            Set<RouteRole> roles = ctx.routeRoles();
            Role userRole = getUserRole(ctx);

            if (roles.isEmpty()
                    || roles.contains(Role.ANYONE)
                    || roles.contains(userRole)) {
                return;
            }

            throw new UnauthorizedResponse();

        }).start(7071);
    }

    private static Role getUserRole(Context ctx) {
        String token = ctx.header("Authorization");
        if (token == null) return Role.ANYONE;
        if (token.contains("admin")) return Role.ADMIN;
        if (token.contains("user")) return Role.USER;
        return Role.ANYONE;
    }
}