package com.netcracker.edu.review.data.repositories;

import com.netcracker.edu.review.data.models.Reviews;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;


public interface ReviewsRepository extends CrudRepository<Reviews,Integer> {
    List<Reviews> addById(UUID locationId);
}
