package com.example.reviewsapi.service;

import com.example.reviewsapi.dto.MovieResponseDto;
import com.example.reviewsapi.dto.MovieWithReviewDto;
import com.example.reviewsapi.dto.ReviewResponseDto;
import com.example.reviewsapi.dto.UserResponseDto;
import com.example.reviewsapi.entity.ReviewEntity;
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

    private static final String GET_MOVIE = "http://localhost:8082/movie";

    private final ReviewRepository reviewRepository;
    private final RestTemplate restTemplate;

    @Override
    public ReviewResponseDto getReviewListByUserId(Long userId) {
        String getUserUrl = "http://localhost:8081/users" + "/" + userId;
        UserResponseDto userResponseDto = restTemplate.getForObject(getUserUrl, UserResponseDto.class);
        log.error("{}", userResponseDto);

        List<ReviewEntity> reviewList = reviewRepository.findAllByUserId(userId);

        List<MovieResponseDto> movieResponseDtoList = reviewList.stream().map(ReviewEntity::getMovieId)
                                                                .map(movieId -> {
                                                                    String getMovieUrl = "http://localhost:8082/movie" + "/" + movieId;
                                                                    return restTemplate.getForObject(getMovieUrl, MovieResponseDto.class);
                                                                })
                                                                .collect(Collectors.toList());

        movieResponseDtoList.forEach(movie -> log.error("{}", movie));

        List<MovieWithReviewDto> movieWithReviewDtoList = reviewList.stream()
                                                                    .map(reviewEntity -> {
                                                                        String getMovieUrl = "http://localhost:8082/movie" + "/" + reviewEntity.getMovieId();
                                                                        MovieResponseDto movie = restTemplate.getForObject(getMovieUrl, MovieResponseDto.class);
                                                                        MovieWithReviewDto movieWithReviewDto = new MovieWithReviewDto();
                                                                        movieWithReviewDto.setMovieTitle(movie.getTitle());
                                                                        movieWithReviewDto.setMovieDirectorName(movie.getDirectorName());
                                                                        movieWithReviewDto.setMovieReleaseDate(movie.getReleaseDate());
                                                                        movieWithReviewDto.setMovieRating(reviewEntity.getRating());
                                                                        movieWithReviewDto.setMovieComment(reviewEntity.getComment());
                                                                        
                                                                        return movieWithReviewDto;
                                                                    })
                                                                    .collect(Collectors.toList());

        ReviewResponseDto reviewResponseDto = new ReviewResponseDto();
        reviewResponseDto.setUserEmail(userResponseDto.getEmail());
        reviewResponseDto.setUserFirstName(userResponseDto.getFirstName());
        reviewResponseDto.setUserLastName(userResponseDto.getLastName());
        reviewResponseDto.setMovieWithReviewDtoList(movieWithReviewDtoList);

        return reviewResponseDto;
    }

}
