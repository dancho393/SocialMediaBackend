package com.projects.socialmediabackend.api.user.login;

import com.projects.socialmediabackend.api.base.Operation;
import com.projects.socialmediabackend.api.user.register.UserRegisterRequest;
import com.projects.socialmediabackend.api.user.register.UserRegisterResponse;

public interface UserLogInOperation extends Operation<UserLoginRequest, UserLoginResponse> {

    UserLoginResponse process(UserLoginRequest request);
}
