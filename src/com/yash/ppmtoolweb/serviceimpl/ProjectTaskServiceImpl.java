package com.yash.ppmtoolweb.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yash.ppmtoolweb.dao.ProjectTaskDao;
import com.yash.ppmtoolweb.daoimpl.ProjectTaskDaoImpl;
import com.yash.ppmtoolweb.domain.Backlog;
import com.yash.ppmtoolweb.domain.ProjectTask;
import com.yash.ppmtoolweb.service.BacklogService;
import com.yash.ppmtoolweb.service.ProjectTaskService;

@Service
public class ProjectTaskServiceImpl implements ProjectTaskService {
	
	
	
	
	public ProjectTaskServiceImpl() {
		System.out.println("in constr of "+getClass().getName());
	}
	
	@Override
	public void createProjectTask(ProjectTask projectTask) {
		
		
		projectTask.setCreated_at(new Date());
		projectTask.setUpdated_at(new Date());
		
		Backlog backlog = backlogService.findBacklog(projectTask.getProject_identifier().getProject_identifier());

		projectTask.setBacklog_id(backlog);
		projectTask.setProject_identifier(backlog.getProject_identifier());
		projectTask.setProject_sequence(backlog.gettSequence().toUpperCase());
		
		projectTaskDao.save(projectTask);

	}

	@Override
	public List<ProjectTask> listAllProjectTask(String project_identifier) {
		return projectTaskDao.listProjectTask(project_identifier);
		
	}
	@Override
	public void updateProjectTask(ProjectTask projectTask) {
		 
		ProjectTask projectTasks = projectTaskDao.find(projectTask.getId());
		
		if(projectTasks == null)
		{
			System.out.println("project task not found");
		}
		else
		{
			projectTask.setUpdated_at(new Date());
			
			if(projectTask.getDue_date()==null)
			{
				projectTask.setDue_date(projectTasks.getDue_date());
			}
			
			System.out.println("Project to be updated "+projectTask);
			
			projectTaskDao.updateProjectTask(projectTask);
		}
	}
	
	@Override
	public void deleteProjectTask(int id) {
		
		projectTaskDao.delete(id);
		
	}

}
