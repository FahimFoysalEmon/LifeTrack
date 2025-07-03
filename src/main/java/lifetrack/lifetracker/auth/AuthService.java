package lifetrack.lifetracker.auth;

import lifetrack.lifetracker.auth.models.AuthRequest;
import lifetrack.lifetracker.auth.models.AuthResponse;
import lifetrack.lifetracker.auth.models.RegisterRequest;
import lifetrack.lifetracker.auth.models.TokenRefreshRequest;
import lifetrack.lifetracker.token.JwtService;
import lifetrack.lifetracker.user.Role;
import lifetrack.lifetracker.user.UserEntity;
import lifetrack.lifetracker.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private static final long ACCESS_TOKEN_EXP = 15 * 60 * 1000; // 15 min
    private static final long REFRESH_TOKEN_EXP = 7 * 24 * 60 * 60 * 1000; // 7 days

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.findByEmail(request.username()).isPresent()) {
            throw new RuntimeException("Email already in use");
        }

        System.out.println();

        UserEntity user = UserEntity.builder()
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return generateTokens(user);
    }

    public AuthResponse login(AuthRequest request) {
        UserEntity user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new BadCredentialsException("Invalid credentials");
        }

        return generateTokens(user);
    }

    public AuthResponse refreshToken(TokenRefreshRequest request) {
        String refreshToken = request.refreshToken();
        String username = jwtService.extractUsername(refreshToken);

        UserEntity user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!jwtService.isTokenValid(refreshToken, user)) {
            throw new RuntimeException("Invalid refresh token");
        }

        return generateTokens(user);
    }

    private AuthResponse generateTokens(UserEntity user) {
        String accessToken = jwtService.generateToken(user, ACCESS_TOKEN_EXP);
        String refreshToken = jwtService.generateToken(user, REFRESH_TOKEN_EXP);
        return new AuthResponse(accessToken, refreshToken);
    }
}

