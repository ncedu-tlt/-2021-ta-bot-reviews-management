package com.netcracker.edu.review.repository;

import com.netcracker.edu.review.model.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    List<Review> findReviewByAuthorId(int authorId, Pageable pageable);

    @Query(value = "select *\n" +
            "from comment com\n" +
            "where com.date_creation >= (current_date - interval '30' day) and com.place_id = :placeId", nativeQuery = true)
    List<Review> findReviewByPlaceId(@Param("placeId") int placeId, Pageable pageable);

    List<Review> findReviewByPlaceIdAndAuthorId(int placeId, int authorId, Pageable pageable);

    List<Review> findReviewByPlaceIdAndMark_Id(int placeId, int markId, Pageable pageable);

    List<Review> findReviewById(int id);
}
