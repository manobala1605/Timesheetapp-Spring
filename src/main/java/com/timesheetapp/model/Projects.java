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
@Entity(name="")
public class Projects {
	@Id
	@Column(name="user_id")
	private int userId;
	
	@Column(name = "name")
	private String name;
	@Column(name = "name")
	private String name;
	@Column(name = "name")
	private String name;
}
