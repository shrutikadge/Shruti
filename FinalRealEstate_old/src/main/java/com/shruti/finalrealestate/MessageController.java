package com.shruti.finalrealestate;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.shruti.finalrealestate.dao.MessageDAO;
import com.shruti.finalrealestate.dao.UserDAO;
import com.shruti.finalrealestate.exception.AdException;
import com.shruti.finalrealestate.pojo.MessageBean;
import com.shruti.finalrealestate.pojo.Person;

@Controller
public class MessageController {

	
	@RequestMapping(value="/addMessage.htm",method = RequestMethod.GET)
    protected String doSubmitAction(@ModelAttribute("message")MessageBean message, BindingResult result,RedirectAttributes redirectAttrs,HttpServletRequest request) throws Exception
    {
		String rec=request.getParameter("receiver");
	    String sen=request.getParameter("sender");
		Date date=new Date();
		MessageDAO messageDao=new MessageDAO();
		UserDAO userdao=new UserDAO();
		Person p=userdao.getByUser(rec);
		Person p1=userdao.getByUser(sen);
		MessageBean m=messageDao.create(p,p1, date, message.getMessage());
		
		Set hs1=p.getMessagesFromSender();
		hs1=new HashSet();
		hs1.add(m);
		
		m.setReceiver(p);
		m.getReceiver().setId(p.getId());
		
		Set hs2=p1.getMessagesToReceiver();
		hs2.add(m);
		m.setSender(p1);
		m.getSender().setId(p1.getId());
		
		//userdao.updatePerson(sen, hs1, null);
		//userdao.updatePerson(rec, null, hs2);
		
		System.out.println("hhhhhhhhj"+m.getMessage());
	//	redirectAttrs.addFlashAttribute("message", m);
		
		
	        return "customerview";
		
	
    }
	
	@RequestMapping(value="/viewMyMessages.htm",method=RequestMethod.GET)
	public ModelAndView getMessages(@ModelAttribute("message") MessageBean message,Model model,HttpServletRequest request)throws AdException {
        try {
          
		
		String req=request.getParameter("userName");
		UserDAO userdao=new UserDAO();
		Person p=userdao.getByUser(req);
		model.addAttribute("user", p);
		
		//MessageBean m=(MessageBean)model.asMap().get("message");
		
		MessageDAO messageDao = new MessageDAO();
		ModelAndView mv = new ModelAndView("viewMessage");
	    List messages;
		try {
			messages = messageDao.getMymsg(p.getId());
			for(int i=0;i<messages.size();i++){
				System.out.println(messages.get(i));
			}
			mv.addObject("messages", messages);
		} catch (AdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return mv;
        }
		catch (HibernateException e) {
                      //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
	}
	
	@RequestMapping(value="/viewMyMessagesInbox.htm",method=RequestMethod.GET)
	public ModelAndView getMessagesInbox(@ModelAttribute("message") MessageBean message,Model model,HttpServletRequest request) throws AdException 
	{
		try {
		String req=request.getParameter("userName");
		UserDAO userdao=new UserDAO();
		Person p=userdao.getByUser(req);
		model.addAttribute("user", p);
		
		//MessageBean m=(MessageBean)model.asMap().get("message");
		
		MessageDAO messageDao = new MessageDAO();
		ModelAndView mv = new ModelAndView("viewMessage");
	    List messages;
		try{
			messages = messageDao.getMymsgIn(p.getId());
			
			mv.addObject("messages", messages);
		} catch (AdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	catch (AdException e) {
		// TODO Auto-generated catch block
		 throw new AdException("Exception while creating user: " + e.getMessage());
	}
		
	}
}
