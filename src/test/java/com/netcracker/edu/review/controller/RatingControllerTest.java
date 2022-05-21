package com.netcracker.edu.review.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netcracker.edu.review.model.Rating;
import com.netcracker.edu.review.repository.MarkRepository;
import com.netcracker.edu.review.repository.RatingRepository;
import com.netcracker.edu.review.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
@SpringBootTest
class RatingControllerTest {

    private static ObjectMapper mapper = new ObjectMapper();

    @MockBean
    RatingRepository ratingRepository;

    @MockBean
    MarkRepository markRepository;

    @MockBean
    ReviewRepository reviewRepository;

    @Autowired
    private MockMvc mockMvc;

    private Rating creatRating(int i) {

        Rating rating = new Rating();

        rating.setId(i);
        rating.setAverage(4);
        rating.setNegscore(1);
        rating.setPosscore(2);
        rating.setNumber(3);


        return rating;
    }

    private List<Rating> creatListRating() {

        List<Rating> ratings = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Rating r = creatRating(1);
            ratings.add(r);
        }

        return ratings;
    }




    @Test
    void sortTenList() throws Exception {

        List<Rating> rating = creatListRating();

        Mockito.when(ratingRepository.findRatingByAverage()).thenReturn(rating);
        //String json = mapper.writeValueAsString(uiUser);
        mockMvc.perform(get("/rating/tenbestplace").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8"))
                .andExpect(status().isOk()).andDo(print());

    }

    @Test
    void findPopularPlace() throws Exception {

        List<Rating> rating = creatListRating();

        Mockito.when(ratingRepository.findRatingByAverage()).thenReturn(rating);
        //String json = mapper.writeValueAsString(uiUser);
        mockMvc.perform(get("/rating/tenbestplace").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8"))
                .andExpect(status().isOk()).andDo(print());


    }
}

//{"id":0,"sum":0,"number":3,"posscore":66,"negscore":33,"average":4.0},{"id":0,"sum":0,"number":3,"posscore":66,"negscore":33,"average":4.0},{"id":0,"sum":0,"number":3,"posscore":66,"negscore":33,"average":4.0},{"id":0,"sum":0,"number":3,"posscore":66,"negscore":33,"average":4.0},{"id":0,"sum":0,"number":3,"posscore":66,"negscore":33,"average":4.0},{"id":0,"sum":0,"number":3,"posscore":66,"negscore":33,"average":4.0},{"id":0,"sum":0,"number":3,"posscore":66,"negscore":33,"average":4.0},{"id":0,"sum":0,"number":3,"posscore":66,"negscore":33,"average":4.0},{"id":0,"sum":0,"number":3,"posscore":66,"negscore":33,"average":4.0},{"id":0,"sum":0,"number":3,"posscore":66,"negscore":33,"average":4.0}