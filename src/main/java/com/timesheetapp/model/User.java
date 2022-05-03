package com.timesheetapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "timesheet_app_users")
public class User {
	@Id
	@Column(name = "user_id")
	private int userId;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "mobile")
	private String mobileNumber;

	@Column(name = "role")
	private String role;
	
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name=name;
	}

	public void setMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		this.mobileNumber = mobileNumber;
		
	}

	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password = password;
	}

	public void setEmail(String email) {
		// TODO Auto-generated method stub
		this.email=email;
	}

	public void setRole(String role) {
		// TODO Auto-generated method stub
		this.role=role;
	}

	
}