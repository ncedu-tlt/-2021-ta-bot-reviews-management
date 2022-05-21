package com.netcracker.edu.review.controller;

import com.netcracker.edu.review.model.Rating;
import com.netcracker.edu.review.controllers.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping("/topplaces")
    public ResponseEntity<List<Rating>> findPopularPlace(@RequestBody int[] placeId) {
        return ResponseEntity.ok(ratingService.findPopularPlace(placeId));
    }
}
