package com.projects.socialmediabackend.api.friendrequest.accept;

import com.projects.socialmediabackend.api.base.OperationResponse;
import com.projects.socialmediabackend.persistence.model.FriendRequest;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcceptFriendRequestOutput implements OperationResponse {
    private String message;
    private FriendRequest friendRequest;
}
