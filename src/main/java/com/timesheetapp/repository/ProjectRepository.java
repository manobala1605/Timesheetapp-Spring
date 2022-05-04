package com.timesheetapp.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.timesheetapp.model.Projects;

@Repository
public interface ProjectRepository extends JpaRepository<Projects , String> {
	
	@SuppressWarnings("unchecked")
	Projects save(Projects project);

	//@Transactional
	//@Modifying
	//@Query("DELETE ")
	//int deleteByProjectCodeAndProjectName(String projectCode, String projectName);

}
