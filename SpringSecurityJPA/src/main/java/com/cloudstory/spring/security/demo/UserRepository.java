package com.cloudstory.spring.security.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudstory.spring.security.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUserName(String userName);
}
