package com.netcracker.edu.addreview.services.implementations;

import com.netcracker.edu.addreview.services.interfaces.AddReviewsService;
import org.springframework.stereotype.Component;

@Component
public class AddReviewsServicempl implements AddReviewsService {

    @Override
    public String putComment(String comment) {
        return "Test review ";

    }
}
