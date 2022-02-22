package Review.services.interfaces;

import Review.model.Review;
import Review.repiositorie.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewsService {

    @Autowired
   private ReviewsRepository ReviewsRepository;

    public static Review createReview(Review newReview){return  ReviewsRepository.save(newReview);}

}
