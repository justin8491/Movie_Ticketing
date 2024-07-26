package com.box.small.admin.theater;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.box.small.HomeController;
import com.box.small.user.theater.TheaterDto;
import com.box.small.user.theater.TheaterService;

@Controller
public class AdminTheaterController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private AdminTheaterService service;
	
	@Autowired
	private TheaterService mService;

	@GetMapping(value = "/admin/theater/adminTheater")
	public ModelAndView adminTheater() throws SQLException {
		
		ModelAndView mav = new ModelAndView();
		
		List<TheaterDto>theater = mService.sellectAlltheater();
		mav.addObject("theater", theater);
		mav.setViewName("/admin/theater/adminTheater");
		
		return mav;
	}
	
	@GetMapping(value = "/admin/theater/addTheater")
	public ModelAndView addTheaterPage() throws SQLException{
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/admin/theater/addTheater");
		return mav;
	}
	
	@PostMapping(value = "/admin/theater/addTheater")
	public ModelAndView addTheater(@ModelAttribute("theater")TheaterDto theater) throws SQLException{
		System.out.println("극장이름 : "+theater.getTh_name());
		System.out.println("극장상태 : "+theater.getTh_status());
		System.out.println("극장위치 : "+theater.getTh_location());
		ModelAndView mav = new ModelAndView();
		
		service.addTheater(theater);
		
		mav.setViewName("redirect:/admin/theater/adminTheater");
		return mav;
	}
	
	@PostMapping(value = "/admin/theater/deleteTheater")
	public ModelAndView deleteTheater(@RequestParam("th_no")int th_no) throws SQLException{
		
		ModelAndView mav = new ModelAndView();
		
		service.deleteTheater(th_no);
		
		mav.setViewName("redirect:/admin/theater/adminTheater");
		return mav;
	}
	
	@GetMapping(value = "/admin/theater/updateTheater")
	public ModelAndView updateTheaterPage(@RequestParam("th_no")int th_no) throws SQLException{
		
		
		ModelAndView mav = new ModelAndView();
		
		TheaterDto theater = mService.sellectTheater(th_no);
		
		mav.addObject("theater", theater);
		
		mav.setViewName("/admin/theater/updateTheater");
		return mav;
	}
	
	@PostMapping(value = "/admin/theater/updateTheater")
	public ModelAndView updateTheater(@ModelAttribute("theater")TheaterDto theater) throws SQLException{
		System.out.println("극장이름 : "+theater.getTh_name());
		System.out.println("극장상태 : "+theater.getTh_status());
		System.out.println("극장위치 : "+theater.getTh_location());
		
		ModelAndView mav = new ModelAndView();
		service.updateTheater(theater);
		
		mav.setViewName("redirect:/admin/theater/adminTheater");
		return mav;
	}
}
