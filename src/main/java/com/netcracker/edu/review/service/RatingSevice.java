package com.netcracker.edu.review.service;

import com.netcracker.edu.review.model.Mark;
import com.netcracker.edu.review.model.Rating;
import com.netcracker.edu.review.model.Review;
import com.netcracker.edu.review.model.ui.UiReview;
import com.netcracker.edu.review.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingSevice {

    @Autowired
    private RatingRepository ratingRepository;

    public void setRating(UiReview uiReview, Mark mark) {

        Rating rating = ratingRepository.findAverageById(uiReview.getPlaceId());

        if (rating == null) {
            createRating(mark, uiReview);
        } else {
            updateRatingWhenCreatReview(mark, rating);
        }

    }

    public void createRating(Mark mark, UiReview uiReview) {

        Rating rating = new Rating();
        rating.setAverage(mark.getId());
        rating.setSum(mark.getId());
        rating.setNumber(1);
        rating.setId(uiReview.getPlaceId());

        ratingRepository.save(rating);
    }

    public void updateRatingWhenCreatReview(Mark mark, Rating rating) {

        int sum = (rating.getSum() + mark.getId());
        int numb = rating.getNumber() + 1;

        double aveRage = (float) sum / (float) numb;

        rating.setAverage(Math.round(aveRage * 100.0) / 100.0);
        rating.setSum(sum);
        rating.setNumber(numb);

        ratingRepository.save(rating);
    }

    public void updateRatingWithReview(Review review, Mark mark) {

        Rating rating = ratingRepository.findAverageById(review.getPlaceId());

        int sum = (rating.getSum() - review.getMark().getId() + mark.getId());
        int numb = rating.getNumber();

        double aveRage = (float) sum / (float) numb;

        rating.setAverage(Math.round(aveRage * 100.0) / 100.0);
        rating.setSum(sum);

        ratingRepository.save(rating);

    }

    public void deleteRatingWithReview(Review review) {

        Rating rating = ratingRepository.findAverageById(review.getPlaceId());

        int sum = (rating.getSum() - review.getMark().getId());
        int numb = rating.getNumber() - 1;

        double aveRage = (float) sum / (float) numb;

        rating.setAverage(Math.round(aveRage * 100.0) / 100.0);
        rating.setSum(sum);
        rating.setNumber(numb);

        ratingRepository.save(rating);

    }
}
