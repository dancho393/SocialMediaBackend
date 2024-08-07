package com.projects.socialmediabackend.api.user.getallfriends;

import com.projects.socialmediabackend.api.base.OperationResponse;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllFriendsResponse implements OperationResponse {
    private List<GetAllFriendsUserDTO> friends;
}
