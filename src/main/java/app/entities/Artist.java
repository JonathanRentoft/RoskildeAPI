package app.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    private String stage;

    private String day;  // Ny felt: F.eks. "Fredag"

    private String time; // Ny felt: F.eks. "22:00"

    private String genre;

    private String description;

    // Opdateret constructor der tager day og time separat
    public Artist(String name, String stage, String day, String time, String genre, String description) {
        this.name = name;
        this.stage = stage;
        this.day = day;
        this.time = time;
        this.genre = genre;
        this.description = description;
    }
    public Integer getId() {
        return id;
    }
}