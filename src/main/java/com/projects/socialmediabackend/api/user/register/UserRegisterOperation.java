package com.projects.socialmediabackend.api.user.register;

import com.projects.socialmediabackend.api.base.Operation;

public interface UserRegisterOperation extends Operation<UserRegisterRequest, UserRegisterResponse> {
    @Override
    UserRegisterResponse process(UserRegisterRequest request);
}
