package com.netcracker.edu.review.database.jpa;

import java.util.List;

import com.netcracker.edu.review.data.models.Reviews;

public interface EmployeeDao {

    List<Reviews> findAll();

    void insertReview(Reviews rew);

}
