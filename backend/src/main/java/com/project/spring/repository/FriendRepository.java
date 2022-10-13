package com.project.spring.repository;

import com.project.spring.model.ApplicationUser;
import com.project.spring.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Long> {
    List<Friend> findAllByUser(ApplicationUser user);
}
