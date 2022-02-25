package com.netcracker.edu.review.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Comment")
public class Review {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column(name = "review")
    private String review;


}

