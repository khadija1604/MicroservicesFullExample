package com.lollaby.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FullBackController {
	
	@GetMapping("/userServiceFullBack")
	private String userServiceFullBackMethod() {
		return String.format("User service is taking longer than expected. Please try Later");
	}
    
	@GetMapping("/departmentServiceFullBack")
	private String departmentServiceFullBackMethod() {
		return String.format("Department service is taking longer than expected. Please try Later");
	}
}
