package Review.model;

import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String review;

}

