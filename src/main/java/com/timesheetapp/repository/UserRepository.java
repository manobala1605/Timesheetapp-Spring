package com.timesheetapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timesheetapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User ,Integer>{
	
	@SuppressWarnings("unchecked")
	User save(User user);

	List<User> findAll();
	
	User findByEmailAndPassword(String email, String password);

//	User changePassword(Integer id, String password);
}

