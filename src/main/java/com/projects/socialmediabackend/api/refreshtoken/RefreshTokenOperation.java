package com.projects.socialmediabackend.api.refreshtoken;

import com.projects.socialmediabackend.api.base.Operation;

public interface RefreshTokenOperation extends Operation<RefreshTokenRequest, RefreshTokenResponse> {
    @Override
    RefreshTokenResponse process(RefreshTokenRequest request);
}
