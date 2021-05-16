package com.cloudstory.department.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudstory.department.entity.Department;
import com.cloudstory.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	
	@Autowired
	DepartmentRepository  departmentRepository;

	public Department saveDepartment(Department department) {
		log.info("Inside saveDepartment of DepartmentService");

		return departmentRepository.save(department);
	}

	public Department findDepartmentById(Long departmentId) {
		log.info("Inside saveDepartment of findDepartmentById");
		Optional<Department> result = departmentRepository.findById(departmentId);
		return result.isPresent()?result.get():null;
	}

	public List<Department> findDepartmentByCode(String code) {
		log.info("Inside findDepartmentByCode of DepartmentService");

		return departmentRepository.findByCode(code);

	}

}
