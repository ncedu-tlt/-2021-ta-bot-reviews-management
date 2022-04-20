package com.netcracker.edu.review.repository;

import com.netcracker.edu.review.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    Rating findAverageById(int id);

    @Query(value = "SELECT *" +
            "from rating r\n" +
            "         left join comment on r.id = comment.place_id\n" +
            "where comment.date_creation >= (current_date - interval '30' day)\n" +
            "order by r.average desc limit 10", nativeQuery = true)
    List<Rating> findRatingByAverage();
}
