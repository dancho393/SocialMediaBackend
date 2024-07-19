package com.projects.socialmediabackend.rest.controller;

import com.projects.socialmediabackend.api.user.info.GetMeInfoOperation;
import com.projects.socialmediabackend.api.user.info.GetMeInfoRequest;
import com.projects.socialmediabackend.api.user.info.GetMeInfoResponse;
import com.projects.socialmediabackend.api.user.login.UserLogInOperation;

import com.projects.socialmediabackend.api.user.login.UserLoginRequest;
import com.projects.socialmediabackend.api.user.login.UserLoginResponse;
import com.projects.socialmediabackend.api.user.register.UserRegisterOperation;
import com.projects.socialmediabackend.api.user.register.UserRegisterRequest;
import com.projects.socialmediabackend.api.user.register.UserRegisterResponse;
import com.projects.socialmediabackend.persistence.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth/users")
public class AuthenticationController {
    private final UserRegisterOperation userRegisterOperation;
    private final UserLogInOperation userLogInOperation;
    private final GetMeInfoOperation getMeInfoOperation;

    @PostMapping
    public ResponseEntity<UserRegisterResponse> register(@RequestBody UserRegisterRequest request) {
        return ResponseEntity.ok(userRegisterOperation.process(request));
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login (@RequestBody UserLoginRequest request) {
        return ResponseEntity.ok(userLogInOperation.process(request));
    }
    @GetMapping("/me")
    public ResponseEntity<GetMeInfoResponse> getMeInfoResponse(
            @AuthenticationPrincipal User user
    ){
        GetMeInfoRequest request = new GetMeInfoRequest(user);
        return ResponseEntity.ok(getMeInfoOperation.process(request));
    }
}
