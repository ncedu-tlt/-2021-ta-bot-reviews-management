package com.netcracker.edu.review.error;

public class ReviewNotFoundException extends RuntimeException{

    public ReviewNotFoundException(){
        super(String.format("Review(s) not found!"));
    }
}
