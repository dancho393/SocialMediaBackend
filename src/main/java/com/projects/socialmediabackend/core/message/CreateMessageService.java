package com.projects.socialmediabackend.core.message;

import com.projects.socialmediabackend.api.message.create.CreateMessageOperation;
import com.projects.socialmediabackend.api.message.create.CreateMessageRequest;
import com.projects.socialmediabackend.api.message.create.CreateMessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateMessageService implements CreateMessageOperation {
    @Override
    public CreateMessageResponse process(CreateMessageRequest request) {
        return CreateMessageResponse
                .builder()
                .build();
    }
}
