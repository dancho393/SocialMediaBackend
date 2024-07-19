package com.projects.socialmediabackend.api.friendrequest.accept;

import com.projects.socialmediabackend.api.base.Operation;

public interface AcceptFriendRequestOperation extends Operation<AcceptFriendRequestInput,AcceptFriendRequestOutput> {
    @Override
    AcceptFriendRequestOutput process(AcceptFriendRequestInput request);
}
