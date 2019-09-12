package com.yash.ppmtoolweb.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.yash.ppmtoolweb.dao.BacklogDao;
import com.yash.ppmtoolweb.domain.Backlog;

@Repository
public class BacklogDaoImpl implements BacklogDao {
	@Autowired
	private SessionFactory sessionFactory;	
	
	@Override
	public void save(Backlog backlog) {

		sessionFactory.getCurrentSession().save(backlog);
	
	}

	@Override
	public Backlog find(String project_identifier) {
		
		String hql = "select b from Backlog b where b.project_identifier = :pid";
		
	return (Backlog) sessionFactory.getCurrentSession().createQuery(hql, Backlog.class).setParameter("pid", project_identifier);
		
	}

	}

	
	

