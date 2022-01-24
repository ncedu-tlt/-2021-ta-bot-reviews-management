package com.netcracker.edu.botlocation.data.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netcracker.edu.botlocation.data.models.Location;

//@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

    List<Location> findById(UUID locationId);
}
