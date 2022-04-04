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

    @Value("${countOfReviews.size-of-page}")
    public int size_of_page;

    @Value("${countOfReviews.date-creation}")
    public String date_of_creation;

    public Review createReview(UiReview uiReview, Mark mark) {

        mark = markService.findMarkByValue(uiReview.getMark());

        if (uiReview.getMark() != null) {
            ratingSevice.setRating(uiReview, mark);
        }

        return reviewRepository.saveAndFlush(new Review(uiReview, mark));
    }

    public List<Review> findReviewByAuthorId(int authorId, int page) {
        Pageable pageable = PageRequest.of(page, size_of_page, Sort.by(date_of_creation).descending());
        if (reviewRepository.findReviewByAuthorId(authorId, pageable).isEmpty()) {
            throw new ReviewNotFoundException();
        } else return reviewRepository.findReviewByAuthorId(authorId, pageable);
    }


    public List<Review> findReviewByPlaceId(int placeId, int page) {
        Pageable pageable = PageRequest.of(page, size_of_page, Sort.by(date_of_creation).descending());
        if (reviewRepository.findReviewByPlaceId(placeId, pageable).isEmpty()) {
            throw new ReviewNotFoundException();
        } else return reviewRepository.findReviewByPlaceId(placeId, pageable);
    }

    public List<Review> findReviewByPlaceIdandAuthorId(int placeId, int authorId, int page) {
        Pageable pageable = PageRequest.of(page, size_of_page, Sort.by(date_of_creation).descending());
        if (reviewRepository.findReviewByPlaceIdAndAuthorId(placeId, authorId, pageable).isEmpty()) {
            throw new ReviewNotFoundException();
        } else return reviewRepository.findReviewByPlaceIdAndAuthorId(placeId, authorId, pageable);
    }

    public Review updateReviewById(int id, UiReview uiReviewUpdated, Mark mark) {

        mark = markService.findMarkByValue(uiReviewUpdated.getMark());

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

    public void deleteReviewById(int id) {
        if (reviewRepository.findById(id).isPresent()) {
            throw new ReviewNotFoundException();
        } else reviewRepository.deleteById(id);
    }

    public List<Review> findReviewByMarkId(int markId, int page) {
        Pageable pageable = PageRequest.of(page, size_of_page, Sort.by(date_of_creation).descending());
        if (reviewRepository.findReviewByMark_Id(markId, pageable).isEmpty()) {
            throw new ReviewByRatingNotFoundException(Integer.toString(markId));
        } else return reviewRepository.findReviewByMark_Id(markId, pageable);
    }

}


