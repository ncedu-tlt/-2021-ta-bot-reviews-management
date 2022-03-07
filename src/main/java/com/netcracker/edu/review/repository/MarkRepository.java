package com.netcracker.edu.review.repository;

import com.netcracker.edu.review.model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository<Mark,String> {
    Mark findMarkByValue(String value);
}
