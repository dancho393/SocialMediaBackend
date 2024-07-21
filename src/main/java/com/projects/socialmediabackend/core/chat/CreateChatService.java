package com.projects.socialmediabackend.core.chat;

import com.projects.socialmediabackend.api.chat.create.CreateChatOperation;
import com.projects.socialmediabackend.api.chat.create.CreateChatRequest;
import com.projects.socialmediabackend.api.chat.create.CreateChatResponse;
import com.projects.socialmediabackend.persistence.model.Chat;
import com.projects.socialmediabackend.persistence.repository.ChatRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateChatService implements CreateChatOperation {
    private final ChatRepository chatRepository;

    @Transactional
    @Override
    public CreateChatResponse process(CreateChatRequest request) {
        Chat chat = Chat.builder()
                .user1Id(request.getUser1Id())
                .user2Id(request.getUser2Id())
                .build();
        chatRepository.save(chat);
        return CreateChatResponse.builder()
                .message("Chat created Successfully")
                .chat(chat)
                .build();
    }
}
