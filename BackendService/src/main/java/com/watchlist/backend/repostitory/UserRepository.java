package com.watchlist.backend.repostitory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.watchlist.backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String userName);
}
