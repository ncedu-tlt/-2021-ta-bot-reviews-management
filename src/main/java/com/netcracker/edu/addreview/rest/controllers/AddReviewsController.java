package com.netcracker.edu.addreview.rest.controllers;

import com.netcracker.edu.addreview.services.interfaces.AddReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddReviewsController {
    private final AddReviewsService AddReviewsService;


    @Autowired
    public AddReviewsController(AddReviewsService AddReviewsService) {
        this.AddReviewsService = AddReviewsService;
    }

    @GetMapping("/AddReviews/{review}")
    public String AddReviews(@PathVariable("review") String comment) {
        return AddReviewsService.putComment(comment);
    }
}
