package com.project.spring.model.dto;

import com.project.spring.model.Hobby;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendDTO {
    private Long friendId;

    private String firstName;
    private String lastName;
    private LocalDate birthday;
}
