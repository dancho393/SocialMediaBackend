package com.projects.socialmediabackend.persistence.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.security.Timestamp;

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
    @CreationTimestamp
    private Timestamp sentAt;

    private String senderId;
    private String receiverId;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "chat_id", nullable = false)
    private Chat chat;

}
