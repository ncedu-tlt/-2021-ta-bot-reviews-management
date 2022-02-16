package com.netcracker.edu.review.services.implementations;

import com.netcracker.edu.review.services.interfaces.AddReviewsService;
import org.springframework.stereotype.Component;

@Component
public class AddReviewsServicempl implements AddReviewsService {


    public String addReview(String review) {
        return "Test review ";

    }
}

