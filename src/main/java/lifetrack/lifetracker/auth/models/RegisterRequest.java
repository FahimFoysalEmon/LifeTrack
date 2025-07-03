package lifetrack.lifetracker.auth.models;


public record RegisterRequest(
        String username,
        String email,
        String password
) {}
