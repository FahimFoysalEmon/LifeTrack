package lifetrack.lifetracker.auth.models;

public record AuthResponse(
        String accessToken,
        String refreshToken
) {}
