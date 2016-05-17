package com.shruti.finalrealestate;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.jmx.Agent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shruti.finalrealestate.dao.AgentDAO;
import com.shruti.finalrealestate.dao.CustomerDAO;
import com.shruti.finalrealestate.dao.RenterDAO;
import com.shruti.finalrealestate.dao.UserDAO;
import com.shruti.finalrealestate.exception.AdException;
import com.shruti.finalrealestate.pojo.Person;
import com.shruti.finalrealestate.pojo.Property;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
  
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, ModelMap model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("user", new Person() );
		
		return "home";
	}
	@RequestMapping(value = "/welcome.htm", method = RequestMethod.GET)
	public String returnhome(Model model){
		
model.addAttribute("user", new Person() );
		
		return "home";
	}
	
	@RequestMapping(value="/loginuser.htm",method = RequestMethod.POST)
    protected String doSubmitAction(@ModelAttribute("user")Person user, BindingResult result,Model model) 
    {
  //  validator.validate(user, result);
   // 	if(result.hasErrors()){
    	//	return "home"; 
    	//}
    	if(user.getUserName().equals(("").trim())||user.getPassword().equals(("").trim())){
    		result.addError(new FieldError("user","userName","Username is incorrect"));
    		result.addError(new FieldError("user","password","Password is incorrect"));
    	}
    	else{
		try{
		boolean flag=false;
		boolean agent=false;
		boolean customer=false;
		boolean renter=false;
       // try
        //{
        	System.out.println(user.getUserName());
        	
            UserDAO userDao = new UserDAO();
            Person p =userDao.get(user.getUserName(),user.getPassword());
         //   Boolean pp=userDao.getP(user.getUserName(),user.getPassword());
            if(p.equals(null)){
            	//flag=false;
            	result.addError(new FieldError("user","userName","Username is incorrect"));
        		result.addError(new FieldError("user","password","Password is incorrect"));
            	return "home";
         // System.out.println("booya");
            }
            else {
            	
            	flag=true;
            	if(p.getPersonTypes().equalsIgnoreCase("agent")){
            		agent=true;
            		//model.addAttribute("agent", p);
            		Map mod=model.asMap();
            		mod.put("agent", p);
            		model.addAllAttributes(mod);
            		return "agentview";
            	}
            	else if(p.getPersonTypes().equalsIgnoreCase("customer")){
            		customer=true;
            		model.addAttribute("customer", p);
            		return "customerview";
            	}
            	else if(p.getPersonTypes().equalsIgnoreCase("renter")){
            		renter=true;
            		model.addAttribute("renter", p);
            		return "renterview";
            	}
            	//else return "home";
            	else return null;
            }
		}
		catch(Exception e){
			e.printStackTrace();
		}
    	}
    	return "home";}
     
     //   }
	//	return "home";
		
		
	@RequestMapping(value="/updateuserform.htm",method = RequestMethod.POST)
    protected String doSubmitAction(@ModelAttribute("user")Person user, BindingResult result) throws Exception
    {
		return "updatePerson";
    }
	
	@RequestMapping(value="/updateuser.htm",method = RequestMethod.POST)
    protected String doSubmitAction1(@ModelAttribute("user")Person user, BindingResult result) throws Exception
    {
		
		UserDAO userDao=new UserDAO();
		userDao.updatePerson(user.getUserName(), user.getName(),user.getLastName(), user.getPhoneNumber(), user.getSSN(), user.getAge());
		
		return "updatePerson";
    }
		
	@RequestMapping(value="/getAgents.htm",method = RequestMethod.GET)
    protected ModelAndView doSubmitAction2(@ModelAttribute("user")Person user, BindingResult result) throws Exception
    {
		
		UserDAO userDao=new UserDAO();
		List ppl=userDao.getByUserType("Agent");
		ModelAndView mv=new ModelAndView("allAgents");
		mv.addObject("agents",ppl);
		return mv;
    }
    
    
	@RequestMapping(value="/redirecttoA.htm")
	public ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response)throws Exception
	{
		RequestDispatcher rd = request.getRequestDispatcher("/propertyForm.htm");
		rd.forward(request, response);
		return null;
}
}
