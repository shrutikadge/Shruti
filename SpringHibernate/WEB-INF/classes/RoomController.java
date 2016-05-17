package com.mikadosolutions.training.springmvc.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mikadosolutions.training.springmvc.bean.Room;
import com.mikadosolutions.training.springmvc.dao.RoomMasterDAO;


@Controller
@RequestMapping("/")
public class RoomController {

	@Autowired
	RoomMasterDAO dao;
	
	//@RequestMapping(value="/", method = RequestMethod.GET)
	/*public ModelAndView home() {
		System.out.println("Inside");
		ModelAndView mv = new ModelAndView("/welcome");
		//return "welcome";
		return mv;
	}*/
	//@RequestMapping(value="/", method = RequestMethod.GET)
	/*public String home() {
		System.out.println("Inside");
		//ModelAndView mv = new ModelAndView("/welcome");
		return "welcome";
		//return mv;
	}*/
	
	@RequestMapping(value="general/getAvailableRooms", method=RequestMethod.GET)
	public ModelAndView getAvailableRooms()
	{
		ModelAndView mv = new ModelAndView("/roomList");
		Collection rooms = dao.getAvailableRooms();
		mv.addObject("rooms", rooms);
		mv.addObject("status","A");
		return mv;
	}

	//@RequestMapping(value="secure/allocateRoom", method=RequestMethod.GET)
	/*public ModelAndView allocateRoom()
	{
		ModelAndView mv = new ModelAndView("/roomList");
		Collection rooms = dao.getAvailableRooms();
		mv.addObject("rooms", rooms);
		return mv;
	}*/
	
	@RequestMapping(value="secure/getOccupiedRooms", method=RequestMethod.GET)
	public ModelAndView getOccupiedRooms()
	{
		ModelAndView mv = new ModelAndView("/roomList");
		Collection rooms = dao.getOccupiedRooms();
		mv.addObject("rooms", rooms);
		mv.addObject("status","O");
		return mv;
	}
	
	@RequestMapping(value="secure/allocateRoom", method=RequestMethod.GET)
	public String allocateRoom(Room room){
		//System.out.println("Room = "+room+" roomNumber = "+room.getRoomNumber());
		dao.allocateRoom(room);
		//return fetchAvailableRooms();
		return "roomAllocated";
	}
	
	@RequestMapping(value="secure/deAllocateRoom", method=RequestMethod.GET)
	public String deAllocateRoom(Room room){
		//System.out.println("Room = "+room+" roomNumber = "+room.getRoomNumber());
		dao.deallocateRoom(room);
		//return fetchAvailableRooms();
		return "roomDeallocated";
	}
	
	
	//@RequestMapping(value="**/passthru/{name}")
	/*public String redirect(@PathVariable("name")String redirectName){
		System.out.println("Passing thru to "+redirectName);
		return redirectName;
	}*/
	
}
