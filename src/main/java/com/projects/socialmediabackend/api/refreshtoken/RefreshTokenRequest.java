package com.projects.socialmediabackend.api.refreshtoken;

import com.projects.socialmediabackend.api.base.OperationRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefreshTokenRequest implements OperationRequest {
    private HttpServletRequest request;
    private HttpServletResponse response;
}
