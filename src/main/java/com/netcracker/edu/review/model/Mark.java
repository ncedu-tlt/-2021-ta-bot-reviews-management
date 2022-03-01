package com.netcracker.edu.review.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "mark")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne(mappedBy = "mark")
    private Review review;
    @Column(name = "value")
    private String value;
    public Mark(int id, String value){
        setId(id);
        setValue(value);
    }
}
