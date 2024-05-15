package com.amal.piece.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amal.piece.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRole(String role);
	
	
}
