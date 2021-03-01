package com.example.reviewsapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponseDto {

    private String userEmail;
    private String userFirstName;
    private String userLastName;
    private List<MovieWithReviewDto> movieWithReviewDtoList;

}
