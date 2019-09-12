package com.yash.ppmtoolweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yash.ppmtoolweb.domain.ProjectTask;
import com.yash.ppmtoolweb.service.ProjectTaskService;

@Controller
@RequestMapping("/project")
public class ProjectTaskController {

	@Autowired
	private ProjectTaskService projectTask;
	
	public ProjectTaskController() {
		System.out.println("in constr of "+getClass().getName());
	}
	
	
	@GetMapping("/projectBoard")
	public String showProjectBoard(Model map,@RequestParam String project_identifier)
	{
		System.out.println("inside show project board ......");
		map.addAttribute("listTaskInProgress",projectTask.listAllProjectTask(project_identifier));
		return "/project/projectBoard";
	}
	
	
}
