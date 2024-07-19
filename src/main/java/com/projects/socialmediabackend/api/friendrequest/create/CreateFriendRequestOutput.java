package com.projects.socialmediabackend.api.friendrequest.create;

import com.projects.socialmediabackend.api.base.OperationResponse;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateFriendRequestOutput implements OperationResponse {
    private String responseMessage;
}
