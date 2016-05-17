package com.mikadosolutions.training.springmvc.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.mikadosolutions.training.springmvc.bean.User;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.ObjectError;
import org.springframework.validation.FieldError;



//import com.mikadosolutions.training.springmvc.bean.Room;
//import com.mikadosolutions.training.springmvc.dao.RoomMasterDAO;


@Controller
@RequestMapping("/")
public class HomeController {

	//@Autowired
	//RoomMasterDAO dao;
	
	//@RequestMapping(value="/", method = RequestMethod.GET)
	/*public ModelAndView home() {
		System.out.println("Inside");
		ModelAndView mv = new ModelAndView("/welcome");
		//return "welcome";
		return mv;
	}*/
	//@RequestMapping(value="/", method = RequestMethod.GET)
	@RequestMapping("/")
	public String welcome() {
		System.out.println("Inside");
		//ModelAndView mv = new ModelAndView("/welcome");
		return "welcome";
		//return mv;
	}
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView loginInput() {
		System.out.println("Inside");
		ModelAndView mv = new ModelAndView("/login");
		User user = new User();
		user.setUsername("someone@somewhere.com");
		mv.addObject("user",user);
		//ModelAndView mv = new ModelAndView("/welcome");
		//return "login";
		return mv;
	}
	@RequestMapping(value="/authUser", method = RequestMethod.POST)
	//@RequestMapping("/authUser")
	public String authenticate(@Valid User user, BindingResult result,HttpSession session,HttpServletRequest request) {
		//System.out.println("Inside authenticate()"+result + " User = "+user);
		//System.out.println(result.getModel());
		if (result.hasErrors()) {

			return "login";
		} 
		else if (user.getUsername().equals("sanjay.makhija@mikadosolutions.com") && user.getPassword().equals("mikado"))
		{
			session.setAttribute("user",user);
			return "userhome";
		}
		else 
		{
			if(!user.getUsername().equals("sanjay.makhija@mikadosolutions.com"))
				result.addError(new FieldError("user","username","Username is incorrect"));
				//request.setAttribute("username","Username is incorrect");

			if(!user.getPassword().equals("mikado"))
				result.addError(new FieldError("user","password","Password is incorrect"));
				//request.setAttribute("password","Password is incorrect");
				
			return "login";
		}
 

	}
	@RequestMapping(value="secure/home", method=RequestMethod.GET)
	public String home()
	{
		return "userhome";
	}
	@RequestMapping(value="/back", method=RequestMethod.GET)
	public String back(HttpSession session)
	{
		User user = (User)session.getAttribute("user");
		if(user == null)
			return "welcome";
		else
			return "userhome";
	}
	@RequestMapping(value="secure/logout", method=RequestMethod.GET)
	public String logout(HttpSession session)
	{
		session.removeAttribute("user");
		
			return "welcome";
	}
	//@RequestMapping(value="secure/fetchOccupiedRooms", method=RequestMethod.GET)
	/*public ModelAndView fetchOccupiedRooms()
	{
		ModelAndView mv = new ModelAndView("/rooms");
		Collection rooms = dao.getOccupiedRooms();
		mv.addObject("rooms", rooms);
		return mv;
	}*/
	
	//@RequestMapping(value="secure/allocateRoom", method=RequestMethod.GET)
	/*public String allocateRoom(Room room){
		System.out.println("Room = "+room+" roomNumber = "+room.getRoomNumber());
		dao.allocateRoom(room);
		//return fetchAvailableRooms();
		return "redirect:/passthru/roomAllocated";
	}*/
	
	//@RequestMapping(value="secure/deAllocateRoom", method=RequestMethod.GET)
	/*public String deAllocateRoom(Room room){
		System.out.println("Room = "+room+" roomNumber = "+room.getRoomNumber());
		dao.deallocateRoom(room);
		//return fetchAvailableRooms();
		return "redirect:secure/passthru/roomDeAllocated";
	}*/
	
	
	//@RequestMapping(value="**/passthru/{name}")
	/*public String redirect(@PathVariable("name")String redirectName){
		System.out.println("Passing thru to "+redirectName);
		return redirectName;
	}*/
	
}
