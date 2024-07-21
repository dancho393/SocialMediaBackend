package com.projects.socialmediabackend.persistence.repository;

import com.projects.socialmediabackend.persistence.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChatRepository extends JpaRepository<Chat, UUID> {
}
