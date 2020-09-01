package com.watchlist.backend.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.watchlist.backend.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
