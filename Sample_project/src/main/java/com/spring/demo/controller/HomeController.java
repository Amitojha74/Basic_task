package com.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.model.User;
import com.spring.demo.repository.UserRepo;
import com.spring.demo.service.UserService;

@RestController
public class HomeController {

	@Autowired
	private UserRepo repo;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ResponseEntity<User> SaveUser(@RequestBody User user) {
		return ResponseEntity.ok(userService.save(user));
	}

	@RequestMapping(value = "/get/{uid}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> retrieve(@PathVariable("uid") int uid) {	
		User user= userService.getById(uid);
			if (user==null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
			}
		return ResponseEntity.ok(user);
	}

	@GetMapping("/getall")
	public List<User> getAll() {
		List<User> userResponse = repo.findAll();
		return userResponse;
	}

}
