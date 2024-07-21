package com.projects.socialmediabackend.api.refreshtoken.create;

import com.projects.socialmediabackend.api.base.OperationRequest;
import com.projects.socialmediabackend.persistence.model.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateRefreshTokenRequest implements OperationRequest {
    private User user;
}
