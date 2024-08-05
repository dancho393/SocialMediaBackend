package com.projects.socialmediabackend.api.user.getallfriends;

import com.projects.socialmediabackend.api.base.OperationRequest;
import com.projects.socialmediabackend.persistence.model.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllFriendsRequest implements OperationRequest {
    private User user;
}
