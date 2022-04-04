package com.netcracker.edu.review.repository;

import com.netcracker.edu.review.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    Rating findAverageById(int id);
}
