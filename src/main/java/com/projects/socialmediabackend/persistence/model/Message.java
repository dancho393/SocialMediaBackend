package com.projects.socialmediabackend.persistence.model;

import com.projects.socialmediabackend.persistence.model.enums.message.MessageStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.UUID;

@Table(name = "messages")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String message;


    private Instant sentAt;

    private String senderId;
    private String receiverId;

    @ManyToOne( optional = false)
    @JoinColumn(name = "chat_id", nullable = false)
    private Chat chat;

    @Enumerated(EnumType.STRING)
    private MessageStatus status;

    private boolean isArchived;


}
