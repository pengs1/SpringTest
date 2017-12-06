package com.pss.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pss.domain.User;

@Repository
public interface UserMapper {
	
	User selectUser(Integer id);
	
	List<User> listUsers();
}
