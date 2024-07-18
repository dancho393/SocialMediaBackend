package com.projects.socialmediabackend.persistence.model;

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
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String message;
    @ManyToOne
    private User sender;

    @ManyToOne
    private User receiver;



}
