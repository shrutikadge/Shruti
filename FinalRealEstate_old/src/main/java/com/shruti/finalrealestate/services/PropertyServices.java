package com.shruti.finalrealestate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.shruti.finalrealestate.dao.PropertyDAO;
import com.shruti.finalrealestate.pojo.Property;

public class PropertyServices {
	@Autowired  
	 PropertyDAO propertyDao;  
	   
	 
	 public boolean addProperty(Property property) throws Exception {  
	  return propertyDao.addProperty(property);  
	 }  
  
	 public Property getEntityByLocation(String location) throws Exception {  
	  return propertyDao.get(location);  
	 }  
	 
	 public List<Property> getEntityList() throws Exception {  
	  return propertyDao.getEntityList();  
	 }  

	 public boolean deleteEntity(Property property) throws Exception {  
	  propertyDao.delete(property);
	  return true;
	 }  
}
