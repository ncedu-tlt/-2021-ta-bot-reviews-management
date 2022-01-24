package com.netcracker.edu.botlocation.rest.controllers;

import com.netcracker.edu.botlocation.services.interfaces.AddReviewsService;
import com.netcracker.edu.botlocation.services.interfaces.AddReviewsService;
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

    @GetMapping("/AddReviews/{comment}")
    public String AddReviews(@PathVariable("comment") String comment) {
        return AddReviewsService.getComment(comment);
    }
}
