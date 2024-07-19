package com.projects.socialmediabackend.api.friendrequest.accept;

import com.projects.socialmediabackend.api.base.OperationRequest;
import com.projects.socialmediabackend.persistence.model.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcceptFriendRequestInput implements OperationRequest {
    private String friendRequestId;
    private User loggedUser;

}
