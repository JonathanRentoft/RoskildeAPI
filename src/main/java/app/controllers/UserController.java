package app.controllers;

import app.daos.ArtistDAO;
import app.daos.UserDAO;
import app.dtos.ArtistDTO; // HUSK DENNE
import app.entities.Artist;
import app.entities.User;
import io.javalin.http.Context;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class UserController {
    private final UserDAO userDAO;
    private final ArtistDAO artistDAO;

    public UserController(EntityManagerFactory emf) {
        this.userDAO = new UserDAO(emf);
        this.artistDAO = ArtistDAO.getInstance(emf);
    }

    // GET: Hent brugerens favoritter
    public void getFavorites(Context ctx) {
        String username = getUsernameFromToken(ctx);
        User user = userDAO.findUser(username); // Antager du har denne metode i UserDAO

        if (user == null) {
            ctx.status(404).json("{\"message\": \"User not found\"}");
            return;
        }

        // Konverter Set<Artist> til List<ArtistDTO>
        List<ArtistDTO> favoriteDTOs = user.getFavorites().stream()
                .map(ArtistDTO::new)
                .collect(Collectors.toList());

        ctx.json(favoriteDTOs);
    }

    // POST: Tilføj favorit
    public void addFavorite(Context ctx) {
        String username = getUsernameFromToken(ctx);
        // Sikker parsing af ID
        int artistId;
        try {
            artistId = Integer.parseInt(ctx.pathParam("id"));
        } catch (NumberFormatException e) {
            ctx.status(400).json("{\"message\": \"Invalid ID format\"}");
            return;
        }

        User user = userDAO.findUser(username);
        Artist artist = artistDAO.getById(artistId); // Husk at implementere getById i ArtistDAO

        if (user != null && artist != null) {
            user.addFavorite(artist);
            userDAO.update(user); // Gemmer relationen i DB

            // Returner den opdaterede liste som DTO'er
            List<ArtistDTO> favoriteDTOs = user.getFavorites().stream()
                    .map(ArtistDTO::new)
                    .collect(Collectors.toList());

            ctx.status(201).json(favoriteDTOs);
        } else {
            ctx.status(404).json("{\"message\": \"User or Artist not found\"}");
        }
    }

    // DELETE: Fjern favorit
    public void removeFavorite(Context ctx) {
        String username = getUsernameFromToken(ctx);
        int artistId;
        try {
            artistId = Integer.parseInt(ctx.pathParam("id"));
        } catch (NumberFormatException e) {
            ctx.status(400).json("{\"message\": \"Invalid ID format\"}");
            return;
        }

        User user = userDAO.findUser(username);
        Artist artist = artistDAO.getById(artistId);

        if (user != null && artist != null) {
            user.removeFavorite(artist);
            userDAO.update(user);

            // Returner den opdaterede liste
            List<ArtistDTO> favoriteDTOs = user.getFavorites().stream()
                    .map(ArtistDTO::new)
                    .collect(Collectors.toList());

            ctx.status(200).json(favoriteDTOs);
        } else {
            ctx.status(404).json("{\"message\": \"Resource not found\"}");
        }
    }

    // --- MOCK TOKEN HELPER ---
    private String getUsernameFromToken(Context ctx) {
        String token = ctx.header("Authorization");
        // Simpel logik til test
        if (token == null) return "guest";
        if (token.contains("admin")) return "admin";
        if (token.contains("user")) return "user";
        return "guest";
    }
}