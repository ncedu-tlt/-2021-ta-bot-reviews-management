package com.netcracker.edu.review.model;

import com.netcracker.edu.review.model.ui.UiReview;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "comment")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "review")
    private String review;

    @Column(name = "author_id")
    private int authorId;

    @ManyToOne
    @JoinColumn(name = "mark")
    private Mark mark;

    @Column(name = "date_creation")
    private Date dateCreation = new Date();

    @Column(name = "date_edit")
    private Date dateEdit = null;

    @Column(name = "place_id")
    private int placeId;

    public Review() {
    }

    public Review(UiReview uiReview, Mark mark) {
        setAuthorId(uiReview.getAuthorId());
        setReview(uiReview.getReview());
        setPlaceId(uiReview.getPlaceId());
        setMark(mark);
    }

}

