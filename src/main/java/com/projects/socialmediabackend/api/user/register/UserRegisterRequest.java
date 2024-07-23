package com.projects.socialmediabackend.api.user.register;

import com.projects.socialmediabackend.api.base.OperationRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.validation.annotation.Validated;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterRequest implements OperationRequest {
    @NotEmpty(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;

    @NotEmpty(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotEmpty(message = "First name is required")
    @Size(max = 50, message = "First name cannot be more than 50 characters")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    @Size(max = 50, message = "Last name cannot be more than 50 characters")
    private String lastName;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty(message = "Phone number is required")
    @Pattern(regexp = "\\d{13}", message = "Phone number must be 12 digits")
    private String phone;

    @Size(max = 100, message = "Address cannot be more than 100 characters")
    private String address;

    @Size(max = 50, message = "City cannot be more than 50 characters")
    private String city;


}
