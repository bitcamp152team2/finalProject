package com.project.bit.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bit.foo.domain.Users;
import com.project.bit.foo.service.PositionsService;
import com.project.bit.foo.service.TeamsService;
import com.project.bit.foo.service.UserService;
import com.project.bit.project.domain.PositionDTO;
import com.project.bit.project.domain.ProjectDTO;
import com.project.bit.project.domain.ProjectStatusDTO;
import com.project.bit.project.domain.ProjectTypeDTO;
import com.project.bit.project.domain.TeamDTO;
import com.project.bit.project.service.ProjectDetailService;
import com.project.bit.project.service.ProjectMemberService;
import com.project.bit.project.service.ProjectService;

@Controller
public class ProjectDetailController {
	
	@Autowired	private ProjectService projectService;
	@Autowired	private ProjectDetailService projectDetailService;
	@Autowired	private ProjectMemberService projectMemberService;
	@Autowired	private TeamsService teamsService;
	@Autowired	private PositionsService positionsService;
	@Autowired	private UserService userService;
	
	// 프로젝트 상세 차트
	@RequestMapping("/project/{projectId}")
	public String getProjectDetailChart(@PathVariable String projectId, Model model) {
		model.addAttribute("project", projectDetailService.getProjectInfo(projectId));
		return "/project/projectDetailChart";
	}
	
	// 프로젝트 상세 정보
	@GetMapping("/project/detail/{projectId}")
	public String getProjectDetail(@PathVariable String projectId, Model model) {
		model.addAttribute("project", projectDetailService.getProjectOne(projectId));
		return "/project/projectDetail";
	}
	
	// 프로젝트 등록 페이지로 이동
	@GetMapping("/goProjectAdd")
	public String goProjectAdd(@ModelAttribute ProjectDTO projectDTO) {
		return "/project/projectInsert";
	}
	
	// 프로젝트 삭제
	@GetMapping("/projectDelete/{projectCode}")
	public String removeProject(@PathVariable String projectCode) {
		projectService.removeProject(projectCode);
		return "redirect:/projectList";
	}
	
	// 프로젝트 멤버 페이지로 이동
	@GetMapping("/projectMember/{projectId}")
	public String getProjectMember(@PathVariable String projectId, Model model) {
		model.addAttribute("project", projectDetailService.getProjectOne(projectId));
		model.addAttribute("projectMembers", projectMemberService.getProjectMember(projectId));
		return "/project/projectMember";
	}
	
	
	
	
	
	// 프로젝트 상태 리스트
	@ModelAttribute("projectStatus")
	public List<ProjectStatusDTO> getProjectStatus(){
		return projectService.getProjectStatusListAll();
	}
	
	// 프로젝트 형태 리스트
	@ModelAttribute("projectTypeList")
	public List<ProjectTypeDTO> getProjectType(){
		return projectService.getProjectTypeAll();
	}
	
	// 부서 리스트
	@ModelAttribute("teamList")
	public List<TeamDTO> getTeam(){
		return teamsService.getTeamAll(); 
	}
	
	// 직급 리스트
	@ModelAttribute("positionList")
	public List<PositionDTO> getPosition(){
		return positionsService.getPositionAll();
	}
	
	// 유저 리스트
	@ModelAttribute("userList")
	public List<Users> getUser(){
		return userService.selectAll();
	}
	
	


}
