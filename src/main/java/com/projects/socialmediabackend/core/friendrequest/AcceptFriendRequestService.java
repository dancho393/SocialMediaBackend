package com.projects.socialmediabackend.core.friendrequest;

import com.projects.socialmediabackend.api.friendrequest.accept.AcceptFriendRequestInput;
import com.projects.socialmediabackend.api.friendrequest.accept.AcceptFriendRequestOperation;
import com.projects.socialmediabackend.api.friendrequest.accept.AcceptFriendRequestOutput;
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
public class AcceptFriendRequestService implements AcceptFriendRequestOperation {
    private final FriendRequestRepository friendRequestRepository;
    private final UserRepository userRepository;

    @Override
    public AcceptFriendRequestOutput process(AcceptFriendRequestInput request) {
        FriendRequest friendRequest =
                friendRequestRepository.findById(UUID.fromString(request.getFriendRequestId()))
                .orElseThrow(
                        () ->new EntityNotFoundException(
                                "FriendRequest Not Found With Id:"+request.getFriendRequestId()));
        if(request.getLoggedUser().equals(friendRequest.getToUser())
                &&friendRequest.getStatus().equals(FriendRequestStatus.Waiting)) {

            friendRequest.setStatus(FriendRequestStatus.Accepted);
            friendRequestRepository.save(friendRequest);
            User toUser=friendRequest.getToUser();
            User fromUser=friendRequest.getFromUser();
            toUser.getFriendRequests().add(friendRequest);
            fromUser.getFriendRequests().add(friendRequest);

            userRepository.save(toUser);
            userRepository.save(fromUser);
            return AcceptFriendRequestOutput.builder()
                    .message("Accepted friend request")
                    .friendRequest(friendRequest)
                    .build();
        }
        return AcceptFriendRequestOutput.builder()
                .message("Wrong User Access")
                .build();
    }
}
