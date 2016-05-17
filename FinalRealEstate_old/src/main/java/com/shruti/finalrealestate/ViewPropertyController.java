package com.shruti.finalrealestate;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shruti.finalrealestate.dao.PropertyDAO;
import com.shruti.finalrealestate.exception.AdException;
import com.shruti.finalrealestate.pojo.Property;

@Controller
public class ViewPropertyController {

	
	@RequestMapping(value="/viewProperty.htm",method=RequestMethod.GET)
	public ModelAndView getProperties(@ModelAttribute Property property)
	{
		
		PropertyDAO dao=new PropertyDAO();
		ModelAndView mv = new ModelAndView("/viewProps");
	    List properties;
		try {
			properties = dao.getEntityList();
			mv.addObject("properties", properties);
		} catch (AdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return mv;
	}
	
	@RequestMapping(value="/viewPropertyByLoc.htm",method=RequestMethod.GET)
	public ModelAndView getPropertiesByLoc(@ModelAttribute Property property,BindingResult result)
	{
		
		PropertyDAO dao=new PropertyDAO();
		ModelAndView mv = new ModelAndView("/allProps");
	    List properties;
		try {
			if(property.getLocation().equals(("").trim())){
				result.addError(new FieldError("property","location","Location is incorrect"));
			}
			if(property.getLocation().equals(("").trim())){
				result.addError(new FieldError("property","propTypes","Type is incorrect"));
			}
			properties = dao.getEntityListByRestrictions(property.getLocation(), property.getPropTypes());
			mv.addObject("properties", properties);
		} catch (AdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return mv;
	}
	
	@RequestMapping(value="/viewPropertyByPrice.htm",method=RequestMethod.GET)
	public ModelAndView getPropertiesbyPrice(@ModelAttribute Property property)
	{
		
		PropertyDAO dao=new PropertyDAO();
		ModelAndView mv = new ModelAndView("/props");
	    List properties;
		try {
			properties = dao.getEntityListByPrice(property.getPrice());
			mv.addObject("properties", properties);
		} catch (AdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return mv;
	}
}
