package com.shruti.finalrealestate.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.shruti.finalrealestate.exception.AdException;
import com.shruti.finalrealestate.pojo.Agent;
import com.shruti.finalrealestate.pojo.Person;
import com.shruti.finalrealestate.pojo.Property;
import com.shruti.finalrealestate.pojo.Renter;

public class AgentDAO extends UserDAO{

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
	    		Agent p=(Agent)crit.uniqueResult();
	    		return p;
	    	}
	    
	    public void updateAgent(String userName, Set props ) throws AdException{
	        
	        try{
	        	begin();
	          
	           Agent employee = 
	                      (Agent)this.getByUser(userName); 
	           employee.setProps(props);
	  		 getSession().update(employee); 
	           commit();
	        }catch (HibernateException e) {
	           rollback();
	           e.printStackTrace(); 
	        }
	     }
	    
	    
	    
	    public Person get(String userName)
        {
 
	
		
		Criteria crit = getSession().createCriteria(Person.class);
		crit.add(Restrictions.eq("userName", userName));
		
		crit.setMaxResults(1);
		Agent p=(Agent)crit.uniqueResult();
		return p;
	}
	    	
	    public Person addProperty(Property p, String userName){
	    	Criteria crit=getSession().createCriteria(Agent.class);
	    	Agent a=(Agent)this.get(userName);
	    	Set h=a.getProps();
	    	h=new HashSet<Property>();
	    	h.add(p);
	    	return a;
	    }

	    public Person create(String emailId, String userName,String password, String personType)
	            throws AdException {
	        try {
	            begin();
	            
	            Person user = new Agent(emailId, userName,password, personType);
	           
	          
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

	    public void delete(Agent agent)
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
