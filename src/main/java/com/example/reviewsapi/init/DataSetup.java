package com.example.reviewsapi.init;

import com.example.reviewsapi.entity.ReviewEntity;
import com.example.reviewsapi.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class DataSetup {
    
    private final ReviewRepository reviewRepository;
    
    @PostConstruct
    public void dataSetup() {
        ReviewEntity review1 = new ReviewEntity();
        review1.setId(1L);
        review1.setUserId(1L);
        review1.setMovieId(1L);
        review1.setRating(7);
        review1.setComment("Slightly above average.");
        reviewRepository.save(review1);

        ReviewEntity review2 = new ReviewEntity();
        review2.setId(2L);
        review2.setUserId(1L);
        review2.setMovieId(2L);
        review2.setRating(9);
        review2.setComment("Nolan genius.");
        reviewRepository.save(review2);
    }
    
}
