package com.netcracker.edu.review.database;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.netcracker.edu.review.data.models.Reviews;

public class ReviewsRowMapper implements RowMapper<Reviews> {

    @Override
    public Reviews mapRow(ResultSet rs, int arg1) throws SQLException {
        Reviews rew = new Reviews();


        return rew;
    }
}

