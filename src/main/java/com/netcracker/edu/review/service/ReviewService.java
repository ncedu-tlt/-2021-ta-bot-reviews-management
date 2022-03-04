package com.netcracker.edu.review.service;

import com.netcracker.edu.review.model.Review;
import com.netcracker.edu.review.model.ui.UiReview;
import com.netcracker.edu.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
   private ReviewRepository reviewRepository;

    public Review createReview(UiReview uiReview) {
        return reviewRepository.saveAndFlush(new Review(uiReview));
    }

    public List<Review> findReviewByAuthorId(int authorId) {
        return reviewRepository.findReviewByAuthorId(authorId);
    }
}
