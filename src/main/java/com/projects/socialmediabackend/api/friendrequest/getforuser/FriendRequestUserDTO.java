package com.projects.socialmediabackend.api.friendrequest.getforuser;

import com.projects.socialmediabackend.persistence.model.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FriendRequestUserDTO {
    private String requestId;
    private String username;
    private String firstName;
    private String lastName;
    private String city;
    private String pictureURL;
}
