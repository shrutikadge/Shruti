package com.mikadosolutions.training.springmvc.dao;

import javax.annotation.Resource;
//import javax.sql.DataSource;
import org.hibernate.SessionFactory;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.HibernateException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class  BaseDAO
{
	//protected JdbcTemplate jdbcTemplate;
	
	protected SessionFactory sessionFactory;
	/*@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}*/

	@Resource(name="hibernate4SessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
}
