package com.cloudstory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloudstory.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
