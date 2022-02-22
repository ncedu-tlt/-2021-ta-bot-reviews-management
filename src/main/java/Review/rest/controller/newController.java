package Review.rest.controller;


import Review.model.Review;
import Review.repiositorie.ReviewsRepository;
import Review.services.interfaces.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Controller
public class newController {
    @Autowired
    private ReviewsService reviewsService;

    @GetMapping("/Review")
    public ResponseEntity<Review> createUser(@RequestBody Review review) {
        return ResponseEntity.ok(ReviewsService.createReview(review));
    }
}
