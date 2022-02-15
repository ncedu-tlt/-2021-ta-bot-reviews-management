package com.netcracker.edu.review.database.jpa.controller;
import java.util.List;

import javax.annotation.Resource;

import com.netcracker.edu.review.database.jpa.EmployeeDao;


import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netcracker.edu.review.data.models.Reviews;


@RestController
@RequestMapping("/reviews")
class ApplicationController {

    @Resource
    EmployeeDao employeeDao;

    @PostMapping(value = "/create")
    public void createEmployee(@RequestBody Reviews rev) {
        employeeDao.insertReview(rev);

    }

}