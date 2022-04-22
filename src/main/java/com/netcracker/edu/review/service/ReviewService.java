package com.netcracker.edu.review.service;

import com.netcracker.edu.review.model.Review;
import com.netcracker.edu.review.model.ui.UiReview;
import com.netcracker.edu.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import  com.netcracker.edu.review.model.Mark;
import java.util.Date;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MarkService markService;

    @Value("${countOfReviews.size-of-page}")
    public int sizeOfPage;

    @Value("${countOfReviews.date-creation}")
    public String dateOfCreation;

    public Review createReview(UiReview uiReview, Mark mark) {

        mark = markService.findMarkByValue(uiReview.getMark());

        return reviewRepository.saveAndFlush(new Review(uiReview, mark));
    }

    public List<Review> findReviewByAuthorId(int authorId,int page) {
        Pageable pageable = PageRequest.of(page, sizeOfPage, Sort.by(dateOfCreation).descending());

      return reviewRepository.findReviewByAuthorId(authorId, pageable);}

    public List<Review> findReviewByReviewId(int id) {

        return reviewRepository.findReviewById(id);}

    public List<Review> findReviewByPlaceId(int placeId, int page) {
        Pageable pageable = PageRequest.of(page, sizeOfPage,  Sort.by(dateOfCreation).descending());
        return reviewRepository.findReviewByPlaceId(placeId, pageable);
    }

    public List<Review> findReviewByPlaceIdAndAuthorId(int placeId,int authorId, int page) {
        Pageable pageable = PageRequest.of(page, sizeOfPage,  Sort.by(dateOfCreation).descending());
        return reviewRepository.findReviewByPlaceIdAndAuthorId(placeId, authorId, pageable);
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

    public void deleteReviewByid(int id) {
        reviewRepository.deleteById(id);
        }
}


