package com.projects.socialmediabackend.api.user.changestatusoffline;

import com.projects.socialmediabackend.api.base.OperationResponse;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChangeUserStatusOfflineResponse implements OperationResponse {
    private String message;
}
