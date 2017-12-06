package com.pss.service;

import java.util.List;

import com.pss.domain.User;

public interface UserService {
	
	List<User> findAllUsers();
	
	User selectUser(Integer id);
	
	List<User> listUsers();
	
}
