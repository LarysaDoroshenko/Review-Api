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
public class MovieResponseDto {

    private Long id;
    private String title;
    private String directorName;
    private LocalDate releaseDate;

}
