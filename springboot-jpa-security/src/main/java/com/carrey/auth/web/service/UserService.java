package com.carrey.auth.web.service;

import com.carrey.auth.web.model.User;

public interface UserService {
	void saveUser(User user,String[] roles);
	  User findByUsername(String username);
}
