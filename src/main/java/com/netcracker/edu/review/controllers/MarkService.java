package com.netcracker.edu.review.controllers;

import com.netcracker.edu.review.model.Mark;
import com.netcracker.edu.review.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkService {
    @Autowired
    MarkRepository markRepository;

    public Mark findMarkByValue(String value) {
        return markRepository.findMarkByValue(value);
    }

}
