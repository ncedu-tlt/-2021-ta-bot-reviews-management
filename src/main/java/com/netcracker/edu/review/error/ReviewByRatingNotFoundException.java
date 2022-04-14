package com.netcracker.edu.review.error;

public class ReviewByRatingNotFoundException extends RuntimeException {
    public ReviewByRatingNotFoundException(String markId) {
        super(String.format("Review(s) with rating = %s not found!", markId));
    }
}
