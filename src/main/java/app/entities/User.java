package app.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users") // 'user' er et reserveret ord i SQL, så vi bruger 'users'
public class User {

    @Id
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role; // "admin" eller "user"

    // Many-To-Many: En bruger har mange favorit-artister
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_favorites",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private Set<Artist> favorites = new HashSet<>();

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public void addFavorite(Artist artist) {
        this.favorites.add(artist);
    }

    public void removeFavorite(Artist artist) {
        this.favorites.remove(artist);
    }
}