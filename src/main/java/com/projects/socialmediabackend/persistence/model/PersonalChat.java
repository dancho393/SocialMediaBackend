package com.projects.socialmediabackend.persistence.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Table(name = "personal_chats")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonalChat {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}
