package com.yash.ppmtoolweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yash.ppmtoolweb.domain.Project;
import com.yash.ppmtoolweb.exception.ProjectException;
import com.yash.ppmtoolweb.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	
	@Autowired
	private ProjectService projectService;
	
	public ProjectController() {
		System.out.println("in constr of "+getClass().getName());
	}
	
	@GetMapping("/dashboard")
	public String showDashboard(Model map)
	{
		System.out.println("Inside show dashboard method");
		try {
			map.addAttribute("prjservice", projectService.listProject());
			System.out.println("inside try catch showDashboard");
			
		} catch (ProjectException e) {
			e.printStackTrace();
		}
		return "/project/dashboard";
	}
	
	@GetMapping("/projectForm")
	public String showAddProjectForm(Project p)
	{
		System.out.println("inside show add project form ");
		return "/project/projectForm";
	}
	
	@PostMapping("/projectForm")
	public String processProjectForm(Project p)
	{
		System.out.println("in process project form "+p);

		try {
			projectService.createProject(p);
			
		} catch (ProjectException e) {
			
			e.printStackTrace();
		}
		
		return "redirect:/project/dashboard";
	}
	
	@GetMapping("/updateForm")
	public String showUpdateForm(Project project,Model map)
	{
		System.out.println("inside show update form....");
		map.addAttribute("project",projectService.getProject(project.getId()));
		return "/project/updateForm";
	}
	
	@PostMapping("/updateForm")
	public String processUpdateForm(Project project)
	{
		System.out.println("inside process update form "+project);
		try {
			projectService.updateProject(project);
		} catch (ProjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/project/dashboard";
	}
	
	
	@GetMapping("/deleteProject")
	public String deleteProject(@RequestParam int id)
	{
		System.out.println("inside delete project in projectcontroller...."+id);
		
		try {
			projectService.deleteProject(id);
		} catch (ProjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/project/dashboard";
	}
	
	@GetMapping("/projectBoard")
	public String showProjectBoard()
	{
		System.out.println("inside show project board ......");
		return "/project/projectBoard";
	}
	
}
