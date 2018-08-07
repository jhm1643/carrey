package com.carrey.auth.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carrey.auth.web.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);
}
