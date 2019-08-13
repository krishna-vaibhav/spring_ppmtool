package com.yash.ppmtoolweb.daoimpl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ppmtoolweb.dao.ProjectDAO;
import com.yash.ppmtoolweb.domain.Project;
@Service 
public class ProjectDAOImpl  implements ProjectDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	public ProjectDAOImpl() {
		System.out.println("in constr of "+getClass().getName());
	}

	@Override
	public void save(Project project) {
		
		Session hs = sessionFactory.getCurrentSession();
		Transaction tx = hs.beginTransaction();
		hs.save(project);
		tx.commit();
		
	}

	@Override
	public void update(Project project) {
		
		Session hs = sessionFactory.getCurrentSession();
		Transaction tx = hs.beginTransaction();
		hs.saveOrUpdate(project);
		tx.commit();
	}

	@Override
	public void delete(Long id) {
		
		Session hs = sessionFactory.getCurrentSession();
		Transaction tx = hs.beginTransaction();
		hs.delete("id", Project.class);
		tx.commit();
	}

	@Override
	public Project find(Long id) {
		
		Session hs = sessionFactory.getCurrentSession();
		Transaction tx = hs.beginTransaction();
		Project project = (Project) hs.get("id",Project.class);
		tx.commit();
		return project;
		
	}

	@Override
	public List<Project> findAll() {
		
		Session hs = sessionFactory.getCurrentSession();
		String hql = "from Project";
		List<Project> project = new ArrayList<>();
		Transaction tx = hs.beginTransaction();
		project = hs.createQuery(hql).list();
		tx.commit();
		return project;
		
	}

	

}
