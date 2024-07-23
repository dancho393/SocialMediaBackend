package com.projects.socialmediabackend.api.user.login;

import com.projects.socialmediabackend.api.base.OperationRequest;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;



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
