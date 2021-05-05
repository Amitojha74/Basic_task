package com.spring.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.model.User;
import com.spring.demo.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo repo;
	
	public User save(User user)
	{
		User user1=new User();
		user1.setId(user.getId());
		user1.setName(user.getName());
		user1.setAge(user.getAge());
		user1.setUid(user.getUid());
		
		return repo.save(user1);
	}

	public User getById(int uid) {
		return repo.findById(uid);
	}

}
