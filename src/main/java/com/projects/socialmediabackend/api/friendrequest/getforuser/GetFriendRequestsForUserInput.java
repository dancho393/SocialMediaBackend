package com.projects.socialmediabackend.api.friendrequest.getforuser;

import com.projects.socialmediabackend.api.base.OperationRequest;
import com.projects.socialmediabackend.persistence.model.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetFriendRequestsForUserInput implements OperationRequest {
    private User user;
}
