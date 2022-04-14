package com.netcracker.edu.review.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.netcracker.edu.review.model.Mark;
import com.netcracker.edu.review.model.Rating;
import com.netcracker.edu.review.model.Review;
import com.netcracker.edu.review.model.ui.UiReview;
import com.netcracker.edu.review.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingSevice {

    @Autowired
    private RatingRepository ratingRepository;

    public void setRating(UiReview uiReview, Mark mark) {

        Rating rating = ratingRepository.findAverageById(uiReview.getPlaceId());

        if (rating == null) {
            createRating(mark, uiReview);
            setScore(uiReview, mark);
        } else {
            updateRatingWhenCreatReview(mark, rating);
            setScore(uiReview, mark);
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

    public void setScore(UiReview uiReview, Mark mark) {
        Rating rating = ratingRepository.findAverageById(uiReview.getPlaceId());

        if ((mark.getId() == Score.excellent.getValueScore()) || (mark.getId() == Score.good.getValueScore())) {
            rating.setPosscore(rating.getPosscore() + 1);
        } else {
            rating.setNegscore(rating.getNegscore() + 1);
        }
        ratingRepository.save(rating);
    }

    public void updateRatingWithReview(Review review, Mark mark) {

        Rating rating = ratingRepository.findAverageById(review.getPlaceId());

        int sum = (rating.getSum() - review.getMark().getId() + mark.getId());
        int numb = rating.getNumber();

        double aveRage = (float) sum / (float) numb;

        if ((mark.getId() == Score.excellent.getValueScore()) || (mark.getId() == Score.good.getValueScore())) {
            if ((mark.getId() == Score.normal.getValueScore()) || (mark.getId() == Score.bad.getValueScore()) || (mark.getId() == Score.veryBad.getValueScore())) {
                rating.setNegscore(rating.getNegscore() + 1);
                rating.setPosscore(rating.getPosscore() - 1);
            }
        } else {
            if ((mark.getId() == Score.excellent.getValueScore()) || (mark.getId() == Score.good.getValueScore())) {
                rating.setPosscore(rating.getPosscore() + 1);
                rating.setNegscore(rating.getNegscore() - 1);
            }
        }

        rating.setAverage(Math.round(aveRage * 100.0) / 100.0);
        rating.setSum(sum);

        ratingRepository.save(rating);

    }

    public void deleteRatingWithReview(Review review) {

        Rating rating = ratingRepository.findAverageById(review.getPlaceId());

        int sum = (rating.getSum() - review.getMark().getId());
        int numb = rating.getNumber() - 1;

        double aveRage = (float) sum / (float) numb;

        if ((review.getMark().getId() == Score.excellent.getValueScore()) ||
                (review.getMark().getId() == Score.good.getValueScore())) {

            rating.setPosscore(rating.getPosscore() + 1);
        } else {
            rating.setNegscore(rating.getNegscore() + 1);
        }

        rating.setAverage(Math.round(aveRage * 100.0) / 100.0);
        rating.setSum(sum);
        rating.setNumber(numb);

        ratingRepository.save(rating);

    }


    public List<Rating> sortTenList() {
        List<Rating> rating = ratingRepository.findRatingByAverage();
        Rating rating1;

        //пересчет в процентное соотношение
        for (int i = 0; i < rating.size(); i++) {
            rating1 = rating.get(i);
            rating1.setPosscore(rating1.getPosscore() * 100 / rating1.getNumber());
            rating1.setNegscore(rating1.getNegscore() * 100 / rating1.getNumber());
            rating.set(i, rating1);
        }

        return rating;
    }

}

enum Score {
    excellent(5),
    good(4),
    normal(3),
    bad(2),
    veryBad(1);

    private final int valueScore;

    Score(int valueScore) {
        this.valueScore = valueScore;
    }

    public int getValueScore() {
        return valueScore;
    }
}


