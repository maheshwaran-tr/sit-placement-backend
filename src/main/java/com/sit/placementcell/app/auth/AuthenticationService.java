package com.sit.placementcell.app.auth;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sit.placementcell.app.config.JwtService;
import com.sit.placementcell.app.service.AdminService;
import com.sit.placementcell.app.service.StaffService;
import com.sit.placementcell.app.service.StudentService;
import com.sit.placementcell.app.token.Token;
import com.sit.placementcell.app.token.TokenRepository;
import com.sit.placementcell.app.token.TokenType;
import com.sit.placementcell.app.user.User;
import com.sit.placementcell.app.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.sit.placementcell.app.user.Role.*;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final TokenRepository tokenRepository;
    private final StudentService studentService;
    private final StaffService staffService;
    private final AdminService adminService;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .student(request.getStudent())
                .staff(request.getStaff())
                .admin(request.getAdmin())
                .build();

        switch (user.getRole()){
            case STUDENT -> studentService.save(request.getStudent());
            case ADMIN -> adminService.save(request.getAdmin());
            case STAFF -> staffService.save(request.getStaff());
        }

        var savedUser = repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(savedUser, jwtToken);

        if (user.getRole() == STUDENT) {
            return new StudentAuthenticationResponse(jwtToken, refreshToken, user.getStudent());
        } else if (user.getRole() == STAFF) {
            return new StaffAuthenticationResponse(jwtToken, refreshToken, user.getStaff());
        } else if (user.getRole() == ADMIN) {
            return new AdminAuthenticationResponse(jwtToken, refreshToken, user.getAdmin());
        } else {
            System.out.println("4.*********************");
            return AuthenticationResponse.builder()
                    .accessToken(jwtToken)
                    .refreshToken(refreshToken)
                    .build();
        }
    }


    public AuthenticationResponse authenticate(AuthenticateRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = repository.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);

        if (user.getRole() == STUDENT) {
            System.out.println("1.*********************");
            return new StudentAuthenticationResponse(jwtToken, refreshToken, user.getStudent());
        } else if (user.getRole() == STAFF) {
            System.out.println("2.*********************");
            return new StaffAuthenticationResponse(jwtToken, refreshToken, user.getStaff());
        } else if (user.getRole() == ADMIN) {
            System.out.println("3.*********************");
            return new AdminAuthenticationResponse(jwtToken, refreshToken, user.getAdmin());
        } else {
            System.out.println("4.*********************");
            System.out.println(user.getRole());
            return AuthenticationResponse.builder()
                    .accessToken(jwtToken)
                    .refreshToken(refreshToken)
                    .build();
        }
    }

    private void revokeAllUserTokens(User user) {
        var validTokens = tokenRepository.findAllValidTokenByUser(user.getUserId());
        if (validTokens.isEmpty()) {
            return;
        }
        validTokens.forEach(t -> {
            t.setExpired(true);
            t.setRevoked(true);
        });
        tokenRepository.saveAll(validTokens);
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .revoked(false)
                .expired(false)
                .build();
        tokenRepository.save(token);
    }

    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String username;

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }

        // getting token
        refreshToken = authHeader.substring(7);
        username = jwtService.extractUsername(refreshToken);

        // getting username from token
        if (username != null) {
            var user = this.repository.findByUsername(username).orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}
