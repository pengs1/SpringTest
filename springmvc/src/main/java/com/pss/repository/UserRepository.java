package com.pss.repository;

import java.util.List;

import com.pss.domain.User;

public interface UserRepository {
	
	List<User> findAll();
	
}
