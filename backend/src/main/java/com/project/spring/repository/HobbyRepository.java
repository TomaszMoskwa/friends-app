package com.project.spring.repository;

import com.project.spring.model.Friend;
import com.project.spring.model.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HobbyRepository extends JpaRepository<Hobby, Long> {
    List<Hobby> findAllByFriend(Friend friend);
}
