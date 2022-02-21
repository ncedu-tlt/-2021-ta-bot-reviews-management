package AddReview.rest.controllers;

import AddReview.datajpa.models.Reviews;
import AddReview.datajpa.repositories.ReviewsRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class newController {
    @PostMapping("/Review")
    public Reviews create(@RequestBody Reviews reviews)
    {
        ReviewsRepository.saveandFlush(reviews);
        return reviews;
    }

}
