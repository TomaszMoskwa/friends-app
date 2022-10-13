package com.project.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HobbyDTO {
    private Long hobbyId;
    private String hobbyName;

    private Long ownerId;
}
