package com.projects.socialmediabackend.core.refreshtoken;

import com.projects.socialmediabackend.api.refreshtoken.RefreshTokenOperation;
import com.projects.socialmediabackend.api.refreshtoken.RefreshTokenRequest;
import com.projects.socialmediabackend.api.refreshtoken.RefreshTokenResponse;
import com.projects.socialmediabackend.core.jwt.JwtService;
import com.projects.socialmediabackend.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenService implements RefreshTokenOperation {
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final UserDetailsService userDetailsService;
    @Override
    public RefreshTokenResponse process(RefreshTokenRequest request) {
        final String authHeader = request.getRequest().getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String username;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return null;
        }
        refreshToken = authHeader.substring(7);
        username = jwtService.extractUsername(refreshToken);
        if (username != null) {
            UserDetails user = this.userDetailsService.loadUserByUsername(username);
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                return RefreshTokenResponse.builder()
                        .jwtToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
            }
        }
        return null;
    }
}
