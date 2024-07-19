package com.projects.socialmediabackend.persistence.repository;

import com.projects.socialmediabackend.persistence.model.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FriendRequestRepository extends JpaRepository<FriendRequest, UUID> {
}
