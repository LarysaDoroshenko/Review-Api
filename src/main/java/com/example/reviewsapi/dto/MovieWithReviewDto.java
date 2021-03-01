package com.example.reviewsapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieWithReviewDto {

    private String movieTitle;
    private String movieDirectorName;
    private LocalDate movieReleaseDate;
    private Long movieRating;
    private String movieComment;

}
