package AddReview.rest.controllers;

import AddReview.datajpa.models.Reviews;
import AddReview.services.interfaces.AddReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewsController<addReviewsService> {
    private final addReviewsService addReviewsService;


    @Autowired
    public ReviewsController(addReviewsService addReviewsService) {
        this.addReviewsService = addReviewsService;
    }

    @PutMapping("/addReviews/{review}")
    public String AddReviews(@PathVariable("review") String review) {
        return AddReviewsService.addReview(review);
    }
}
