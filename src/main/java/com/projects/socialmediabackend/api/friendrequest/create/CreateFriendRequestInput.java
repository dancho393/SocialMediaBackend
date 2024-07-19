package com.projects.socialmediabackend.api.friendrequest.create;

import com.projects.socialmediabackend.api.base.OperationRequest;
import com.projects.socialmediabackend.persistence.model.User;
import jakarta.annotation.Nullable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateFriendRequestInput implements OperationRequest {
    private User fromUser;
    private String toUser;
}
