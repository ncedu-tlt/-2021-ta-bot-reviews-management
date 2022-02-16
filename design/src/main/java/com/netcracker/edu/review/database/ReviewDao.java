package com.netcracker.edu.review.database;

import java.util.List;

import com.netcracker.edu.review.data.models.Reviews;

public interface ReviewDao {

    List<Reviews> findAll();

    void insertReview(Reviews rew);

}
