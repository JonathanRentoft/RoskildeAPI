package app.controllers;

import app.daos.ArtistDAO;
import app.entities.Artist;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ArtistController {
    private final ArtistDAO artistDAO;

    public ArtistController(ArtistDAO artistDAO) {
        this.artistDAO = artistDAO;
    }

    public void getAllArtists(Context ctx) {
        List<Artist> artists = artistDAO.getAll();
        ctx.json(artists);
    }

    public void createArtist(Context ctx) {
        Artist newArtist = ctx.bodyAsClass(Artist.class);
        Artist created = artistDAO.create(newArtist);
        ctx.status(201).json(created);
    }

    public void deleteArtist(@NotNull Context context) {
        int id = Integer.parseInt(context.pathParam("id"));
        artistDAO.delete(id);
    }

    public void updateArtist(@NotNull Context context) {
        int id = Integer.parseInt(context.pathParam("id"));
    }
}