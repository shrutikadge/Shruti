package com.shruti.finalrealestate;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shruti.finalrealestate.dao.MessageDAO;
import com.shruti.finalrealestate.dao.PropertyDAO;
import com.shruti.finalrealestate.exception.AdException;
import com.shruti.finalrealestate.pojo.MessageBean;
import com.shruti.finalrealestate.pojo.Person;
import com.shruti.finalrealestate.pojo.Property;

@Controller
public class CustomerviewController 
{
	
	
	
	@RequestMapping(value="/browseProperty.htm",method=RequestMethod.GET)
	public String doSubmitAction(@ModelAttribute("property")Property property, BindingResult result) throws Exception
	{
	return "viewPropertyForm";
	}
	
	@RequestMapping(value="/browsePropertybyLoc.htm",method=RequestMethod.GET)
	public String doSubmitAction1(@ModelAttribute("property")Property property, BindingResult result) throws Exception
	{
	return "viewPropByLoc";
	}
	
	@RequestMapping(value="/browsePropertybyPrice.htm",method=RequestMethod.GET)
	public String doSubmitAction2(@ModelAttribute("property")Property property, BindingResult result) throws Exception
	{
	return "ViewByPrice";
	}
	
	@RequestMapping(value="/sendMessage.htm",method=RequestMethod.GET)
	public String doSubmitActio(@ModelAttribute("message")MessageBean message, BindingResult result) throws Exception
	{
	return "sendMessageTo";
	}
	
	
	
	

}