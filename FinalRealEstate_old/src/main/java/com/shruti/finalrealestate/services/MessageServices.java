package com.shruti.finalrealestate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.shruti.finalrealestate.dao.MessageDAO;
import com.shruti.finalrealestate.pojo.MessageBean;

public class MessageServices {
	@Autowired  
	 MessageDAO messageDao;  
	   
	 
	 public boolean addMessage(MessageBean message) throws Exception {  
	  return messageDao.addMessageBean(message);  
	 }  
 
	 public MessageBean getEntityByMessage(String message) throws Exception {  
	  return messageDao.get(message);  
	 }  
	 
	 public List<MessageBean> getEntityList() throws Exception {  
	  return messageDao.getEntityList();  
	 }  

	 public boolean deleteEntity(MessageBean message) throws Exception {  
	  messageDao.delete(message);
	  return true;
	 }  
}
