package com.projects.socialmediabackend.api.user.changestatusonline;

import com.projects.socialmediabackend.api.base.Operation;

public interface ChangeUserStatusOnlineOperation extends Operation<
        ChangeUserStatusOnlineRequest,
        ChangeUserStatusOnlineResponse> {
    @Override
    ChangeUserStatusOnlineResponse process(ChangeUserStatusOnlineRequest request);
}
