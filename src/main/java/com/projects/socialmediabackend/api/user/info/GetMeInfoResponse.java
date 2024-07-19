package com.projects.socialmediabackend.api.user.info;

import com.projects.socialmediabackend.api.base.OperationResponse;
import com.projects.socialmediabackend.persistence.model.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetMeInfoResponse implements OperationResponse {
    private User user;
}
