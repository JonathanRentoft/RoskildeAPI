package app;

import app.controllers.ArtistController;
import app.controllers.SecurityController;
import app.controllers.UserController;
import app.daos.ArtistDAO;
import io.javalin.apibuilder.EndpointGroup;
import jakarta.persistence.EntityManagerFactory;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Routes {

    private final ArtistController artistController;
    private final SecurityController securityController;
    private final UserController userController;

    public Routes(EntityManagerFactory emf) {
        // Korrekt instansiering
        this.artistController = new ArtistController(ArtistDAO.getInstance(emf));
        this.securityController = new SecurityController(emf);
        this.userController = new UserController(emf);
    }

    public EndpointGroup getRoutes() {
        return () -> {
            // --- AUTH ROUTES ---
            path("/auth", () -> {
                post("/login", securityController::login, Main.Role.ANYONE);
                post("/register", securityController::register, Main.Role.ANYONE);
            });

            // --- ARTIST ROUTES ---
            path("/artists", () -> {
                get("/", artistController::getAllArtists, Main.Role.ANYONE);
                post("/", artistController::createArtist, Main.Role.ADMIN);

                path("/{id}", () -> {
                    delete("/", artistController::deleteArtist, Main.Role.ADMIN);
                    put("/", artistController::updateArtist, Main.Role.ADMIN);
                });
            });

            // --- USER / FAVORITE ROUTES ---
            path("/favorites", () -> {
                // GET /favorites -> Se mine favoritter
                get("/", userController::getFavorites, Main.Role.USER);

                path("/{id}", () -> {
                    // POST /favorites/5 -> Tilføj artist ID 5
                    post("/", userController::addFavorite, Main.Role.USER);

                    // DELETE /favorites/5 -> Fjern artist ID 5
                    delete("/", userController::removeFavorite, Main.Role.USER);
                });
            });
        };
    }
}