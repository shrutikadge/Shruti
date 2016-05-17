package com.shruti.finalrealestate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shruti.finalrealestate.dao.AgentDAO;
import com.shruti.finalrealestate.dao.CustomerDAO;
import com.shruti.finalrealestate.dao.RenterDAO;
import com.shruti.finalrealestate.dao.UserDAO;
import com.shruti.finalrealestate.exception.AdException;
import com.shruti.finalrealestate.pojo.Agent;
import com.shruti.finalrealestate.pojo.Person;




@Controller
@RequestMapping("/adduser.htm")
public class AddUserFormController{

	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(validator);
	} 
	
	
    @RequestMapping(method = RequestMethod.POST)
    protected String doSubmitAction(@ModelAttribute("user")Person user, BindingResult result) throws Exception
    {
    	validator.validate(user, result);
    	if(result.hasErrors()){
    		return "addUserForm"; 
    	}
        try
        {
        	/*if(user.getUserName().equals(("").trim())){
        		result.addError(new FieldError("user","userName","Username is incorrect"));
        		return "addUserForm";
        	}
        	else
        	if(user.getUserName().equals(("").trim())){
        		
        		result.addError(new FieldError("user","password","Password is incorrect"));
        		return "addUserForm";
        	}
        	else
            if(user.getPersonTypes().equals("")){
        		
        		result.addError(new FieldError("user","personTypes","Type is incorrect"));
        		return "addUserForm";
        	}
          */
        	
           // else{
        	String s=user.getPersonTypes();
        	if(s.equalsIgnoreCase("agent")){
        		AgentDAO agentdao=new AgentDAO();
        		agentdao.create(user.getEmailId(),user.getUserName() ,user.getPassword(), user.getPersonTypes());
        		return "home";
        	}
        	else if(s.equalsIgnoreCase("customer")){
        		CustomerDAO agentdao=new CustomerDAO();
        		agentdao.create(user.getEmailId(),user.getUserName() ,user.getPassword(), user.getPersonTypes());
        		return "home";
        	}
        	else if(s.equalsIgnoreCase("renter")){
        		RenterDAO agentdao=new RenterDAO();
        		agentdao.create(user.getEmailId(),user.getUserName() ,user.getPassword(), user.getPersonTypes());
        		return "home";
        	}
          //  }
       
        	
            //DAO.close();
        }
        catch (AdException e)
        {
            System.out.println("Exception: " + e.getMessage());
        }
        
        return "home";
        
    }
    
    @RequestMapping(method = RequestMethod.GET) 
    public String initializeForm(@ModelAttribute("user")Person user, BindingResult result) { 
   
        return "addUserForm"; 
    } 
    
   
}