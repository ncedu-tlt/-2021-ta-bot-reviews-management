package AddReview.datajpa.repositories;

import java.util.List;

import AddReview.datajpa.models.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepository extends JpaRepository<Reviews, Long> {

    static void saveandFlush(Reviews reviews) {
    }

    List<Reviews> getId(int id);

    Reviews getReview(String review);


}