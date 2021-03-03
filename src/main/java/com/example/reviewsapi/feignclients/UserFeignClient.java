package com.example.reviewsapi.feignclients;

import com.example.reviewsapi.dto.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user")
public interface UserFeignClient {
    
    @GetMapping(value = "/user/{id}")
    UserResponseDto getUserById(@PathVariable("id") Long id);
    
}
