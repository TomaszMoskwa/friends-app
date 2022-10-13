package com.project.spring.model.mapper;

import com.project.spring.model.ApplicationUser;
import com.project.spring.model.Friend;
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
    FriendDTO mapFriendToDTO(Friend friend, ApplicationUser applicationUser);
}
