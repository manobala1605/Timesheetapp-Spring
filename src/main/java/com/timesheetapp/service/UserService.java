package com.timesheetapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.timesheetapp.Validation.UserValidation;
import com.timesheetapp.model.User;
import com.timesheetapp.repository.UserRepository;

@Service
public class UserService {
@Autowired

UserRepository userRepository;
	

	public User register(@RequestBody User user)throws Exception
	{
		UserValidation.validate(user);
		User userObj=userRepository.save(user);
		return userObj;
	}
	public String login(@RequestBody User user) {
		User userObj=userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
		if(userObj != null) {
			return "success";
		}else {
		return "unsuccess";
		}
}
}