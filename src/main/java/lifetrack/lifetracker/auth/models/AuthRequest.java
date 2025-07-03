package lifetrack.lifetracker.auth.models;

public record AuthRequest(
        String email,
        String password
) {}
