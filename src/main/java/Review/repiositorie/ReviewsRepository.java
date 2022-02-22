package Review.repiositorie;

import Review.model.Review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReviewsRepository extends JpaRepository<Review, Integer> {
}
