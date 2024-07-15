package com.box.small.admin.schedule;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.box.small.HomeController;

@Controller
public class AdminScheduleController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/admin/theater/addTheater", method = RequestMethod.GET)
	public String addTheater(Locale locale, Model model) {

		return "admin/theater/adminTheater";

	}
	
	@RequestMapping(value = "/admin/theater/deleteTheater", method = RequestMethod.GET)
	public String deleteTheater(Locale locale, Model model) {
		
		return "admin/theater/adminTheater";
		
	}
	
	@RequestMapping(value = "/user/movie/updateTheater", method = RequestMethod.GET)
	public String updateTheater(Locale locale, Model model) {
		
		return "admin/theater/adminTheater";
		
	}
}
