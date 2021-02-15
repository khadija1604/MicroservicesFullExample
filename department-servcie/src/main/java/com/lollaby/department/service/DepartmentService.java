package com.lollaby.department.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lollaby.department.entity.Department;
import com.lollaby.department.exception.DepartmentApiException;
import com.lollaby.department.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department saveDepartment(Department department){
		return departmentRepository.save(department);
	}
	
	public List<Department> getDepartments() throws DepartmentApiException{
		List<Department> departments= departmentRepository.findAll();
		if(departments.isEmpty())
			createThrownException("The departments list is empty there are no departments");
		return departments;
	}


	
	public Optional<Department> findyId(Long id) throws DepartmentApiException{
		Optional<Department> opt= departmentRepository.findById(id);
		if(opt.isEmpty()) createThrownException("the requested department doesn't exist");
		return opt;
	}
	
	private void createThrownException(String message) {
		throw new DepartmentApiException(message);
	}
}
