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

    private String email;
    private String firstName;
    private String lastName;
    private List<MovieWithReviewDto> movies;

}
