package com.projects.socialmediabackend.api.user.getall;

import com.projects.socialmediabackend.api.base.OperationResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllUsersResponse implements OperationResponse {
    private List<GetAllUsersDTO> users;
}
