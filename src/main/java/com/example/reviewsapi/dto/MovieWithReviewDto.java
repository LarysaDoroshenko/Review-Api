package com.example.reviewsapi.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class MovieWithReviewDto {
    
    private String movieTitle;
    private String movieDirectorName;
    private LocalDate movieReleaseDate;
    private Integer movieRating;
    private String movieComment;
    
}
