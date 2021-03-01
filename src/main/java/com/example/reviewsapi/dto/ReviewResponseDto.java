package com.example.reviewsapi.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class ReviewResponseDto {
    
    private String userEmail;
    private String userFirstName;
    private String userLastName;
    private List<MovieWithReviewDto> movieWithReviewDtoList;
    
}
