package com.projects.socialmediabackend.core.friendrequest;

import com.projects.socialmediabackend.api.friendrequest.getforuser.GetFriendRequestsForUserInput;
import com.projects.socialmediabackend.api.friendrequest.getforuser.GetFriendRequestsForUserOperation;
import com.projects.socialmediabackend.api.friendrequest.getforuser.GetFriendRequestsForUserOutput;
import com.projects.socialmediabackend.api.mapper.FriendRequestMapper;
import com.projects.socialmediabackend.persistence.model.FriendRequest;
import com.projects.socialmediabackend.persistence.model.enums.friendrequest.FriendRequestStatus;
import com.projects.socialmediabackend.persistence.repository.FriendRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetFriendsRequestsForUserService implements GetFriendRequestsForUserOperation {
    private final FriendRequestRepository friendRequestRepository;
    private final FriendRequestMapper friendRequestMapper;
    @Override
    public GetFriendRequestsForUserOutput process(GetFriendRequestsForUserInput request) {
        List<FriendRequest> friendRequests =
                friendRequestRepository
                        .findAllByToUserAndStatus(
                                request.getUser(),
                                FriendRequestStatus.Waiting);


        return  GetFriendRequestsForUserOutput
                .builder()
                .userDTOS(friendRequestMapper.toFriendRequestUserDTOList(friendRequests))
                .build();
    }
}
