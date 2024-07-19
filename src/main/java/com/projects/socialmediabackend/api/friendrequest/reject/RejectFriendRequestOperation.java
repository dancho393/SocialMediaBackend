package com.projects.socialmediabackend.api.friendrequest.reject;

import com.projects.socialmediabackend.api.base.Operation;

public interface RejectFriendRequestOperation extends Operation<RejectFriendRequestInput, RejectFriendRequestOutput> {
    @Override
    RejectFriendRequestOutput process(RejectFriendRequestInput request);
}
