package com.projects.socialmediabackend.api.friendrequest.create;

import com.projects.socialmediabackend.api.base.Operation;

public interface CreateFriendRequestOperation extends Operation<CreateFriendRequestInput,CreateFriendRequestOutput> {
    @Override
    CreateFriendRequestOutput process(CreateFriendRequestInput request);
}
