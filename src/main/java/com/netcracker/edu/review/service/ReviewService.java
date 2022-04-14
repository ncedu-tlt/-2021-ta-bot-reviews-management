package com.netcracker.edu.review.service;

import com.netcracker.edu.review.error.ReviewByRatingNotFoundException;
import com.netcracker.edu.review.error.ReviewNotFoundException;
import com.netcracker.edu.review.model.Mark;
import com.netcracker.edu.review.model.Review;
import com.netcracker.edu.review.model.ui.UiReview;
import com.netcracker.edu.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MarkService markService;

    @Autowired
    private RatingSevice ratingSevice;

    @Value("${count-of-reviews.size-of-page}")
    public int sizeOfPage;

    @Value("${count-of-reviews.date-creation}")
    public String dateOfCreation;

    public Review createReview(UiReview uiReview, Mark mark) {

        mark = markService.findMarkByValue(uiReview.getMark());

        if (uiReview.getMark() != null) {
            ratingSevice.setRating(uiReview, mark);
        }
        ratingSevice.sortTenList();
        return reviewRepository.saveAndFlush(new Review(uiReview, mark));
    }

    public List<Review> findReviewByAuthorId(int authorId, int page) {
        Pageable pageable = PageRequest.of(page, sizeOfPage, Sort.by(dateOfCreation).descending());
        List<Review> review = reviewRepository.findReviewByAuthorId(authorId, pageable);
        if (review.isEmpty()) {
            throw new ReviewNotFoundException();
        } else return review;
    }


    public List<Review> findReviewByPlaceId(int placeId, int page) {
        Pageable pageable = PageRequest.of(page, sizeOfPage, Sort.by(dateOfCreation).descending());
        List<Review> reviews = reviewRepository.findReviewByPlaceId(placeId, pageable);
        if (reviews.isEmpty()) {
            throw new ReviewNotFoundException();
        } else return reviews;
    }

    public List<Review> findReviewByPlaceIdandAuthorId(int placeId, int authorId, int page) {
        Pageable pageable = PageRequest.of(page, sizeOfPage, Sort.by(dateOfCreation).descending());
        List<Review> review = reviewRepository.findReviewByPlaceIdAndAuthorId(placeId, authorId, pageable);
        if (review.isEmpty()) {
            throw new ReviewNotFoundException();
        } else return review;
    }

    public Review updateReviewById(int id, UiReview uiReviewUpdated, Mark mark) {

        mark = markService.findMarkByValue(uiReviewUpdated.getMark());

        Review review = reviewRepository.getById(id);
        if (uiReviewUpdated.getReview() != null) {
            review.setReview(uiReviewUpdated.getReview());
        }
        if (uiReviewUpdated.getMark() != null) {
            ratingSevice.updateRatingWithReview(review, mark);
            review.setMark(mark);
        }
        review.setDateEdit(new Date());
        return reviewRepository.save(review);

    }

    public void deleteReviewById(int id) {
        if (!reviewRepository.findById(id).isPresent()) {
            throw new ReviewNotFoundException();
        } else {
            Review review = reviewRepository.findById(id).get();
            ratingSevice.deleteRatingWithReview(review);
            reviewRepository.deleteById(id);
        }
    }

    public List<Review> findReviewByMarkId(int markId, int page) {
        Pageable pageable = PageRequest.of(page, sizeOfPage, Sort.by(dateOfCreation).descending());
        List<Review> review = reviewRepository.findReviewByMark_Id(markId, pageable);
        if (review.isEmpty()) {
            throw new ReviewByRatingNotFoundException(Integer.toString(markId));
        } else return review;
    }

}


