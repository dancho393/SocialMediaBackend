package com.projects.socialmediabackend.api.friendrequest.getforuser;

import com.projects.socialmediabackend.api.base.OperationResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetFriendRequestsForUserOutput implements OperationResponse {
    private List<FriendRequestUserDTO> userDTOS;

}
