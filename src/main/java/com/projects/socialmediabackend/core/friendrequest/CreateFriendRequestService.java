package com.projects.socialmediabackend.core.friendrequest;

import com.projects.socialmediabackend.api.friendrequest.create.CreateFriendRequestInput;
import com.projects.socialmediabackend.api.friendrequest.create.CreateFriendRequestOperation;
import com.projects.socialmediabackend.api.friendrequest.create.CreateFriendRequestOutput;
import com.projects.socialmediabackend.persistence.model.FriendRequest;
import com.projects.socialmediabackend.persistence.model.User;
import com.projects.socialmediabackend.persistence.model.enums.friendrequest.FriendRequestStatus;
import com.projects.socialmediabackend.persistence.repository.FriendRequestRepository;
import com.projects.socialmediabackend.persistence.repository.UserRepository;

import com.projects.socialmediabackend.rest.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateFriendRequestService implements CreateFriendRequestOperation {
    private final FriendRequestRepository friendRequestRepository;
    private final UserRepository userRepository;
    @Override
    public CreateFriendRequestOutput process(CreateFriendRequestInput request) {
        User toUser = userRepository.findById(UUID.fromString(request.getToUser()))
                .orElseThrow(()->new EntityNotFoundException("User Not Found"));
        FriendRequest friendRequest = FriendRequest.builder()
                .fromUser(request.getFromUser())
                .toUser(toUser)
                .status(FriendRequestStatus.Waiting)
                .build();
        friendRequestRepository.save(friendRequest);

        return CreateFriendRequestOutput.builder()
                .responseMessage("Friend request sent to " + toUser.getFirstName()+" "+toUser.getLastName())
                .build();
    }
}
