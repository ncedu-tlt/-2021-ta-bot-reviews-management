package com.netcracker.edu.review.database.jpa;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.netcracker.edu.review.data.models.Reviews;
import com.netcracker.edu.review.database.jpa.ReviewsRowMapper;
@Repository
class ReviewsDaoImpl implements EmployeeDao{

    public ReviewsDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }
    NamedParameterJdbcTemplate template;

    @Override
    public List<Reviews> findAll() {
        return template.query("select * from review_table", new ReviewsRowMapper());
    }


    @Override
    public void insertReview(Reviews rev) {
        final String sql = "INSERT INTO review_table (id, review) VALUES ('18', 'Nice review')";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("userID", rev.getId())
                .addValue("userID", rev.getId());
        template.update(sql,param, holder);

    }

}