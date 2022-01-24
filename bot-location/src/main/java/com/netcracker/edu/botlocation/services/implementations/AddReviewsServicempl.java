package com.netcracker.edu.botlocation.services.implementations;

import com.netcracker.edu.botlocation.services.interfaces.AddReviewsService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class AddReviewsServicempl implements AddReviewsService {

    @Override
    public String getComment(String comment) {
        return "Test comment";

    }
}
