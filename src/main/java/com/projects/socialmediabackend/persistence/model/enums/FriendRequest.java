package com.projects.socialmediabackend.persistence.model.enums;

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

}
