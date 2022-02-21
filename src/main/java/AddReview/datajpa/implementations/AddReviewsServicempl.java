package AddReview.datajpa.implementations;

import AddReview.datajpa.models.Reviews;
import AddReview.datajpa.repositories.ReviewsRepository;
import AddReview.services.interfaces.AddReviewsService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class AddReviewsServicempl implements AddReviewsService {


    public String addReview(String review) {
        return "Test review ";

    }

    @Override
    public Reviews create(Reviews reviews) {

        return reviews;
    }
}

