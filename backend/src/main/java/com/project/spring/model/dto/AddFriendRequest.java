package com.project.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddFriendRequest {
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Long userId;
}
