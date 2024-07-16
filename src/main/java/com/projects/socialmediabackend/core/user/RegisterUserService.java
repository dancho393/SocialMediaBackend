package com.projects.socialmediabackend.core.user;

import com.projects.socialmediabackend.api.user.register.UserRegisterOperation;
import com.projects.socialmediabackend.api.user.register.UserRegisterRequest;
import com.projects.socialmediabackend.api.user.register.UserRegisterResponse;
import com.projects.socialmediabackend.persistence.model.User;
import com.projects.socialmediabackend.persistence.model.enums.user.Role;
import com.projects.socialmediabackend.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegisterUserService implements UserRegisterOperation {
    private final UserRepository userRepository;
    @Override
    public UserRegisterResponse process(UserRegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .phone(request.getPhone())
                .address(request.getAddress())
                .city(request.getCity())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .role(Role.User)
                .build();
        userRepository.save(user);
        return UserRegisterResponse.builder()
                .user(user)
                .build();
    }
}
