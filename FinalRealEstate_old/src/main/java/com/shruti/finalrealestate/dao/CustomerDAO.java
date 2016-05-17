package com.shruti.finalrealestate.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.shruti.finalrealestate.exception.AdException;
import com.shruti.finalrealestate.pojo.Agent;
import com.shruti.finalrealestate.pojo.Customer;
import com.shruti.finalrealestate.pojo.Person;

public class CustomerDAO extends UserDAO{
	public Person getPerson(Integer id) throws AdException{
    	try{
    	begin();
    	Session session = DAO.getSession();
    	Person p=(Person)session.get(Person.class, id);
    	return p;
    	}
    	catch(HibernateException e){
    		rollback();
            throw new AdException("Could not get user ");
    	}
    }

    public Person get(String userName,String password)
            {
     

    		
    		Criteria crit = getSession().createCriteria(Person.class);
    		crit.add(Restrictions.eq("userName", userName));
    		crit.add(Restrictions.eq("password", password));
    		crit.setMaxResults(1);
    		Customer p=(Customer)crit.uniqueResult();
    		return p;
    	}
    	
    

    public Person create(String emailId, String userName,String password, String personType)
            throws AdException {
        try {
            begin();
            
            Person user = new Customer(emailId, userName,password, personType);
           
          
            getSession().save(user);
            
            commit();
            return user;
            }
         catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }

    public void delete(Customer agent)
            throws AdException {
        try {
            begin();
            getSession().delete(agent);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " + agent.getName(), e);
        }
    }

}
