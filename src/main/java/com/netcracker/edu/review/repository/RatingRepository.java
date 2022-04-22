package com.netcracker.edu.review.repository;

import com.netcracker.edu.review.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    Rating findAverageById(int id);

    @Query(value = "SELECT *" +
            "from rating r\n" +
            "order by r.average desc limit 10", nativeQuery = true)
    List<Rating> findRatingByAverage();


    @Query(value = "SELECT * from rating r where r.id in :placeId order by r.average desc", nativeQuery = true)
    List<Rating> findRatingById(@Param("placeId") int[] placeId);
}
