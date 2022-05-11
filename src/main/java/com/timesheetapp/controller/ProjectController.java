package com.timesheetapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.timesheetapp.model.Projects;
import com.timesheetapp.repository.ProjectRepository;

@RestController
public class ProjectController {
	
	@Autowired
	ProjectRepository projectRepository;
	
	@GetMapping("project/add/{projectCode}/{projectName}/{projectCreated}/{projectDeadline}/{totalTasks}/{tasksCompleted}/{STATUS}")
	public Projects projectdetails(@PathVariable("projectCode") String projectCode,@PathVariable("projectName") String projectName,
			@PathVariable("projectCreated") String projectCreated , @PathVariable("projectDeadline") String projectDeadline , @PathVariable("totalTasks") String totalTasks,
			@PathVariable("tasksCompleted") String tasksCompleted , @PathVariable("STATUS") String status) {
		
		Projects project = new Projects();
		project.setProjectCode(projectCode);
		project.setProjectName(projectName);
		project.setStatus(status);
		project.setProjectCreated(projectCreated);
		project.setProjectDeadline(projectDeadline);
		project.setTasksCompleted(tasksCompleted);
		project.setTotalTasks(totalTasks);
		
		Projects projectObj = projectRepository.save(project);
		return projectObj;
	}
	@GetMapping("projects/delete/{projectCode}")
	public String deleteByProjectCode(@PathVariable("projectCode") String projectCode) {
		String result=null;
		try {
			projectRepository.deleteById(projectCode);
			result="deleted";
		}catch(Exception e)
		{
			result=e.getMessage();
		}
		return result;	
	}
	
	@GetMapping("projects/list")
	public List<Projects> findAll(){
		List<Projects> projectList = projectRepository.findAll();
		return projectList;
	}

}

