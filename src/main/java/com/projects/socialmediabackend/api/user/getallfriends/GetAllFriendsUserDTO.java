package com.projects.socialmediabackend.api.user.getallfriends;

import com.projects.socialmediabackend.persistence.model.enums.user.UserStatus;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllFriendsUserDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String pictureURL;
    private UserStatus status;;

}
