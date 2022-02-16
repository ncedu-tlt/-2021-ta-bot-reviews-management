package com.netcracker.edu.review.database.controller;

import javax.annotation.Resource;

import com.netcracker.edu.review.database.ReviewDao;


import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netcracker.edu.review.data.models.Reviews;


@RestController
@RequestMapping("/reviews")
class ApplicationController {

    @Resource
    ReviewDao reviewDao;

    @PostMapping(value = "/create")
    public void createReview(@RequestBody Reviews rev) {
        reviewDao.insertReview(rev);

    }

}