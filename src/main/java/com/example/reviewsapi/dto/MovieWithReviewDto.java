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

    private String title;
    private String directorName;
    private LocalDate releaseDate;
    private Long userRating;
    private String userComment;

}
