package com.example.reviewsapi.controller;

import com.example.reviewsapi.dto.ReviewResponseDto;
import com.example.reviewsapi.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/{userId}")
    public ReviewResponseDto getReviewListByUserId(@PathVariable("userId") Long userId) {
        return reviewService.getReviewListByUserId(userId);
    }

}
