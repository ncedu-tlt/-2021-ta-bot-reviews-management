package com.netcracker.edu.botlocation.data.repositories;

import com.netcracker.edu.botlocation.data.models.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;


public interface CommentRepository extends CrudRepository<Comment,Integer> {
    List<Comment> AddById(UUID locationId);
}
