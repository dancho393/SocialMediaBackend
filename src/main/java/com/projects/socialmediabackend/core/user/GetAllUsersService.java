package com.projects.socialmediabackend.core.user;

import com.projects.socialmediabackend.api.mapper.UserMapper;
import com.projects.socialmediabackend.api.user.getall.GetAllUsersDTO;
import com.projects.socialmediabackend.api.user.getall.GetAllUsersOperation;
import com.projects.socialmediabackend.api.user.getall.GetAllUsersRequest;
import com.projects.socialmediabackend.api.user.getall.GetAllUsersResponse;
import com.projects.socialmediabackend.persistence.model.User;
import com.projects.socialmediabackend.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllUsersService implements GetAllUsersOperation {
    private final  UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public GetAllUsersResponse process(GetAllUsersRequest request) {
        List<User> users =
                userRepository.findAllWithExceptionalUser(request.getExceptionalUser().getId());
        return GetAllUsersResponse
                .builder()
                .users(mapUserToDTO(users))
                .build();
    }
    private List<GetAllUsersDTO> mapUserToDTO(List<User> users){
        List<GetAllUsersDTO> usersDTOS= new ArrayList<>();
        for(User user : users){
            usersDTOS.add(userMapper.fromUserToGetAllUsersDTO(user));
        }
        return usersDTOS;
    }
}
