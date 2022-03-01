package com.netcracker.edu.review.controller;
import  com.netcracker.edu.review.model.Review;

import com.netcracker.edu.review.model.ui.UiReview;
import com.netcracker.edu.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController{
    @Autowired
    public ReviewService reviewService;

    @PostMapping("/review")
    public ResponseEntity<Review> createUser(@RequestBody UiReview uiReview) {
        return ResponseEntity.ok(reviewService.createReview(new Review(uiReview)));
    }
}
