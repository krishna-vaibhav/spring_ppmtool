package com.yash.ppmtoolweb.daoimpl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.ppmtoolweb.dao.ProjectDAO;
import com.yash.ppmtoolweb.domain.Project;
@Repository
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
		
		String hql = "select p from Project p";
		return sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		
	}

	@Override
	public Project find(String project_identifier) {
		String jpql = "select p from Project p where p.project_identifier = :pid";
		return sessionFactory.getCurrentSession().createQuery(jpql, Project.class)
				.setParameter("pid", project_identifier).getSingleResult();
	}

	

}
