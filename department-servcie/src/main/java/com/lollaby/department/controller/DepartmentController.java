package com.lollaby.department.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lollaby.department.entity.Department;
import com.lollaby.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
	
   @Autowired
   private DepartmentService departmentService;
	
	@PostMapping
	private Department save(@RequestBody Department department ) {
		log.info("In department save");
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping
	private List<Department> getDepartments(){
		return departmentService.getDepartments();
	}
	
	@GetMapping("/{id}")
	private Department getDepartmentById(@PathVariable Long id) {
		Optional<Department> optDepartment= departmentService.findyId(id);
		if(optDepartment.isEmpty()) throw new RuntimeException("the department doesn't exists");
		return optDepartment.get();
	}

}
