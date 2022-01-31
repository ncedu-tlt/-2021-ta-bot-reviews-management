package com.netcracker.edu.addreview.data.repositories;

import com.netcracker.edu.addreview.data.models.reviews;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;


public interface ReviewsRepository extends CrudRepository<reviews,Integer> {
    List<reviews> AddById(UUID locationId);
}
