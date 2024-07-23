package com.projects.socialmediabackend.api.refreshtoken;

import com.projects.socialmediabackend.api.base.OperationResponse;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefreshTokenResponse implements OperationResponse {
    private String jwtToken;
    private String refreshToken;
}
