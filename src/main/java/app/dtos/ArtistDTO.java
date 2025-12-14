package app.dtos;

import app.entities.Artist;

public record ArtistDTO(
        int id,
        String name,
        String stage,
        String day,
        String time,
        String genre,
        String description
) {
    // Convenience constructor der tager en Entity og laver den til en DTO
    public ArtistDTO(Artist artist) {
        this(
                artist.getId(),           // Vigtig! Sørg for at din Artist entity har en getId() metode
                artist.getName(),
                artist.getStage(),
                artist.getDay(),
                artist.getTime(),
                artist.getGenre(),
                artist.getDescription()
        );
    }
}