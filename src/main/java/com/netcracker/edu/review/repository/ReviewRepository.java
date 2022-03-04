package com.netcracker.edu.review.repository;

import com.netcracker.edu.review.model.Review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findReviewByAuthorId(int authorId);
}
