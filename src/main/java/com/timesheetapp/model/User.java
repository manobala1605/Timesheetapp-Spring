package com.timesheetapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="timesheet_app_users")
public class User {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncrement
	@Column(name="user_id")
	private Integer id;
	
	@Column(name="name", nullable = false, length = 50)
	private String name;
	
	@Column(name="email", unique = true , nullable = false)
	private String email;
	
	@Column(name="password", nullable = false )
	private String password;
	
	@Column(name="mobile", nullable = false )
	private String mobile;
	
	@Column(name="role", nullable = false )
	private String role ="USER";

	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	public void setEmail(String email) {
		// TODO Auto-generated method stub
		this.email=email;
		
	}

	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password=password;
	}

	public void setRole(String role) {
		// TODO Auto-generated method stub
		this.role=role;
	}

	public void setMobile(String mobile) {
		// TODO Auto-generated method stub
		this.mobile = mobile;
		
	}

}
	