package com.projects.socialmediabackend.core.user;

import com.projects.socialmediabackend.api.mapper.UserMapper;
import com.projects.socialmediabackend.api.user.register.UserRegisterOperation;
import com.projects.socialmediabackend.api.user.register.UserRegisterRequest;
import com.projects.socialmediabackend.api.user.register.UserRegisterResponse;
import com.projects.socialmediabackend.persistence.model.User;
import com.projects.socialmediabackend.persistence.model.enums.user.Role;
import com.projects.socialmediabackend.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@RequiredArgsConstructor
@Service
@Validated
public class UserRegisterService implements UserRegisterOperation {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserRegisterResponse process(UserRegisterRequest request) {
        User user = userMapper.fromRequestToUser(request);
        user.setRole(Role.User);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
        return userMapper.toUserRegisterResponse(user);
    }
}
