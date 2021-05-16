package com.cloudstory.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudstory.department.entity.Department;
import com.cloudstory.department.exception.DepartmentNotFoundException;
import com.cloudstory.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("Inside save department method for DepartmentController");
		return departmentService.saveDepartment(department);
	}
	
	
	@GetMapping("/{id}")
	public Department findDepartmentById(@PathVariable Long id) {
		log.info("Inside save findDepartmentById method for DepartmentController");
		var department = departmentService.findDepartmentById(id);
		if(department==null) {
			throw new DepartmentNotFoundException("No department found for Id:: "+id);
		}else {
			return department;
		}
	}
	
	@GetMapping("/code/{code}")
	public List<Department> findDepartmentByCode(@PathVariable String code) {
		return departmentService.findDepartmentByCode(code);
		
	}

}
