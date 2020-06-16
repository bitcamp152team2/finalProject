package com.project.bit.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.bit.project.domain.ProjectTaskStatusDTO;
import com.project.bit.project.service.ProjectTaskService;

@Controller
public class ProjectTaskController {
	
	@Autowired
	private ProjectTaskService projectTaskService;
	
	@GetMapping("/projectTask/{projectCode}")
	public String getProjectTask(@PathVariable String projectCode, Model model) {
		model.addAttribute("taskGroupList", projectTaskService.getProjectTaskGroup(projectCode));
		return "project/projectTask";
	}
	
	
	
	
	@ModelAttribute("taskStatusList")
	public List<ProjectTaskStatusDTO> getTaskStatusList(){
		return projectTaskService.getTaskStatus();
	}
}
