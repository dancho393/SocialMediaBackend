package com.projects.socialmediabackend.api.friendrequest.reject;

import com.projects.socialmediabackend.api.base.OperationResponse;
import com.projects.socialmediabackend.persistence.model.FriendRequest;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RejectFriendRequestOutput implements OperationResponse {
    private String message;
    private FriendRequest friendRequest;
}
