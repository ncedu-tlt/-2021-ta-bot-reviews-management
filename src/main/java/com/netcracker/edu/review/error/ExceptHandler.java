package com.netcracker.edu.review.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptHandler {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String reviewNotFoundException (ReviewNotFoundException reviewNotFoundException){
        return reviewNotFoundException.getMessage();
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ReviewByRatingNotFoundException (ReviewByRatingNotFoundException reviewByRatingNotFoundException){
        return reviewByRatingNotFoundException.getMessage();
    }
}
