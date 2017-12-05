package com.pss.repository;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.pss.domain.User;

@Repository
public class UserRepositoryTestUtility {
	
	@PersistenceContext(unitName="persistenceUnit")
	private EntityManager entityManager;
	
	/**
	 * Persist user data in the database.
	 * 
	 * @param userName the name of user
	 * @return user object
	 */
	public User createAndPersistUserByName(String userName) {
		User user = createUser(userName);
		entityManager.persist(user);
		entityManager.flush();
		return user;
	}
	
	/**
	 * Create a new user with a user profile. Note: it won't be really stored in the DB, please call
	 * persist user to persist it.
	 * 
	 * @param userName the user name
	 * @return user object
	 */
	private User createUser(String userName) {
		User user = new User();
		user.setName("haha");
		user.setAge(20);
		user.setAdress("china");
		user.setGender("1");
		user.setStatus(false);
		user.setCreateTimestamp(new Date());
		user.setCreateUserId(0L);
		user.setUpdateTimestamp(new Date());
		user.setUpdateUserId(0L);
		return user;
	}
	
}
