package com.projects.socialmediabackend.rest.controller;

import com.projects.socialmediabackend.api.user.getall.GetAllUsersOperation;
import com.projects.socialmediabackend.api.user.getall.GetAllUsersRequest;
import com.projects.socialmediabackend.api.user.getall.GetAllUsersResponse;
import com.projects.socialmediabackend.api.user.info.GetMeInfoOperation;
import com.projects.socialmediabackend.api.user.info.GetMeInfoRequest;
import com.projects.socialmediabackend.api.user.info.GetMeInfoResponse;
import com.projects.socialmediabackend.persistence.model.User;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    private final GetAllUsersOperation getAllUsersOperation;
    private final GetMeInfoOperation getMeInfoOperation;

    @GetMapping("/all")
    public ResponseEntity<GetAllUsersResponse> getAllUsers(@AuthenticationPrincipal User user) {
        GetAllUsersRequest request = new GetAllUsersRequest(user);

        return ResponseEntity.ok().body(getAllUsersOperation.process(request));
    }
    @GetMapping("/me")
    public ResponseEntity<GetMeInfoResponse> getMeInfoResponse(
            @AuthenticationPrincipal User user
    ){
        GetMeInfoRequest request = new GetMeInfoRequest(user);
        return ResponseEntity.ok(getMeInfoOperation.process(request));
    }
}
