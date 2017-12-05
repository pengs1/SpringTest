package com.pss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pss.domain.User;
import com.pss.repository.UserRepository;
import com.pss.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
}
