package com.projects.socialmediabackend.api.user.login;

import com.projects.socialmediabackend.api.base.OperationRequest;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginRequest implements OperationRequest {
    @NotEmpty(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;
    @NotEmpty(message = "Password is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String password;
}
