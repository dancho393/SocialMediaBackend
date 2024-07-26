package com.projects.socialmediabackend.persistence.repository;

import com.projects.socialmediabackend.persistence.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.UUID;

public interface ChatRepository extends JpaRepository<Chat, UUID> {

    @Query(value = "SELECT * from CHATS where user1Id=?1 OR user2Id=?1"
            ,nativeQuery = true)
    List<Chat> findAllByUser1IdOrUser2Id(String searchedID);
}
