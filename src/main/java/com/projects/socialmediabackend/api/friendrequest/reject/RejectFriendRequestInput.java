package com.projects.socialmediabackend.api.friendrequest.reject;

import com.projects.socialmediabackend.api.base.OperationRequest;
import com.projects.socialmediabackend.persistence.model.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RejectFriendRequestInput implements OperationRequest {
    private String friendRequestId;
    private User loggedUser;
}
