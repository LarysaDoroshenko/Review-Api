package com.example.reviewsapi.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "review")
@Entity
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long movieId;
    private Long rating;
    private String comment;

}
