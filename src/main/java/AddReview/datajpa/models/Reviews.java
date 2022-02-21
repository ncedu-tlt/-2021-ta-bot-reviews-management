package AddReview.datajpa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String review;


    protected Reviews() {}

    public Reviews(int  id, String review) {
        this.id = id;
        this.review = review;
    }

    @Override
    public String toString() {
        return String.format(
                "Reviews[id=%d, review='%s']",
                id, review);
    }

    public int getId() {
        return id;
    }

    public String getReview() {
        return review;
    }


}
