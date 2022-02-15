package com.netcracker.edu.review.rest.controllers;

import com.netcracker.edu.review.services.interfaces.AddReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewsController<addReviewsService> {
    private final addReviewsService addReviewsService;


    @Autowired
    public ReviewsController(addReviewsService addReviewsService) {
        this.addReviewsService = addReviewsService;
    }

    @PutMapping("/addReviews/{review}")
    public String AddReviews(@PathVariable("review") String review) {
        return AddReviewsService.addReview(review);
    }
}
