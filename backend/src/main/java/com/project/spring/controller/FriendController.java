package com.project.spring.controller;

import com.project.spring.component.PrincipalComponent;
import com.project.spring.model.dto.AddFriendRequest;
import com.project.spring.model.dto.FriendDTO;
import com.project.spring.service.FriendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/friend")
@RequiredArgsConstructor
public class FriendController {
    private final FriendService friendService;
    private final PrincipalComponent principalComponent;

    @GetMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public List<FriendDTO> getAllFriends(){
        log.info("getAllFriends called");
        return friendService.getFriendsList();
    }
    @GetMapping("/{userId}")
    @PreAuthorize("isAuthenticated()")
    public List<FriendDTO> getUserFriends(UsernamePasswordAuthenticationToken principal, @PathVariable Long userId){
        log.info("getUserFriends called");
        principalComponent.getUser(principal, userId);
        return friendService.getFriendsList(userId);
    }

    @PostMapping()
    @PreAuthorize("isAuthenticated()")
    public FriendDTO addSale(UsernamePasswordAuthenticationToken principal, @RequestBody AddFriendRequest request) {
        log.info("addFriend called");
        principalComponent.getUser(principal, request.getUserId());

        return friendService.addNewFriend(request);
    }
}
