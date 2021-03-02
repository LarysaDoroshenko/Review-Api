package com.example.reviewsapi.controller;

import com.example.reviewsapi.dto.ReviewRequestDto;
import com.example.reviewsapi.dto.ReviewResponseDto;
import com.example.reviewsapi.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/{userId}")
    public ResponseEntity<ReviewResponseDto> getReviewListByUserId(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(reviewService.getReviewListByUserId(userId));
    }

    @PostMapping("/create")
    public ResponseEntity<ReviewResponseDto> createReview(@RequestBody ReviewRequestDto reviewRequestDto) {
        return new ResponseEntity<>(reviewService.createReview(reviewRequestDto), HttpStatus.CREATED);
    }

}
