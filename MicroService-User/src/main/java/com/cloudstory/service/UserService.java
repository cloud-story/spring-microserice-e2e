package com.cloudstory.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cloudstory.entity.User;
import com.cloudstory.repository.UserRepository;
import com.cloudstory.vo.Department;
import com.cloudstory.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("Inside save user of UserService");
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("Inside getUserWithDepartment of UserService");

		ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();

		Optional<User> result = userRepository.findById(userId);

		if (result.isPresent()) {
			User user = result.get();
			Department department = restTemplate
					.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);

			responseTemplateVO.setUser(user);
			responseTemplateVO.setDepartment(department);

			return responseTemplateVO;
		}

		return null;
	}

}
