package com.example.reviewsapi.feignclients;

import com.example.reviewsapi.dto.MovieResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "movie")
public interface MovieFeignClient {
    
    @GetMapping(value = "/movie/{id}")
    MovieResponseDto getMovieById(@PathVariable("id") Long id);
    
}
