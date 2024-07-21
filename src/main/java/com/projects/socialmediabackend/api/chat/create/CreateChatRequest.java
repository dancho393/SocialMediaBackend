package com.projects.socialmediabackend.api.chat.create;

import com.projects.socialmediabackend.api.base.OperationRequest;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateChatRequest implements OperationRequest {
    private String user1Id;
    private String user2Id;
}
