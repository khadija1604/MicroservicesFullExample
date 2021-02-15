package com.lollaby.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lollaby.user.entity.Department;
import com.lollaby.user.entity.User;
import com.lollaby.user.repository.UserRepository;
import com.lollaby.user.vo.UserDepVo;

@Service
public class UserService {
	
@Autowired
private UserRepository userRepository;

@Autowired
private RestTemplate restTemplate;

  public User saveUser(User user) {
	return userRepository.save(user);
 }

  public List<User> getUsers() {
	
	return userRepository.findAll();
 }

 public User getUserById(Long id) {
	 Optional<User> optUser = userRepository.findById(id);
	 if(optUser.isEmpty()) throw new RuntimeException(String.format("User with id: {} is not found", id));
	 return optUser.get();
 }

public UserDepVo getUserDepVo(Long id) {
	 UserDepVo userDepVo=new UserDepVo();
	 User user= getUserById(id);
	 Department department= restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
	 userDepVo.setUser(user);
	 userDepVo.setDepartment(department);
	return userDepVo;
}
}
