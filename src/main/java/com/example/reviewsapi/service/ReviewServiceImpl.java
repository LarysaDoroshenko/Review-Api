package com.example.reviewsapi.service;

import com.example.reviewsapi.dto.*;
import com.example.reviewsapi.entity.ReviewEntity;
import com.example.reviewsapi.feignclients.MovieFeignClient;
import com.example.reviewsapi.feignclients.UserFeignClient;
import com.example.reviewsapi.mapper.ReviewMapper;
import com.example.reviewsapi.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final UserFeignClient userFeignClient;
    private final MovieFeignClient movieFeignClient;

    @Override
    public ReviewResponseDto getReviewListByUserId(Long userId) {
        UserResponseDto userResponseDto = userFeignClient.getUserById(userId);

        List<ReviewEntity> reviewList = reviewRepository.findAllByUserId(userId);

        List<MovieWithReviewDto> movieWithReviewDtoList = reviewList.stream()
                                                                    .map(this::getMovieWithReviewDto)
                                                                    .collect(Collectors.toList());

        return ReviewResponseDto.builder()
                                .email(userResponseDto.getEmail())
                                .firstName(userResponseDto.getFirstName())
                                .lastName(userResponseDto.getLastName())
                                .movies(movieWithReviewDtoList)
                                .build();
    }

    @Override
    public ReviewResponseDto createReview(ReviewRequestDto reviewRequestDto) {
        ReviewEntity reviewEntity = reviewMapper.requestReviewDtoToReviewEntity(reviewRequestDto);
        ReviewEntity savedReview = reviewRepository.save(reviewEntity);

        return getReviewListByUserId(savedReview.getUserId());
    }

    private MovieWithReviewDto getMovieWithReviewDto(ReviewEntity reviewEntity) {
        MovieResponseDto movieResponseDto = movieFeignClient.getMovieById(reviewEntity.getId());

        return MovieWithReviewDto.builder()
                                 .title(movieResponseDto.getTitle())
                                 .directorName(movieResponseDto.getDirectorName())
                                 .releaseDate(movieResponseDto.getReleaseDate())
                                 .userRating(reviewEntity.getRating())
                                 .userComment(reviewEntity.getComment())
                                 .build();
    }

}
