package com.lollaby.user.constroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lollaby.user.entity.User;
import com.lollaby.user.service.UserService;
import com.lollaby.user.vo.UserDepVo;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
    
	@PostMapping
	private User save(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping
	private List<User> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/{id}")
	private User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/vo/{id}")
	private UserDepVo getUserDepTemplate(@PathVariable Long id) {
		return userService.getUserDepVo(id);
	}
}
