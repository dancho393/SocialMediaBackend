package com.projects.socialmediabackend.api.mapper;

import com.projects.socialmediabackend.api.friendrequest.getforuser.FriendRequestUserDTO;
import com.projects.socialmediabackend.persistence.model.FriendRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FriendRequestMapper {
    FriendRequestMapper INSTANCE = Mappers.getMapper(FriendRequestMapper.class);


    @Mapping(source = "fromUser.username", target = "username")
    @Mapping(source = "fromUser.firstName", target = "firstName")
    @Mapping(source = "fromUser.lastName", target = "lastName")
    @Mapping(source = "fromUser.city", target = "city")
    @Mapping(source = "fromUser.pictureURL", target = "pictureURL")
    @Mapping(source = "id",target = "requestId")
    FriendRequestUserDTO toFriendRequestUserDTO(FriendRequest friendRequest);

    List<FriendRequestUserDTO> toFriendRequestUserDTOList(List<FriendRequest> friendRequestList);
}
