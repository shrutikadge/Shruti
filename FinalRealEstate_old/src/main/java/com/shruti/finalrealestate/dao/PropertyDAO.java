package com.shruti.finalrealestate.dao;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.multipart.MultipartFile;

import com.shruti.finalrealestate.exception.AdException;
import com.shruti.finalrealestate.pojo.Agent;
import com.shruti.finalrealestate.pojo.Customer;
import com.shruti.finalrealestate.pojo.Person;
import com.shruti.finalrealestate.pojo.Property;
import com.shruti.finalrealestate.pojo.Renter;

public class PropertyDAO extends DAO{

	
	public Property create(String location, String propTypes, String agent,
			double price)
            throws AdException {
        try {
            begin();
            
            Property property = new Property(location,propTypes,agent,price);
            
           
            getSession().save(property);
            commit();
            return property;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }
	
	public Property create(String location, String propTypes, Agent agent,
			double price)
            throws AdException {
        try {
            begin();
            
            Property property = new Property(location,propTypes,agent,price);
            
           
            getSession().save(property);
            commit();
            return property;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }
	
	
	public boolean addProperty(Property property) throws AdException{
		try{
			begin();
			
			getSession().save(property);
			commit();
			return true;
		}catch(HibernateException e){
			rollback();
			throw new AdException("Exception while adding");
		}
	}
	
	public List<Property> getEntityList() throws AdException {  
		try{ 
		begin();
		  Session session=DAO.getSession();
		  List<Property> propertyList = session.createCriteria(Property.class).list();  
		  
		  session.close();  
		  return propertyList;  
		}catch(HibernateException e){
			rollback();
            throw new AdException("Could not get user ");
		}
		 }  
	public List<Property> getEntityListByRestrictions(String location,String property) throws AdException {  
		try{ 
		begin();
		  Session session=DAO.getSession();
		  Criteria crit = session.createCriteria(Property.class);
		  Criterion loc=Restrictions.ilike("location", "%"+location+"%");
		  Criterion propertyType=Restrictions.ilike("propTypes", "%"+property+"%");
		  LogicalExpression orExp=Restrictions.or(loc,propertyType);
		  crit.add(orExp);
		  List<Property> res=crit.list();
		  session.close();  
		  return res;  
		  }catch(HibernateException e){
			rollback();
            throw new AdException("Could not get user ");
		}
		 }  
	public List<Property> getEntityListByPrice(double price) throws AdException {  
		try{ 
		begin();
		  Session session=DAO.getSession();
		  Criteria crit = session.createCriteria(Property.class);
		  crit.add(Restrictions.lt("price", price));
		  List<Property> res=crit.list();
		  session.close();  
		  return res;  
		  }catch(HibernateException e){
			rollback();
            throw new AdException("Could not get user ");
		}
		 }  
		   
	
	public List<Property> getEntityListByloc(String location) throws AdException {  
		try{ 
		begin();
		  Session session=DAO.getSession();
		  Criteria crit = session.createCriteria(Property.class);
		  crit.add(Restrictions.ilike("location", location));
		  List<Property> res=crit.list();
		  session.close();  
		  return res;  
		  }catch(HibernateException e){
			rollback();
            throw new AdException("Could not get user ");
		}
		 }  
   /* public Collection<Property> getProperties(){
    	
    	begin();
    	
    }*/
	
	public void delete(Property property)
            throws AdException {
        try {
            begin();
            getSession().delete(property);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " + property.getLocation()+","+property.getPropTypes(), e);
        }
    }
	
	 public Property get(String location)
	            throws AdException {
	     
	    	try{
	    		
	    		Criteria crit = getSession().createCriteria(Property.class);
	    		crit.add(Restrictions.ilike("location", "%"+location+"%"));

	    		crit.setMaxResults(1);
	    		Property p=(Property)crit.uniqueResult();
	    		return p;
	    	}
	    	catch(HibernateException e){
	    		rollback();
	    		throw new AdException("Could not get property");
	    	}
	    	
	    }
}
