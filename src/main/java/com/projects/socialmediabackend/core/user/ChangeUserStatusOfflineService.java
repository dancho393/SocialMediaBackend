package com.projects.socialmediabackend.core.user;

import com.projects.socialmediabackend.api.user.changestatusoffline.ChangeUserStatusOfflineOperation;
import com.projects.socialmediabackend.api.user.changestatusoffline.ChangeUserStatusOfflineRequest;
import com.projects.socialmediabackend.api.user.changestatusoffline.ChangeUserStatusOfflineResponse;
import com.projects.socialmediabackend.api.user.changestatusonline.ChangeUserStatusOnlineResponse;
import com.projects.socialmediabackend.persistence.model.User;
import com.projects.socialmediabackend.persistence.model.enums.user.UserStatus;
import com.projects.socialmediabackend.persistence.repository.UserRepository;
import com.projects.socialmediabackend.rest.exception.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChangeUserStatusOfflineService implements ChangeUserStatusOfflineOperation {
    private final UserRepository userRepository;
    @Getter
    private final List<String> inactiveUsers;

    @Override
    public ChangeUserStatusOfflineResponse process(ChangeUserStatusOfflineRequest request) {
        User user  = userRepository.findByUsernameIgnoreCase(request.getUsername())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.setStatus(UserStatus.Offline);
        userRepository.save(user);

        inactiveUsers.add(user.getUsername());
        return ChangeUserStatusOfflineResponse
                .builder()
                .message("Status Changed To Online")
                .build();
    }
}
