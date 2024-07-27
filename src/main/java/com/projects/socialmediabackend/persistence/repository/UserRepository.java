package com.projects.socialmediabackend.persistence.repository;

import com.projects.socialmediabackend.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsernameIgnoreCase(String username);
    @Query(value = "SELECT * FROM USERS u WHERE u.id!=?1"
            ,nativeQuery = true)
    List<User> findAllWithExceptionalUser(UUID id);
}
