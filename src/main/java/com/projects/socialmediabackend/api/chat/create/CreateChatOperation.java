package com.projects.socialmediabackend.api.chat.create;

import com.projects.socialmediabackend.api.base.Operation;
import org.springframework.security.access.method.P;

public interface CreateChatOperation extends Operation<CreateChatRequest,CreateChatResponse> {
    @Override
    CreateChatResponse process(CreateChatRequest request);
}
