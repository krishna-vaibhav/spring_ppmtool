package com.yash.ppmtoolweb.daoimpl;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.yash.ppmtoolweb.dao.BacklogDao;
import com.yash.ppmtoolweb.domain.Backlog;

@Repository
public class BacklogDaoImpl implements BacklogDao {
	@Autowired
	private SessionFactory sessionFactory;	
	
	@Override
	public void save(Backlog backlog) {
		
		Session hs = sessionFactory.getCurrentSession();
		Transaction tx = hs.beginTransaction();
		hs.save(backlog);
		tx.commit();
		
	}

	@Override
	public Backlog find(String project_identifier) {
		
		String hql = "select b from Backlog b where b.project_identifier = :pid";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
	return	(Backlog) session.createQuery(hql, Backlog.class).setParameter("pid", project_identifier);
		
	}

	}

	
	

