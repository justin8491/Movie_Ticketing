package com.box.small.user.movie;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.box.small.HomeController;

@Controller
public class MovieController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping(value = "/user/movie/detailMovie")
	public String home(Locale locale, Model model) {

		
		
		return "user/movie/detailMovie";
	
}
}
