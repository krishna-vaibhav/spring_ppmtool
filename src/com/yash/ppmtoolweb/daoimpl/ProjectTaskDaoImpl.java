package com.yash.ppmtoolweb.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.ppmtoolweb.dao.ProjectTaskDao;
import com.yash.ppmtoolweb.domain.ProjectTask;
import com.yash.ppmtoolweb.util.DBUtil;
@Repository
public class ProjectTaskDaoImpl  implements ProjectTaskDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public void save(ProjectTask projectTask) {
		
	sf.getCurrentSession().merge(projectTask);

	}

	@Override
	public List<ProjectTask> listProjectTask(String project_identifier) {
	
		String jpql = "select pt from ProjectTask pt where pt.project_identifier = :pid";
		return sf.getCurrentSession().createQuery(jpql, ProjectTask.class).setParameter("pid", project_identifier)
				.getResultList();

	}

	@Override
	public void updateProjectTask(ProjectTask projectTask) {
	
		sf.getCurrentSession().saveOrUpdate(projectTask);
		
	}

	@Override
	public ProjectTask find(int id) {
		return (ProjectTask) sf.getCurrentSession().get("id",ProjectTask.class);
	}

	@Override
	public void delete(int id) {
		
		sf.getCurrentSession().delete("id",ProjectTask.class);
		
		
	}

}
