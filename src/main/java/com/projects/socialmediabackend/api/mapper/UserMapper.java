package com.projects.socialmediabackend.api.mapper;

import com.projects.socialmediabackend.api.user.getall.GetAllUsersDTO;
import com.projects.socialmediabackend.api.user.getallfriends.GetAllFriendsUserDTO;
import com.projects.socialmediabackend.api.user.register.UserRegisterRequest;
import com.projects.socialmediabackend.api.user.register.UserRegisterResponse;
import com.projects.socialmediabackend.persistence.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    @Mapping(target = "username")
    @Mapping(target = "firstName")
    @Mapping(target = "lastName")
    @Mapping(target = "email")
    @Mapping(target = "phone")
    @Mapping(target = "address")
    @Mapping(target = "city")
    User fromRequestToUser(UserRegisterRequest request);

    @Mapping(target = "id")
    @Mapping(target = "username")
    @Mapping(target = "firstName")
    @Mapping(target = "lastName")
    @Mapping(target = "email")
    @Mapping(target = "phone")
    @Mapping(target = "address")
    @Mapping(target = "city")
    @Mapping(target = "role")
    UserRegisterResponse toUserRegisterResponse(User user);

    @Mapping(target = "username")
    @Mapping(target = "firstName")
    @Mapping(target = "lastName")
    @Mapping(target = "email")
    @Mapping(target = "phone")
    @Mapping(target = "address")
    @Mapping(target = "city")
    GetAllUsersDTO fromUserToGetAllUsersDTO(User user);

    @Mapping(target = "id")
    @Mapping(target = "firstName")
    @Mapping(target = "lastName")
    @Mapping(target = "pictureURL")
    @Mapping(target = "status",source = "status")
    GetAllFriendsUserDTO fromUserToGetAllFriendsUserDTO(User user);

    Set<GetAllFriendsUserDTO> fromUserToGetAllFriendsUserDTOSet(Set<User> users);
}
