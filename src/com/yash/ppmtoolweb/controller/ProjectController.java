package com.yash.ppmtoolweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.yash.ppmtoolweb.service.ProjectService;

@Controller
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	
	public ProjectController() {
		System.out.println("in constr of "+getClass().getName());
	}
	
	@GetMapping("/dashboard")
	public String showDashboard()
	{
		System.out.println("Inside show dashboard method");
		return "/project/dashboard";
	}
	
}
