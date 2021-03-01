package com.example.reviewsapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class MovieResponseDto {

    private Long id;
    private String title;
    private String directorName;
    private LocalDate releaseDate;

}
