package com.timesheetapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.timesheetapp.model.User;
import com.timesheetapp.repository.UserRepository;

@RestController
public class UserDetailsController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("users/register")
	public User register(@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("mobile") String mobile,
			@RequestParam("role") String role
	) {
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setMobile(mobile);
		user.setRole("USER");
		
		//save
		User userObj = userRepository.save(user);
		return userObj;
	}
	
	@PostMapping("users/register")
	public User register(@RequestBody User user) {
		User userObj = userRepository.save(user);
		return userObj;
	}
	
	@GetMapping("users/list")
	public List<User> getAllUsers(){
		List<User> userList = userRepository.findAll();
		for(User user:userList)
		{
			System.out.println(user.toString());
		}
		return userList;
	}
	
	@DeleteMapping("users/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		userRepository.deleteById(id);
		System.out.println("user deleted");
	}
	
	@PutMapping("users/{id}")
	public void update() {
	
	}
	
	@GetMapping("users/login")
	public User login(
			@RequestParam("email") String email,
			@RequestParam("password") String password) throws Exception {
		User user = userRepository.findByEmailAndPassword(email, password);
		if(user == null) {
			throw new Exception("Invalid Login Credentials");
		}
		return user;
	
	}
	
	@GetMapping("user/{id}")
	public User findById(@PathVariable("id") Integer id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		else {
			return null;
		}
	}
	
//	@GetMapping("users/change-password/{id}")
//	public void changePassword(@PathVariable("id") Integer id, @RequestParam("password") String password) {
//		userRepository.changePassword(id, password);
//	}

}
