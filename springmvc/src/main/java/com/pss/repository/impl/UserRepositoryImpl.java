package com.pss.repository.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.pss.domain.User;
import com.pss.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private String sqlFindUserForPage = null;
	
	private static final String SELECT_FROM = "SELECT * FROM ";
	
	
	/**
	 * Init method to generate sql statement.
	 */
	@PostConstruct
	public void init() {
		this.sqlFindUserForPage = SELECT_FROM + "USER where ID = ?1";
	}
	
	/**
	 * get all user
	 */
	public List<User> findAll() {
		String sql = "SELECT ad FROM User ad ORDER BY ad.id";
		TypedQuery<User> typedQuery = this.entityManager.createQuery(sql, User.class);
		return typedQuery.getResultList();
	}
	
	public User findUsrById() {
		Query query = this.entityManager.createNativeQuery(this.sqlFindUserForPage, User.class);
		query.setParameter(1, 1);
		List<User> uses = query.getResultList();
		if(uses.size()>0) {
			return uses.get(0);
		} else {
			return null;
		}
	}

}
