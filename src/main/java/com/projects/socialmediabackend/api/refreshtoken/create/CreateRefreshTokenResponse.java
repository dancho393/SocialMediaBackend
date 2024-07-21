package com.projects.socialmediabackend.api.refreshtoken.create;

import com.projects.socialmediabackend.api.base.OperationResponse;
import com.projects.socialmediabackend.persistence.model.RefreshToken;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateRefreshTokenResponse implements OperationResponse {
    private RefreshToken refreshToken;
}
