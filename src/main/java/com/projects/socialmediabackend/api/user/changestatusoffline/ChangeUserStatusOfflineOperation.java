package com.projects.socialmediabackend.api.user.changestatusoffline;

import com.projects.socialmediabackend.api.base.Operation;

public interface ChangeUserStatusOfflineOperation extends Operation<
        ChangeUserStatusOfflineRequest,
        ChangeUserStatusOfflineResponse
        > {
    @Override
    ChangeUserStatusOfflineResponse process(ChangeUserStatusOfflineRequest request);
}
