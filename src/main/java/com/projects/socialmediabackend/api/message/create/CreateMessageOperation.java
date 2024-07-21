package com.projects.socialmediabackend.api.message.create;

import com.projects.socialmediabackend.api.base.Operation;

public interface CreateMessageOperation extends Operation<CreateMessageRequest,CreateMessageResponse> {
    @Override
    CreateMessageResponse process(CreateMessageRequest request);
}
