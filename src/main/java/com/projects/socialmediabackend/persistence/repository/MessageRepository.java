package com.projects.socialmediabackend.persistence.repository;

import com.projects.socialmediabackend.persistence.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {
}
