package com.example.reviewsapi.feignclients;

import com.example.reviewsapi.dto.MovieResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "movie", url = "http://localhost:8082/movie")
public interface MovieFeignClient {
    
    @GetMapping(value = "/{id}")
    MovieResponseDto getMovieById(@PathVariable("id") Long id);
    
}
