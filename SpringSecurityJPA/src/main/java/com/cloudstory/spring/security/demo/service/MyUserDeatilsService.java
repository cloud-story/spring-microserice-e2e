package com.cloudstory.spring.security.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cloudstory.spring.security.demo.UserRepository;
import com.cloudstory.spring.security.demo.component.MyUserDeatils;
import com.cloudstory.spring.security.demo.entity.User;

@Service
public class MyUserDeatilsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user = userRepository.findByUserName(username);
		
		user.orElseThrow(()->new UsernameNotFoundException("User not found:: "+username));
		
		return user.map(MyUserDeatils::new).get();
	}

}
