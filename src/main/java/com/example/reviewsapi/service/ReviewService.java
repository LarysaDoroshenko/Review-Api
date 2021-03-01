package com.example.reviewsapi.service;

import com.example.reviewsapi.dto.RequestReviewDto;
import com.example.reviewsapi.dto.ReviewResponseDto;

public interface ReviewService {

    ReviewResponseDto getReviewListByUserId(Long userId);

    ReviewResponseDto createReview(RequestReviewDto requestReviewDto);

}
