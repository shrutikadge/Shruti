package com.shruti.finalrealestate;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shruti.finalrealestate.dao.PropertyDAO;
import com.shruti.finalrealestate.pojo.Person;
import com.shruti.finalrealestate.pojo.Property;

@Controller
public class AgentviewController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(AgentviewController.class);
/*
	public String setModelAttribute(ModelMap model){
model.addAttribute("property", new Property() );
		
		return "agentview";
	}*/
/*    @ModelAttribute
	@RequestMapping(value = "/propertyForm.htm",method=RequestMethod.GET)
	public String home(ModelMap model) {
		System.out.println("hi");
		model.addAttribute("property", new Property() );
		
		return "forward:/addProperty.htm";
	}*/
	
	@RequestMapping(value="/addProperty.htm",method=RequestMethod.GET)
	public String doSubmitAction(@ModelAttribute("property")Property property, BindingResult result) throws Exception
	{
		
	//	map.addAttribute("property", new Property() );
		
	//	MultipartFile file = property.getImage();
	/*	try {
			file.transferTo(new File(request.getRealPath("/")+"/documentsfile/"+file.getOriginalFilename()));
			//property.setLinkStr("/documentsfile/"+file.getOriginalFilename());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//PropertyDAO propertyDao=new PropertyDAO();
		//Property p=propertyDao.create(property.getLocation(), property.getPropTypes(), property.getAgent(), property.getCustomer(), property.getRenter(), property.getPrice(), property.getImage());
	    return "addProperty";
	}
	
	@RequestMapping(value="/logout.htm", method=RequestMethod.GET)
	public String logout(@ModelAttribute("agent") Person agent,HttpSession session)
	{
		//session.removeAttribute("person");
		
			return "redirect:/welcome.htm";
	}
	
	
	
	
}
