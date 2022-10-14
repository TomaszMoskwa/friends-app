package com.project.spring.service;

import com.project.spring.model.dto.AddFriendRequest;
import com.project.spring.model.dto.FriendDTO;

import java.util.List;

public interface FriendService {
    List<FriendDTO> getFriendsList();
    List<FriendDTO> getFriendsList(Long userId);
    FriendDTO addNewFriend(AddFriendRequest request);
}
