package com.example.reviewsapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequestDto {

    private Long userId;
    private Long movieId;
    private Long rating;
    private String comment;

}
