package com.timesheetapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.timesheetapp.model.User;
import com.timesheetapp.repository.UserRepository;


@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("user/register")
	public User user(@RequestBody User user) {
		System.out.println(user);
	User userObj = userRepository.save(user);
	System.out.println(userObj);
	return userObj;
	}

	@PostMapping("user/login")
	public User login(@RequestBody User user) {
		User userObj = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		return userObj;

	}
	@PutMapping("admin/login/{email}/{Password}/{role}")
	public String adminLogin(@PathVariable("email") String email,
			@PathVariable("Password") String Password,@PathVariable("role") String role) {
		User user = new User();
		user.setEmail(email);
		user.setPassword(Password);
		//email type = "Admin";

		User userObj = userRepository.findByEmailAndPassword(email, Password);
		if (userObj == null) {
			return "no users found";
		} else {
			User userObj2 = userRepository.findByEmailAndPasswordAndRole(email, Password,role);
			if (userObj2 == null) {
				return "You are not a admin.If you are user try to login in user Login";
			}
			return "success";
		}
	}
//
	@GetMapping("User/list")
	public List<User> findAll() {
		List<User> userList = userRepository.findAll();
		return userList;
	}

	@GetMapping("User/listname")
	public List<String> findcustomername() {
		List<String> user = userRepository.listName();
		return user;
}
	
	@DeleteMapping("deletebyid/{userId}")
	public String deleteById(@PathVariable("userId") int userId) {
		String message = userRepository.deleteById(userId);
			return message;
	}
	
	@PutMapping("Users/{userId}")
	public void update(@PathVariable("userId") Integer userId, @RequestBody User user) {
		user.setUserId(userId);
		userRepository.save(user);
	}
	
	@PatchMapping("updatePassword/{userId}/{password}")
	public void updatePassword(@PathVariable("userId") Integer userId, @PathVariable("password") String password) {
		userRepository.updatePassword(userId,password);
		return;
	}
}