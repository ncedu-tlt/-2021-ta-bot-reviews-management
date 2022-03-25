package com.netcracker.edu.review.model.ui;

import lombok.Data;

@Data
public class UiReview {

    private int id;

    private String review;

    private int authorId;

    private String mark;

    public int placeId;
}
