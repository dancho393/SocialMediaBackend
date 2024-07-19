package com.projects.socialmediabackend.core.user;

import com.projects.socialmediabackend.api.user.login.UserLogInOperation;

import com.projects.socialmediabackend.api.user.login.UserLoginRequest;
import com.projects.socialmediabackend.api.user.login.UserLoginResponse;
import com.projects.socialmediabackend.core.jwt.JwtService;
import com.projects.socialmediabackend.persistence.model.User;
import com.projects.socialmediabackend.persistence.repository.UserRepository;

import com.projects.socialmediabackend.rest.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLogInService implements UserLogInOperation {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserLoginResponse process(UserLoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()));

        User user = userRepository.
                findByUsernameIgnoreCase(
                        request.getUsername())
                .orElseThrow(()-> new EntityNotFoundException("USER WAS NOT FOUND"));
        String jwtToken = jwtService.generateToken(user);
        return UserLoginResponse
                .builder()
                .jwtToken(jwtToken)
                .build();
    }
}
