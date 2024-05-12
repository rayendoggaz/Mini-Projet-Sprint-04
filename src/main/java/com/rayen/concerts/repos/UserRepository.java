package com.rayen.concerts.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rayen.concerts.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername (String username);
}
