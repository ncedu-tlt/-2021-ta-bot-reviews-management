package com.netcracker.edu.review.datajpa.repositories;

import java.util.List;

import com.netcracker.edu.review.datajpa.models.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ReviewsRepository extends JpaRepository<Reviews, Long> {

    List<Reviews> getId(int id);

    Reviews getReview(String review);


}