package com.projects.socialmediabackend.api.user.changestatusoffline;

import com.projects.socialmediabackend.api.base.OperationRequest;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChangeUserStatusOfflineRequest implements OperationRequest {
    private String username;
}
