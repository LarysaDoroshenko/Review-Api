package com.example.reviewsapi.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserResponseDto {
    
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    
}
