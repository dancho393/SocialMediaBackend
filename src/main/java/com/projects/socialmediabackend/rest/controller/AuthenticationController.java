package com.projects.socialmediabackend.rest.controller;
import com.projects.socialmediabackend.api.refreshtoken.RefreshTokenOperation;
import com.projects.socialmediabackend.api.refreshtoken.RefreshTokenRequest;
import com.projects.socialmediabackend.api.refreshtoken.RefreshTokenResponse;
import com.projects.socialmediabackend.api.user.login.UserLogInOperation;
import com.projects.socialmediabackend.api.user.login.UserLoginRequest;
import com.projects.socialmediabackend.api.user.login.UserLoginResponse;
import com.projects.socialmediabackend.api.user.register.UserRegisterOperation;
import com.projects.socialmediabackend.api.user.register.UserRegisterRequest;
import com.projects.socialmediabackend.api.user.register.UserRegisterResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;




@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth/users")
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*")
@Validated
public class AuthenticationController {
    private final UserRegisterOperation userRegisterOperation;
    private final UserLogInOperation userLogInOperation;
    private final RefreshTokenOperation refreshTokenOperation;


    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> register(
             @RequestBody UserRegisterRequest request) {
        return ResponseEntity.ok(userRegisterOperation.process(request));
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login ( @RequestBody UserLoginRequest request) {
        return ResponseEntity.ok(userLogInOperation.process(request));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<RefreshTokenResponse> refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ){
        RefreshTokenRequest refreshTokenRequest =
                new RefreshTokenRequest(request,response);

        return ResponseEntity.ok(refreshTokenOperation.process(refreshTokenRequest));
    }
}
