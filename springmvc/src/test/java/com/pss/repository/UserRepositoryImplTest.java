package com.pss.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.pss.domain.User;
import com.pss.utils.XMLReaderUtils;

@ContextConfiguration(locations = "classpath:/spring/UserRepositoryTest-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserRepositoryImplTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRepositoryTestUtility userRepositoryTestUtility;
	
	@Transactional
	@Test
	public void testFindAll() {
		userRepositoryTestUtility.createAndPersistUserByName("pengs");
		List<User> users = userRepository.findAll();
		assertEquals("User size is not equal 3", 3, users.size());
	}

}
