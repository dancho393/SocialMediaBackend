package com.projects.socialmediabackend.rest.controller;

import com.projects.socialmediabackend.api.friendrequest.accept.AcceptFriendRequestInput;
import com.projects.socialmediabackend.api.friendrequest.accept.AcceptFriendRequestOperation;
import com.projects.socialmediabackend.api.friendrequest.accept.AcceptFriendRequestOutput;
import com.projects.socialmediabackend.api.friendrequest.create.CreateFriendRequestInput;
import com.projects.socialmediabackend.api.friendrequest.create.CreateFriendRequestOperation;
import com.projects.socialmediabackend.api.friendrequest.create.CreateFriendRequestOutput;
import com.projects.socialmediabackend.api.friendrequest.reject.RejectFriendRequestInput;
import com.projects.socialmediabackend.api.friendrequest.reject.RejectFriendRequestOperation;
import com.projects.socialmediabackend.api.friendrequest.reject.RejectFriendRequestOutput;
import com.projects.socialmediabackend.persistence.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/friend-requests")
public class FriendRequestController {
    private final CreateFriendRequestOperation createFriendRequestOperation;
    private final AcceptFriendRequestOperation acceptFriendRequestOperation;
    private final RejectFriendRequestOperation rejectFriendRequestOperation;
    @PostMapping
    public ResponseEntity<CreateFriendRequestOutput> createFriendRequest(
            @RequestBody CreateFriendRequestInput request,
            @AuthenticationPrincipal User fromUser) {

            request.setFromUser(fromUser);
            return ResponseEntity.ok(createFriendRequestOperation.process(request));
    }
    @PatchMapping("/accept")
    public ResponseEntity<AcceptFriendRequestOutput> acceptFriendRequest(
            @RequestBody AcceptFriendRequestInput request,
            @AuthenticationPrincipal User fromUser) {
        request.setLoggedUser(fromUser);
        return ResponseEntity.ok(acceptFriendRequestOperation.process(request));
    }
    @PatchMapping("/reject")
    public ResponseEntity<RejectFriendRequestOutput> rejectFriendRequest(
            @RequestBody RejectFriendRequestInput request,
            @AuthenticationPrincipal User fromUser
    ){
        request.setLoggedUser(fromUser);
        return ResponseEntity.ok(rejectFriendRequestOperation.process(request));
    }


}
