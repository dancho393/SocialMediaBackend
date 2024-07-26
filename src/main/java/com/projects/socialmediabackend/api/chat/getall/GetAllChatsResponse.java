package com.projects.socialmediabackend.api.chat.getall;

import com.projects.socialmediabackend.api.base.OperationResponse;
import com.projects.socialmediabackend.persistence.model.Chat;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllChatsResponse implements OperationResponse {
    private List<Chat> chats;
}
