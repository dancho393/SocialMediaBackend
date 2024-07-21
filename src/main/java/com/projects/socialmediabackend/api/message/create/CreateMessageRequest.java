package com.projects.socialmediabackend.api.message.create;

import com.projects.socialmediabackend.api.base.OperationRequest;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateMessageRequest implements OperationRequest {
    private String senderId;
    private String receiverId;
    private String message;
}
