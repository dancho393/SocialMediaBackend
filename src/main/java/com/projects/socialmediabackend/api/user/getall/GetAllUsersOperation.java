package com.projects.socialmediabackend.api.user.getall;

import com.projects.socialmediabackend.api.base.Operation;

public interface GetAllUsersOperation extends Operation<GetAllUsersRequest, GetAllUsersResponse> {
    @Override
    GetAllUsersResponse process(GetAllUsersRequest request);
}
