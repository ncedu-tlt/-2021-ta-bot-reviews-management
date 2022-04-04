package com.netcracker.edu.review.service;

import com.netcracker.edu.review.model.Rating;
import com.netcracker.edu.review.model.Mark;
import com.netcracker.edu.review.model.ui.UiReview;
import com.netcracker.edu.review.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingSevice {

    @Autowired
    private RatingRepository ratingRepository;

    public void setRating(UiReview uiReview, Mark mark) {

        Rating average = ratingRepository.findAverageById(uiReview.getPlaceId());

        if (average == null) {
            createRating(mark, average);
        } else {
            updateRating(mark, average);
        }

    }

    public void createRating(Mark mark, Rating average) {

        average.setAverage(mark.getId());
        average.setSum(mark.getId());
        average.setNumber(1);
        average.setId(mark.getId());

        ratingRepository.save(average);
    }

    public void updateRating(Mark mark, Rating average) {

        int sum = (average.getSum() + mark.getId());
        int numb = average.getNumber() + 1;
        double aveRage = (float) sum / (float) numb;

        average.setAverage(Math.round(aveRage * 100.0) / 100.0);
        average.setSum(sum);
        average.setNumber(numb);

        ratingRepository.save(average);
    }
}
