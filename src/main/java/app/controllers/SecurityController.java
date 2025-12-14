package app.controllers;

import app.daos.UserDAO;
import app.entities.User;
import io.javalin.http.Context;
import jakarta.persistence.EntityManagerFactory;
import java.util.Map;

public class SecurityController {
    private final UserDAO userDAO;

    public SecurityController(EntityManagerFactory emf) {
        this.userDAO = new UserDAO(emf);
    }

    public void login(Context ctx) {
        UserDTO loginData = ctx.bodyAsClass(UserDTO.class);
        User user = userDAO.verifyUser(loginData.getUsername(), loginData.getPassword());

        if (user != null) {
            // Generer fake token baseret på rolle
            String token = user.getUsername() + "-token";
            ctx.json(Map.of("username", user.getUsername(), "token", token, "role", user.getRole()));
        } else {
            ctx.status(401).result("Invalid credentials");
        }
    }

    public void register(Context ctx) {
        UserDTO data = ctx.bodyAsClass(UserDTO.class);
        User newUser = new User(data.getUsername(), data.getPassword(), "user");
        userDAO.create(newUser);
        ctx.status(201).json(newUser);
    }

    // Lille hjælpeklasse til login body
    @lombok.Data
    private static class UserDTO {
        String username;
        String password;
    }
}