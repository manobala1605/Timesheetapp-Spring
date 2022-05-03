package com.timesheetapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timesheetapp.model.User;
import com.timesheetapp.repository.UserRepository;


@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("user/register/{name}/{mobileNumber}/{email}/{password}")
	public User registerdetails(@PathVariable("name") String name, 
			@PathVariable("mobileNumber") String mobileNumber, @PathVariable("email") String email,
			 @PathVariable("password") String password,@PathVariable("role") String role) {
		// System.out.println("Register entered");

		User user = new User();
		user.setName(name);
		user.setMobileNumber(mobileNumber);
		user.setPassword(password);
		user.setEmail(email);
		user.setRole(role="USER");
		User userObj = userRepository.save(user);
		return userObj;

	}

	@PutMapping("user/login/{email}/{Password}")
	public String login(@PathVariable("email") String email, @PathVariable("Password") String Password,@PathVariable("role") String role) {
		User user = new User();
		user.setEmail(email);
		user.setPassword(Password);

		User userObj = userRepository.findByEmailAndPassword(email, Password);
		if (userObj == null) {
			return "no users found";
		} else {
			User userObj2 = userRepository.findByEmailAndPasswordAndRole(email, Password,role);
			if (userObj2 == null) {
				return "You are not an user";
			}
			return "success";
		}
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
/*	@GetMapping("admin/list")
	public List<User> getAllUsers(@PathVariable("role") String role) {
		//String role = "user";
		List<User> userList = userRepository.findByuser(role);
		return userList;
	}
*/
	@DeleteMapping("deletebyid/{userId}")
	public String deleteById(@PathVariable("userId") int userId) {
		String message = userRepository.deleteById(userId);
	//	if(row==1) {
			return message;
	}
	
//	@PatchMapping("update-password/{email}/{password}")
//	public String updatePassword(@PathVariable("email") String email, @PathVariable("password") String password) {
//		String message = userRepository.updatePassword(email,password);
//		return message;
//	}
}