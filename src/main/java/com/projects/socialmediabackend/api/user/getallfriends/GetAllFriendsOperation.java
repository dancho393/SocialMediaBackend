package com.projects.socialmediabackend.api.user.getallfriends;

import com.projects.socialmediabackend.api.base.Operation;

public interface GetAllFriendsOperation extends Operation<GetAllFriendsRequest,GetAllFriendsResponse> {
    @Override
    GetAllFriendsResponse process(GetAllFriendsRequest request);
}
