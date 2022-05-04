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
@Entity(name="timesheet_projects")
public class Projects {
	@Column(name="user_id")
	private int userId;
	
	@Id
	@Column(name = "project_code")
	private String projectCode;
	
	@Column(name = "project_name")
	private String projectName;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "created_on")
	private String projectCreated;
	
	@Column(name = "deadline")
	private String projectDeadline;
	
	@Column(name = "total_tasks")
	private String totalTasks;
	
	@Column(name = "tasks_completed")
	private String tasksCompleted;

	
	public void setProjectCode(String projectCode) {
		// TODO Auto-generated method stub
		this.projectCode=projectCode;
	}

	public void setProjectName(String projectName) {
		// TODO Auto-generated method stub
		this.projectName=projectName;
	}

	public void setStatus(String status) {
		// TODO Auto-generated method stub
		this.status=status;
	}

	public void setProjectCreated(String projectCreated) {
		// TODO Auto-generated method stub
		this.projectCreated=projectCreated;
	}

	public void setProjectDeadline(String projectDeadline) {
		// TODO Auto-generated method stub
		this.projectDeadline=projectDeadline;
	}

	public void setTasksCompleted(String tasksCompleted) {
		// TODO Auto-generated method stub
		this.tasksCompleted=tasksCompleted;
	}

	public void setTotalTasks(String totalTasks) {
		// TODO Auto-generated method stub
		this.totalTasks=totalTasks;
	}
}
