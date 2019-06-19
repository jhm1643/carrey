package com.example.demo.service;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;
import com.example.demo.vo.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@PersistenceContext
	EntityManager em;
	
	public void userInsert(User user) {
		em.persist(user);
	}
	
	public Iterable<User> userSelect() {
		return userRepository.findAll();
	}
}
