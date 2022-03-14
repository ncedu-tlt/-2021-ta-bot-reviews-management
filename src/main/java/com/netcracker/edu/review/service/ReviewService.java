package com.netcracker.edu.review.service;


import com.netcracker.edu.review.model.Review;
import com.netcracker.edu.review.model.ui.UiReview;
import com.netcracker.edu.review.repository.MarkRepository;
import com.netcracker.edu.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.netcracker.edu.review.model.Mark;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MarkRepository markRepository;

    public Review createReview(UiReview uiReview, Mark mark) {
        return reviewRepository.saveAndFlush(new Review(uiReview, mark));
    }

    public List<Review> findReviewByAuthorId(int authorId) {
        return reviewRepository.findReviewByAuthorId(authorId);
    }

    public Review updateReviewById(int id, UiReview uiReviewUpdated, Mark mark) {

        Review review = reviewRepository.getById(id);
        if (uiReviewUpdated.getReview() != null) {
            review.setReview(uiReviewUpdated.getReview());
        }
        if (uiReviewUpdated.getMark() != null) {
            review.setMark(mark);
        }
        review.setDateEdit(new Date());
        return reviewRepository.save(review);
    }
}


