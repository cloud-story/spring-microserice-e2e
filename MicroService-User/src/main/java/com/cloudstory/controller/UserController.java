package com.cloudstory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudstory.entity.User;
import com.cloudstory.service.UserService;
import com.cloudstory.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	@Autowired
	private  UserService userService;
	
	
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("Inside save user of user controller");
		return userService.saveUser(user);
	}
	
	@GetMapping("/{userId}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable Long userId) {
		log.info("Inside getUserWithDepartment of user controller");
		return userService.getUserWithDepartment(userId);
	}

}
