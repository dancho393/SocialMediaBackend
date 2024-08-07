package com.projects.socialmediabackend.core.user;

import com.projects.socialmediabackend.api.mapper.UserMapper;
import com.projects.socialmediabackend.api.user.getallfriends.GetAllFriendsOperation;
import com.projects.socialmediabackend.api.user.getallfriends.GetAllFriendsRequest;
import com.projects.socialmediabackend.api.user.getallfriends.GetAllFriendsResponse;
import com.projects.socialmediabackend.persistence.model.User;
import com.projects.socialmediabackend.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class GetAllFriendsService implements GetAllFriendsOperation {
    private final UserMapper userMapper;
    @Override
    public GetAllFriendsResponse process(GetAllFriendsRequest request) {

        Set<User> friends = request.getUser().getFriends();
        return GetAllFriendsResponse
                .builder()
                .friends(userMapper.fromUserToGetAllFriendsUserDTOSet(friends))
                .build();
    }
}
