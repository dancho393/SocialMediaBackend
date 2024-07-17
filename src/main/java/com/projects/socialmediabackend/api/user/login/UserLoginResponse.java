package com.projects.socialmediabackend.api.user.login;

import com.projects.socialmediabackend.api.base.OperationResponse;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginResponse implements OperationResponse {
    @NonNull
    @NotEmpty
    private String jwtToken;
}
