package com.projects.socialmediabackend.api.refreshtoken.create;

import com.projects.socialmediabackend.api.base.Operation;

public interface CreateRefreshTokenOperation extends Operation<CreateRefreshTokenRequest,CreateRefreshTokenResponse> {
    @Override
    CreateRefreshTokenResponse process(CreateRefreshTokenRequest request);
}
