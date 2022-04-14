package com.netcracker.edu.review.controller;

import com.netcracker.edu.review.model.Mark;
import com.netcracker.edu.review.model.Rating;
import com.netcracker.edu.review.model.Review;
import com.netcracker.edu.review.model.ui.UiReview;
import com.netcracker.edu.review.service.MarkService;
import com.netcracker.edu.review.service.RatingService;
import com.netcracker.edu.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    public ReviewService reviewService;

    @Autowired
    public MarkService markService;

    @Autowired
    public RatingService ratingService;

    @PostMapping("/review")
    public ResponseEntity<Review> createReview(@RequestBody UiReview uiReview, Mark mark) {
        return ResponseEntity.ok(reviewService.createReview(uiReview, mark));
    }


    @GetMapping("/review/author/{authorId}/{page}")
    public ResponseEntity<List<Review>> findReviewByAuthorId(@PathVariable("authorId") int authorId, @PathVariable("page") int page) {
        return ResponseEntity.ok(reviewService.findReviewByAuthorId(authorId, page));
    }


    @GetMapping("/review/place/{placeId}/{page}")
    public ResponseEntity<List<Review>> findReviewByPlaceId(@PathVariable("placeId") int placeId, @PathVariable("page") int page) {
        return ResponseEntity.ok(reviewService.findReviewByPlaceId(placeId, page));
    }


    @GetMapping("/review/place/{placeId}/author/{authorId}/{page}")
    public ResponseEntity<List<Review>> findReviewByPlaceIdAndAuthorId(@PathVariable("placeId") int placeId, @PathVariable("authorId") int authorId, @PathVariable("page") int page) {
        return ResponseEntity.ok(reviewService.findReviewByPlaceIdandAuthorId(placeId, authorId, page));
    }

    @PutMapping("/review/{id}")
    public ResponseEntity<Review> updateReviewById(@PathVariable("id") int id, @RequestBody UiReview uiReviewUpdated, Mark mark) {
        return ResponseEntity.ok(reviewService.updateReviewById(id, uiReviewUpdated, mark));
    }

    @DeleteMapping("/review/{id}")
    public ResponseEntity<HttpStatus> deleteReviewById(@PathVariable("id") int id) {
        reviewService.deleteReviewById(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/review/mark/{markId}/{page}")
    public ResponseEntity<List<Review>> sortedByRating(@PathVariable("markId") int markId, @PathVariable("page") int page) {
        return ResponseEntity.ok(reviewService.findReviewByMarkId(markId, page));
    }

    @GetMapping("/review/tenbestplace")
    public ResponseEntity<List<Rating>> sortTenList() {
        return ResponseEntity.ok(ratingService.sortTenList());
    }
}
