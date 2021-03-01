package com.example.reviewsapi.mapper;

import com.example.reviewsapi.dto.ReviewRequestDto;
import com.example.reviewsapi.entity.ReviewEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    
    ReviewEntity requestReviewDtoToReviewEntity(ReviewRequestDto reviewRequestDto);
    
}
