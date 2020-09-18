package com.watchlist.backend.repostitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.watchlist.backend.model.Review;
import com.watchlist.backend.model.ReviewID;

@Repository
public interface ReviewRepository extends JpaRepository<Review, ReviewID> {

	List<Review> findAllByUserID(int userID);

}
