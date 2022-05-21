package com.netcracker.edu.review.controller;

import com.netcracker.edu.review.model.Review;
import com.netcracker.edu.review.model.ui.UiReview;
import com.netcracker.edu.review.controllers.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody UiReview uiReview) {
        return ResponseEntity.ok(reviewService.createReview(uiReview));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Review>> findReviewById(@PathVariable("id") int id) {
        return ResponseEntity.ok(reviewService.findReviewByReviewId(id));
    }

    @GetMapping("/author/{authorId}/{page}")
    public ResponseEntity<List<Review>> findReviewByAuthorId(@PathVariable("authorId") int authorId, @PathVariable("page") int page) {
        return ResponseEntity.ok(reviewService.findReviewByAuthorId(authorId, page));
    }


    @GetMapping("/place/{placeId}/{page}")
    public ResponseEntity<List<Review>> findReviewByPlaceId(@PathVariable("placeId") int placeId, @PathVariable("page") int page) {
        return ResponseEntity.ok(reviewService.findReviewByPlaceId(placeId, page));
    }


    @GetMapping("/place/{placeId}/{authorId}/{page}")
    public ResponseEntity<List<Review>> findReviewByPlaceIdAndAuthorId(@PathVariable("placeId") int placeId, @PathVariable("authorId") int authorId, @PathVariable("page") int page) {
        return ResponseEntity.ok(reviewService.findReviewByPlaceIdandAuthorId(placeId, authorId, page));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReviewById(@PathVariable("id") int id, @RequestBody UiReview uiReviewUpdated) {
        return ResponseEntity.ok(reviewService.updateReviewById(id, uiReviewUpdated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteReviewById(@PathVariable("id") int id) {
        reviewService.deleteReviewById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/place/mark/{placeId}/{markId}/{page}")
    public ResponseEntity<List<Review>> sortedByRating(@PathVariable("placeId") int placeId, @PathVariable("markId") int markId, @PathVariable("page") int page) {
        return ResponseEntity.ok(reviewService.findReviewByPlaceIdAndMark_Id(placeId, markId, page));
    }


}
