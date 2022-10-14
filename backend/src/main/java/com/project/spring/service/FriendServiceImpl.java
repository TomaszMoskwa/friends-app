package com.project.spring.service;

import com.project.spring.model.ApplicationUser;
import com.project.spring.model.Friend;
import com.project.spring.model.dto.AddFriendRequest;
import com.project.spring.model.dto.FriendDTO;
import com.project.spring.model.mapper.FriendMapper;
import com.project.spring.repository.ApplicationUserRepository;
import com.project.spring.repository.FriendRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class FriendServiceImpl implements FriendService{
    private final ApplicationUserRepository applicationUserRepository;
    private final FriendRepository friendRepository;
    private final FriendMapper friendMapper;

    @Override
    public List<FriendDTO> getFriendsList() {
        return friendRepository.findAll()
                .stream()
                .map(friend -> {
                    return friendMapper.mapFriendToFriendDTO(friend, friend.getUser());
                }).collect(Collectors.toList());
    }

    @Override
    public List<FriendDTO> getFriendsList(Long userId) {
        ApplicationUser applicationUser = applicationUserRepository.findById(userId)
                .orElseThrow(EntityNotFoundException::new);

        return friendRepository.findAllByUser(applicationUser)
                .stream()
                .map(friend -> {
                    return friendMapper.mapFriendToFriendDTO(friend, friend.getUser());
                }).collect(Collectors.toList());
    }

    @Override
    public FriendDTO addNewFriend(AddFriendRequest request) {
        ApplicationUser applicationUser = applicationUserRepository.findById(request.getUserId())
                .orElseThrow(EntityNotFoundException::new);

        Friend friend = friendMapper.mapAddFriendRequestToNewFriends(request);

        friend.setUser(applicationUser);
        friend = friendRepository.save(friend);

        return friendMapper.mapFriendToFriendDTO(friend, friend.getUser());
    }
}
