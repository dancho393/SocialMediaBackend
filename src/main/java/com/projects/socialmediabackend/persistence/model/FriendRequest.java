package com.projects.socialmediabackend.persistence.model;

import com.projects.socialmediabackend.persistence.model.enums.friendrequest.FriendRequestStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "friend_requests")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FriendRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;





    @Enumerated(EnumType.STRING)
    private FriendRequestStatus status;


    @ManyToOne( optional = false)
    @JoinColumn(name = "to_user_id", nullable = false)
    private User toUser;

    @ManyToOne( optional = false)
    @JoinColumn(name = "from_user_id", nullable = false)
    private User fromUser;

}
