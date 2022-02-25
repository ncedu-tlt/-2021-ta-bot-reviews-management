package com.netcracker.edu.review.service;

import com.netcracker.edu.review.model.Review;
import com.netcracker.edu.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
   private ReviewRepository reviewRepository;

    public Review createReview(Review newReview){return reviewRepository.saveAndFlush(newReview);}

}
