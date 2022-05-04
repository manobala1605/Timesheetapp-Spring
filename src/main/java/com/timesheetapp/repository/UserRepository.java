package com.timesheetapp.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.timesheetapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@SuppressWarnings("unchecked")
	User save(User user);
	User findByEmailAndPassword(String email, String password);
	
	User findByEmailAndPasswordAndRole(String email, String Password,String role);

	String deleteById(int id);
	//List<User> findByuser(String role);
	//Optional<User> findByRole(String role);
	@Transactional
	@Modifying
	@Query("Select u.name from com.timesheetapp.model.User u")
	List<String> listName();
	
	@Transactional
	@Modifying
	@Query("UPDATE com.timesheetapp.model.User u SET u.password=password WHERE u.userId = userId")
	void updatePassword(@Param("userId") Integer userId,@Param("password") String password);
	//String updatePassword(String email, String password);
}

