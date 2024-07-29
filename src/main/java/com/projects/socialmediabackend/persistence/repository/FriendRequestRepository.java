package com.projects.socialmediabackend.persistence.repository;

import com.projects.socialmediabackend.persistence.model.FriendRequest;
import com.projects.socialmediabackend.persistence.model.User;
import com.projects.socialmediabackend.persistence.model.enums.friendrequest.FriendRequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import java.util.UUID;

public interface FriendRequestRepository extends JpaRepository<FriendRequest, UUID> {
    List<FriendRequest> findAllByToUserAndStatus(User user, FriendRequestStatus status);
}
