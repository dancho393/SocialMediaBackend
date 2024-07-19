package com.projects.socialmediabackend.api.user.info;

import com.projects.socialmediabackend.api.base.OperationRequest;
import com.projects.socialmediabackend.persistence.model.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetMeInfoRequest implements OperationRequest {
    @NonNull
    private User currentUser;
}
