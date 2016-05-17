package com.shruti.finalrealestate.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.shruti.finalrealestate.exception.AdException;
import com.shruti.finalrealestate.pojo.Agent;
import com.shruti.finalrealestate.pojo.Customer;
import com.shruti.finalrealestate.pojo.Person;
import com.shruti.finalrealestate.pojo.Property;
import com.shruti.finalrealestate.pojo.Renter;




public class UserDAO extends DAO {

    public UserDAO() {
    }
    
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
    /*
    public Person get(String userName,String password)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from  where userName = :userName and password= :password");
            q.setString("userName", userName);
            q.setString("password", password);
            Person user = (Person) q.uniqueResult();
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + userName, e);
        }
    }*/

    public Boolean getP(String userName,String password)
     {
     
    	
    		
    		Criteria crit = getSession().createCriteria(Person.class);
    		 Criterion loc=Restrictions.eq("userName", userName);
   		  Criterion propertyType=Restrictions.eq("password", password);
   		  LogicalExpression orExp=Restrictions.and(loc,propertyType);
   		  crit.add(orExp);
   		  //List<Property> res=crit.list();
    		//crit.setMaxResults(1);
    		//Person p=(Person)crit.uniqueResult();
    		List<Person> l=crit.list();
    		if(l.equals(null)){
    			
    			return false;
    		}
    		else return true;
    	
    	
    	
    }
    public Person get(String userName,String password)throws AdException
    {

        try{
        	begin();
   		
   		Criteria crit = getSession().createCriteria(Person.class);
   		crit.add(Restrictions.eq("userName", userName));
   		crit.add(Restrictions.eq("password", password));
   		crit.setMaxResults(1);
   		Person p=(Person)crit.uniqueResult();
   		return p;  }catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
   	
   	
   	
   }
    public void updatePerson(String userName, String name,String lastname,String ph,String ssn,String age )throws AdException
    {

        try{
        	begin();
             
          
           Person employee = 
                      (Person)this.getByUser(userName); 
           employee.setName(name);
           employee.setLastName(lastname);
           employee.setPhoneNumber(ph);
           employee.setSSN(ssn);
           employee.setAge(age);
  		 getSession().update(employee); 
           commit();
        }catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
     }
    
 public void updatePerson(String userName, Set sender,Set receiver )throws AdException
 {

     try{
     	begin();
          
           Person employee = 
                      (Person)this.getByUser(userName); 
           employee.setMessagesFromSender(sender);;
           employee.setMessagesToReceiver(receiver);;
           
  		 getSession().update(employee); 
           commit();
        }catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
     }
    
    public Person getByUser(String userName) throws AdException
    {

        try{
        	begin();
   	
   		
   		Criteria crit = getSession().createCriteria(Person.class);
   		crit.add(Restrictions.eq("userName", userName));
   		
   		crit.setMaxResults(1);
   		Person p=(Person)crit.uniqueResult();
   			return p;
        }catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
   	
   	
   	
   }
    
    public List<Person> getByUserType(String type)throws AdException {
        try {
            begin();
    
   	
   		
   		Criteria crit = getSession().createCriteria(Person.class);
   		crit.add(Restrictions.eq("personTypes", type));
   		
   		List<Person> res=crit.list();
   		return res;
        }
   		catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
   	
   	
   	
   }

    public Person create(String emailId, String userName,String password, String personType)
            throws AdException {
        try {
            begin();
            
            Person user = new Person(emailId, userName,password,personType);
          
            getSession().save(user);
            
            commit();
            return user;
           // }
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }

    public void delete(Person user)
            throws AdException {
        try {
            begin();
            getSession().delete(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " + user.getName(), e);
        }
    }
}