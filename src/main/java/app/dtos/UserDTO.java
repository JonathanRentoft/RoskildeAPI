package app.dtos;

import app.entities.User;

// En record er en "immutable" databærer.
public record UserDTO(String username, String role) {
    // En lille hjælpe-constructor, der konverterer fra Entity til DTO
    public UserDTO(User user) {
        this(user.getUsername(), user.getRole().toString());
    }
}