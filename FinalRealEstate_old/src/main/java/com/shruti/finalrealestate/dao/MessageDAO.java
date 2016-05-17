package com.shruti.finalrealestate.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;



import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.multipart.MultipartFile;

import com.shruti.finalrealestate.exception.AdException;
import com.shruti.finalrealestate.pojo.Agent;
import com.shruti.finalrealestate.pojo.Customer;
import com.shruti.finalrealestate.pojo.MessageBean;
import com.shruti.finalrealestate.pojo.Person;
import com.shruti.finalrealestate.pojo.Property;
import com.shruti.finalrealestate.pojo.MessageBean;

import com.shruti.finalrealestate.pojo.Renter;

public class MessageDAO extends DAO{

	public MessageBean create(String receiver, Date date, String message)
            throws AdException {
        try {
            begin();
            
            MessageBean messageBean = new MessageBean(receiver,date,message);
            
            getSession().save(messageBean);
            commit();
            return messageBean;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }
	
	public MessageBean create(Person sender,Person receiver, Date date, String message)
            throws AdException {
        try {
            begin();
            
            MessageBean messageBean = new MessageBean(sender,receiver,date,message);
            
            getSession().save(messageBean);
            commit();
            return messageBean;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }
	
	public boolean addMessageBean(MessageBean messageBean) throws AdException{
		try{
			begin();
			getSession().save(messageBean);
			commit();
			return true;
		}catch(HibernateException e){
			rollback();
			throw new AdException("Exception while adding");
		}
	}
	
	public List<MessageBean> getEntityList() throws AdException {  
		try{ 
		begin();
		  Session session=DAO.getSession();
		  List<MessageBean> messageBeanList = session.createCriteria(MessageBean.class).list();  
		  
		  session.close();  
		  return messageBeanList;  
		}catch(HibernateException e){
			rollback();
            throw new AdException("Could not get user ");
		}
		 }  
		   
	public List<MessageBean> getMessagesbyMe(int id)throws AdException {  
		try{ 
		begin();
		  Session session=DAO.getSession();
		  Criteria crit = session.createCriteria(MessageBean.class);
		  
		  Criteria person=crit.createCriteria("sender");
		  person.add(Restrictions.eq("sender", id));
		  List<MessageBean> res=crit.list();
		  session.close();  
		  return res;  
		}catch(HibernateException e){
			rollback();
            throw new AdException("Could not get user ");
		}
		 }  
    public List<MessageBean> getMymsg(int id) throws AdException{
    	try{ 
    		begin();
    		  Session session=DAO.getSession();
    		/* String sql="select p.userName,m.date,m.message from MessageBean m "
    		 		+ "inner join Person p where p.id in (select m.receiver.id from messagebean m "
    		 		+ "where m.sender.id="+id+")";
    		 */
    		  String sql="from MessageBean m where m.receiver="+id;
    		 Query query=session.createQuery(sql);
    	
    		 List res=query.list();
    		 return res;
    		}catch(HibernateException e){
    			rollback();
                throw new AdException("Could not get user ");
    		}
    }
    public List<MessageBean> getMymsgIn(int id) throws AdException{
    	try{ 
    		begin();
    		  Session session=DAO.getSession();
    		/* String sql="select p.userName,m.date,m.message from MessageBean m "
    		 		+ "inner join Person p where p.id in (select m.receiver.id from messagebean m "
    		 		+ "where m.sender.id="+id+")";
    		 */
    		  String sql="from MessageBean m where m.sender="+id;
    		 Query query=session.createQuery(sql);
    	
    		 List res=query.list();
    		 return res;
    		}catch(HibernateException e){
    			rollback();
                throw new AdException("Could not get user ");
    		}
    }
    
	
	public void delete(MessageBean messageBean)
            throws AdException {
        try {
            begin();
            getSession().delete(messageBean);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " , e);
        }
    }
	
	 public MessageBean get(String message)
	            throws AdException {
	     
	    	try{
	    		
	    		Criteria crit = getSession().createCriteria(MessageBean.class);
	    		crit.add(Restrictions.ilike("message", "%"+message+"%"));

	    		crit.setMaxResults(1);
	    		MessageBean p=(MessageBean)crit.uniqueResult();
	    		return p;
	    	}
	    	catch(HibernateException e){
	    		rollback();
	    		throw new AdException("Could not get MessageBean");
	    	}
	    	
	    }

}
