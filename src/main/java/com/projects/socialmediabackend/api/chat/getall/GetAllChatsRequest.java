package com.projects.socialmediabackend.api.chat.getall;

import com.projects.socialmediabackend.api.base.OperationRequest;
import com.projects.socialmediabackend.persistence.model.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllChatsRequest implements OperationRequest {
    private User user;
}
