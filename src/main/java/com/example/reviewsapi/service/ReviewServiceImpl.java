package com.example.reviewsapi.service;

import com.example.reviewsapi.dto.*;
import com.example.reviewsapi.entity.ReviewEntity;
import com.example.reviewsapi.mapper.ReviewMapper;
import com.example.reviewsapi.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final RestTemplate restTemplate;
    private final ReviewMapper reviewMapper;

    @Override
    public ReviewResponseDto getReviewListByUserId(Long userId) {
        String getUserUrl = "http://localhost:8081/users" + "/" + userId;
        UserResponseDto userResponseDto = restTemplate.getForObject(getUserUrl, UserResponseDto.class);

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
        String getMovieUrl = "http://localhost:8082/movie" + "/" + reviewEntity.getMovieId();
        MovieResponseDto movie = restTemplate.getForObject(getMovieUrl, MovieResponseDto.class);

        return MovieWithReviewDto.builder()
                                 .title(movie.getTitle())
                                 .directorName(movie.getDirectorName())
                                 .releaseDate(movie.getReleaseDate())
                                 .userRating(reviewEntity.getRating())
                                 .userComment(reviewEntity.getComment())
                                 .build();
    }

}
