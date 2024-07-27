package com.projects.socialmediabackend.api.user.getall;

import com.projects.socialmediabackend.api.base.OperationRequest;
import com.projects.socialmediabackend.persistence.model.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllUsersRequest implements OperationRequest {
    private User exceptionalUser;
}
