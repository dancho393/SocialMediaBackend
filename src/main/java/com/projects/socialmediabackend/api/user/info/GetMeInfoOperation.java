package com.projects.socialmediabackend.api.user.info;

import com.projects.socialmediabackend.api.base.Operation;

public interface GetMeInfoOperation extends Operation<GetMeInfoRequest,GetMeInfoResponse> {
    @Override
    GetMeInfoResponse process(GetMeInfoRequest request);
}
