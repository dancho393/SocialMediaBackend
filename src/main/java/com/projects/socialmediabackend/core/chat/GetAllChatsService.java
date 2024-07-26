package com.projects.socialmediabackend.core.chat;

import com.projects.socialmediabackend.api.chat.getall.GetAllChatsOperation;
import com.projects.socialmediabackend.api.chat.getall.GetAllChatsRequest;
import com.projects.socialmediabackend.api.chat.getall.GetAllChatsResponse;
import com.projects.socialmediabackend.persistence.model.Chat;
import com.projects.socialmediabackend.persistence.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllChatsService implements GetAllChatsOperation {
    private final ChatRepository chatRepository;
    @Override
    public GetAllChatsResponse process(GetAllChatsRequest request) {
        List<Chat> chats =
                chatRepository.findAllByUser1IdOrUser2Id(request.getUser().getId().toString());
        return GetAllChatsResponse
                .builder()
                .chats(chats)
                .build();
    }
}
