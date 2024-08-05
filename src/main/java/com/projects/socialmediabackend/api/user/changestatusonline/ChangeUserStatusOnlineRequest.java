package com.projects.socialmediabackend.api.user.changestatusonline;

import com.projects.socialmediabackend.api.base.OperationRequest;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChangeUserStatusOnlineRequest implements OperationRequest {
    private String username;
}
