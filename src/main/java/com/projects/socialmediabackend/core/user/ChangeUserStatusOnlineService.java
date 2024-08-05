package com.projects.socialmediabackend.core.user;

import com.projects.socialmediabackend.api.user.changestatusonline.ChangeUserStatusOnlineOperation;
import com.projects.socialmediabackend.api.user.changestatusonline.ChangeUserStatusOnlineRequest;
import com.projects.socialmediabackend.api.user.changestatusonline.ChangeUserStatusOnlineResponse;
import com.projects.socialmediabackend.persistence.model.User;
import com.projects.socialmediabackend.persistence.model.enums.user.UserStatus;
import com.projects.socialmediabackend.persistence.repository.UserRepository;
import com.projects.socialmediabackend.rest.exception.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class ChangeUserStatusOnlineService implements ChangeUserStatusOnlineOperation {
    private final UserRepository userRepository;
    @Getter
    private final List<String> activeUsers;
    @Override
    public ChangeUserStatusOnlineResponse process(ChangeUserStatusOnlineRequest request) {
        User user  = userRepository.findByUsernameIgnoreCase(request.getUsername())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.setStatus(UserStatus.Online);
        userRepository.save(user);
        activeUsers.add(user.getUsername());
        return ChangeUserStatusOnlineResponse
                .builder()
                .message("Status Changed To Online")
                .build();
    }

}
