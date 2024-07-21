package com.projects.socialmediabackend.api.chat.create;

import com.projects.socialmediabackend.api.base.OperationResponse;
import com.projects.socialmediabackend.persistence.model.Chat;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateChatResponse implements OperationResponse {
    private String message;
    private Chat chat;
}
