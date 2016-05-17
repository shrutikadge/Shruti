package com.shruti.finalrealestate;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shruti.finalrealestate.dao.AgentDAO;
import com.shruti.finalrealestate.dao.PropertyDAO;
import com.shruti.finalrealestate.exception.AdException;
import com.shruti.finalrealestate.pojo.Agent;
import com.shruti.finalrealestate.pojo.Person;
import com.shruti.finalrealestate.pojo.Property;

@Controller
public class AddPropertyController {

	
	@Autowired
	@Qualifier("propertyValidator")
	PropertyValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(validator);
	} 
	
	@RequestMapping(value="/addedProperty.htm",method=RequestMethod.GET)
	public String doSubmitAction(@ModelAttribute("property")Property property, BindingResult result,HttpServletRequest request) throws Exception
	{
		
		

    	/*validator.validate(property, result);
    	if(result.hasErrors()){
    		return "addProperty"; 
    	}*/
		String ag=request.getParameter("agent");
	
		
	
		PropertyDAO propertyDao=new PropertyDAO();
		AgentDAO a=new AgentDAO();
		Agent pp=(Agent)a.getByUser(ag);
		Property p=propertyDao.create(property.getLocation(), property.getPropTypes(),pp, property.getPrice());
	    
	    
	    p.setAgent((Agent)pp);
	    p.getAgent().setId(pp.getId());
	    Set hs=pp.getProps();
	    hs=new HashSet();
	    hs.add(p);
	    a.updateAgent(ag, hs);
		return "agentview";
	}
	
	
	
}
