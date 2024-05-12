package com.rayen.concerts.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rayen.concerts.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}