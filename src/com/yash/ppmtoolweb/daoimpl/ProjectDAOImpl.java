package com.yash.ppmtoolweb.daoimpl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.ppmtoolweb.dao.ProjectDAO;
import com.yash.ppmtoolweb.domain.Project;

@Repository
public class ProjectDAOImpl  implements ProjectDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public ProjectDAOImpl() {
		System.out.println("in constr of "+getClass().getName());
		
	}

	@Override
	public void save(Project project) {
		/*System.out.println(project);*/
		sessionFactory.getCurrentSession().save(project);
		
		/*Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;
		
		try {
			
			tx = session.beginTransaction();
			session.saveOrUpdate(project);
			tx.commit();
			
		} 
		catch (HibernateException e) {
			
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
			
		}
		finally {
			
			session.close();
		}*/
		
	}

	@Override
	public void update(Project project) {
		System.out.println("inside update dao method "+project);
		sessionFactory.getCurrentSession().merge(project);
		/*Session hs = sessionFactory.getCurrentSession();
		Transaction tx = hs.beginTransaction();
		hs.saveOrUpdate(project);
		tx.commit();*/
	}

	@Override
	public void delete(Project project) {
		
		
		sessionFactory.getCurrentSession().delete(project);;
		/*Session hs = sessionFactory.getCurrentSession();
		Transaction tx = hs.beginTransaction();
		hs.delete("id", Project.class);
		tx.commit();*/
	}

	@Override
	public Project find(int id) {
		
		
		return sessionFactory.getCurrentSession().get(Project.class,id);
		
	}

	@Override
	public List<Project> findAll() {
		
		String hql = "select p from Project p";
		
		Session hs = sessionFactory.getCurrentSession();
		
		List<Project> list = hs.createQuery(hql,Project.class).getResultList();
		
		return list;
		/*return sessionFactory.getCurrentSession().createQuery(hql).getResultList();*/
		
	}

	/*@Override
	public Project find(String project_identifier) {
		String jpql = "select p from Project p where p.project_identifier = :pid";
		return sessionFactory.getCurrentSession().createQuery(jpql, Project.class)
				.setParameter("pid", project_identifier).getSingleResult();
	}*/

	

}
