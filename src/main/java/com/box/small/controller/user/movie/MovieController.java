package com.box.small.controller.user.movie;

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
public class MovieController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/user/movie/detailMovie", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		
		
		return "user/movie/detailMovie";
	
}
}
