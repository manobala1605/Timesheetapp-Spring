package com.timesheetapp.repository;

import java.util.List;

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
	//Transaction save(Transaction transaction);
	User findByEmailAndPassword(String email, String password);
	
	User findByEmailAndPasswordAndRole(String email, String Password,String role);
//
//	User findByMobileNumberAndPasswordAndUser(String MobileNumber, String Password, String status);
//
//	User findByMobileNumberAndPassword(String MobileNumber, String Password);
//
//	List<User> findByuser(String user);
//

//	@Modifying
//	@Query("update banking u set u.amount = :amount where u.mobileNumber=:MobileNumber")
//	void changeAmount(@Param("amount") int amount, @Param("MobileNumber") String MobileNumber); 

//	User findByMobileNumber(String mobileNumber);
//		
//	
////	@Modifying
////	@Query("select u from com.bankapp.bankappapi.model.Transaction u where u.mobileNumber=:mobilenumber")
//	//List<Transaction> findbymobileNumber(@Param("mobilenumber")String mobilenumber);
//	//Transaction findbymobileNumber(String mobileNumber);
	
	//@Modifying
	//@Query("delete from com.timesheetapp.model.User where u.userId=:id")
	String deleteById(int id);
	//String updatePassword(String email, String password);

}

