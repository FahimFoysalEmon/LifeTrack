package lifetrack.lifetracker.auth;

import jakarta.validation.Valid;
import lifetrack.lifetracker.auth.models.AuthRequest;
import lifetrack.lifetracker.auth.models.AuthResponse;
import lifetrack.lifetracker.auth.models.RegisterRequest;
import lifetrack.lifetracker.auth.models.TokenRefreshRequest;
import lifetrack.lifetracker.common.response.ApiResponse;
import lifetrack.lifetracker.token.JwtService;
import lifetrack.lifetracker.user.Role;
import lifetrack.lifetracker.user.UserEntity;
import lifetrack.lifetracker.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder encoder;
    private final AuthService authService;


    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<AuthResponse>> register(@RequestBody @Valid RegisterRequest request) {
        return ResponseEntity.ok(ApiResponse.success("User registered", authService.register(request)));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(@RequestBody @Valid AuthRequest request) {
        return ResponseEntity.ok(ApiResponse.success("Login successful", authService.login(request)));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<ApiResponse<AuthResponse>> refresh(@RequestBody TokenRefreshRequest request) {
        return ResponseEntity.ok(ApiResponse.success("Token refreshed", authService.refreshToken(request)));
    }
}

