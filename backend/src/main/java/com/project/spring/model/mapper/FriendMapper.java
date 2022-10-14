package com.project.spring.model.mapper;

import com.project.spring.model.ApplicationUser;
import com.project.spring.model.Friend;
import com.project.spring.model.dto.AddFriendRequest;
import com.project.spring.model.dto.FriendDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface FriendMapper {
    @Mappings(value = {
            @Mapping(target = "friendId", source = "friend.id"),
            @Mapping(target = "firstName", source = "friend.firstName"),
            @Mapping(target = "lastName", source = "friend.lastName"),
            @Mapping(target = "birthday", source = "friend.birthday"),
    })
    FriendDTO mapFriendToFriendDTO(Friend friend, ApplicationUser applicationUser);

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "firstName", source = "firstName"),
            @Mapping(target = "lastName", source = "lastName"),
            @Mapping(target = "birthday", source = "birthday"),
    })
    Friend mapAddFriendRequestToNewFriends(AddFriendRequest request);
}


