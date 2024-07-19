package com.projects.socialmediabackend.core.friendrequest;

import com.projects.socialmediabackend.api.friendrequest.reject.RejectFriendRequestInput;
import com.projects.socialmediabackend.api.friendrequest.reject.RejectFriendRequestOperation;
import com.projects.socialmediabackend.api.friendrequest.reject.RejectFriendRequestOutput;
import com.projects.socialmediabackend.persistence.model.FriendRequest;
import com.projects.socialmediabackend.persistence.model.User;
import com.projects.socialmediabackend.persistence.model.enums.friendrequest.FriendRequestStatus;
import com.projects.socialmediabackend.persistence.repository.FriendRequestRepository;
import com.projects.socialmediabackend.persistence.repository.UserRepository;
import com.projects.socialmediabackend.rest.exception.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RejectFriendRequestService implements RejectFriendRequestOperation {
    private final FriendRequestRepository friendRequestRepository;

    @Override
    @Transactional
    public RejectFriendRequestOutput process(RejectFriendRequestInput request) {
        FriendRequest friendRequest = friendRequestRepository.findById(UUID.fromString(request.getFriendRequestId()))
                .orElseThrow(() ->new EntityNotFoundException("FriendRequest Not Found With Id:"+request.getFriendRequestId()));
        if(request.getLoggedUser().equals(friendRequest.getToUser())&&friendRequest.getStatus().equals(FriendRequestStatus.Waiting)){
            friendRequest.setStatus(FriendRequestStatus.Rejected);
            friendRequestRepository.save(friendRequest);
            return RejectFriendRequestOutput.builder()
                    .message("Rejected Friend Request")
                    .friendRequest(friendRequest)
                    .build();
        }
        return RejectFriendRequestOutput.builder()
                .message("Wrong User Access" )
                .build();
    }
}
