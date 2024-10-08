package com.projects.socialmediabackend.api.user.login;

import com.projects.socialmediabackend.api.base.OperationResponse;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginResponse implements OperationResponse {
    @NonNull
    private String jwtToken;
    @NonNull
    private String refreshToken;
}
