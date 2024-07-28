package com.projects.socialmediabackend.api.friendrequest.getforuser;

import com.projects.socialmediabackend.api.base.Operation;

public interface GetFriendRequestsForUserOperation extends Operation<GetFriendRequestsForUserInput, GetFriendRequestsForUserOutput> {
    @Override
    GetFriendRequestsForUserOutput process(GetFriendRequestsForUserInput request);
}
