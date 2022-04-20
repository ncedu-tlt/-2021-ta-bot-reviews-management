package com.netcracker.edu.review.controller;

import com.netcracker.edu.review.model.Rating;
import com.netcracker.edu.review.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping("/tenbestplace")
    public ResponseEntity<List<Rating>> sortTenList() {
        return ResponseEntity.ok(ratingService.sortTenList());
    }
}
