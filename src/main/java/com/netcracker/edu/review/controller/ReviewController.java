package com.netcracker.edu.review.controller;

import com.netcracker.edu.review.model.Mark;
import com.netcracker.edu.review.model.Review;
import com.netcracker.edu.review.model.ui.UiReview;
import com.netcracker.edu.review.service.MarkService;
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

    @PostMapping("/review")
    public ResponseEntity<Review> createReview(@RequestBody UiReview uiReview, Mark mark) {
        return ResponseEntity.ok(reviewService.createReview(uiReview, mark));
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
        return ResponseEntity.ok(reviewService.findReviewByPlaceIdAndAuthorId(placeId,authorId,page));
    }

    @PutMapping("/review/{id}")
    public ResponseEntity<Review> updateReviewById(@PathVariable("id") int id, @RequestBody UiReview uiReviewUpdated, Mark mark) {
        return ResponseEntity.ok(reviewService.updateReviewById(id, uiReviewUpdated, mark));
    }


    @DeleteMapping("/review/{id}")
    public ResponseEntity<HttpStatus> deleteReviewById(@PathVariable("id") int id) {
        reviewService.deleteReviewByid(id);
        return ResponseEntity.accepted().build();
    }

}
