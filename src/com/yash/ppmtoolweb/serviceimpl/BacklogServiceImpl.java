package com.yash.ppmtoolweb.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ppmtoolweb.dao.BacklogDao;
import com.yash.ppmtoolweb.dao.ProjectDAO;
import com.yash.ppmtoolweb.daoimpl.BacklogDaoImpl;
import com.yash.ppmtoolweb.daoimpl.ProjectDAOImpl;
import com.yash.ppmtoolweb.domain.Backlog;
import com.yash.ppmtoolweb.domain.Project;
import com.yash.ppmtoolweb.service.BacklogService;
@Service
public class BacklogServiceImpl implements BacklogService {
	@Autowired
	private BacklogDao backlogDao;
	@Override
	public void createBacklog(Project project) {
		
		
		ProjectDAO projectDAO = new ProjectDAOImpl();
		Backlog backlog = new Backlog();
		
		
	    backlog.setProject_identifier(project.getProject_identifier());
	    backlog.settSequence(project.getProject_identifier()+"B0");
	    
		
		
		backlogDao.save(backlog);

	}

	@Override
	public Backlog findBacklog(String project_identifier) {
		
		return backlogDao.find(project_identifier);
		
	}
	
	

}
