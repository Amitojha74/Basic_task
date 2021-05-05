package com.spring.demo.service;

import org.springframework.stereotype.Service;

import com.spring.demo.model.User;

@Service
public interface UserService {

	User save(User user);

	User getById(int uid);

}
