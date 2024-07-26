package com.projects.socialmediabackend.rest.controller;

import com.projects.socialmediabackend.api.chat.getall.GetAllChatsOperation;
import com.projects.socialmediabackend.api.chat.getall.GetAllChatsRequest;
import com.projects.socialmediabackend.api.chat.getall.GetAllChatsResponse;
import com.projects.socialmediabackend.persistence.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Validated
@RequiredArgsConstructor
public class ChatController {
    private final GetAllChatsOperation getAllChatsOperation;

    @GetMapping
    public ResponseEntity<GetAllChatsResponse> getChatsForUser(
            @AuthenticationPrincipal User user
    ){
        GetAllChatsRequest request = new GetAllChatsRequest(user);
        return ResponseEntity.ok().body(getAllChatsOperation.process(request));
    }
}
