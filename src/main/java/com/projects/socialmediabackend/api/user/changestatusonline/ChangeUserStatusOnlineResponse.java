package com.projects.socialmediabackend.api.user.changestatusonline;

import com.projects.socialmediabackend.api.base.OperationResponse;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChangeUserStatusOnlineResponse implements OperationResponse {
    private String message;
}
