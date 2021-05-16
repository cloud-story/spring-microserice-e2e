package com.cloudstory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {
	
	@GetMapping("/userServiceFallback")
	public String userSericeFallback() {
		return "User service taking longer than expected to response, please try later";
		
	}

	@GetMapping("/departmentServiceFallback")
	public String departmentSericeFallback() {
		return "Department service taking longer than expected to response, please try later";
		
	}
}
