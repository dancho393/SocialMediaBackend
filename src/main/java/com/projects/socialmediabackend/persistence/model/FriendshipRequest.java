package com.projects.socialmediabackend.persistence.model;

import com.projects.socialmediabackend.persistence.model.enums.friendship.FriendshipsStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "messages")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FriendshipRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    private User from;

    @ManyToOne
    private User to;

    @Enumerated(EnumType.STRING)
    private FriendshipsStatus status;
}
