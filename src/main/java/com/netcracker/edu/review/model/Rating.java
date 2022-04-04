package com.netcracker.edu.review.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "rating")
public class Rating {

    @Id
    private int id;

    @Column (name = "sum")
    private int sum;

    @Column (name = "number")
    private int number;

    @Column (name = "average")
    private double average;



}
