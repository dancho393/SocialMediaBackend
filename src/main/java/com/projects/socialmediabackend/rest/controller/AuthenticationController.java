package com.projects.socialmediabackend.rest.controller;

import com.projects.socialmediabackend.api.user.login.UserLogInOperation;

import com.projects.socialmediabackend.api.user.login.UserLoginRequest;
import com.projects.socialmediabackend.api.user.login.UserLoginResponse;
import com.projects.socialmediabackend.api.user.register.UserRegisterOperation;
import com.projects.socialmediabackend.api.user.register.UserRegisterRequest;
import com.projects.socialmediabackend.api.user.register.UserRegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequiredArgsConstructor
@RequestMapping("api/v1/auth/users")
public class AuthenticationController {
    private final UserRegisterOperation userRegisterOperation;
    private final UserLogInOperation userLogInOperation;

    @PostMapping
    public ResponseEntity<UserRegisterResponse> register(@RequestBody UserRegisterRequest request) {
        return ResponseEntity.ok(userRegisterOperation.process(request));
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login (@RequestBody UserLoginRequest request) {
        return ResponseEntity.ok(userLogInOperation.process(request));
    }
}
