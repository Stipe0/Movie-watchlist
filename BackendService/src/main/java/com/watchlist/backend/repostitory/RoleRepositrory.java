package com.watchlist.backend.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.watchlist.backend.model.Role;

@Repository
public interface RoleRepositrory extends JpaRepository<Role, Integer> {

}
