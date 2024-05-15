package com.amal.piece.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amal.piece.entities.User;



public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
