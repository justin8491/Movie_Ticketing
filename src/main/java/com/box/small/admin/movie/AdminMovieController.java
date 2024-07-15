package com.box.small.admin.movie;

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
public class AdminMovieController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/admin/movie/addMovie", method = RequestMethod.GET)
	public String addMovie(Locale locale, Model model) {

		return "admin/movie/adminMovie";

	}
	
	@RequestMapping(value = "/admin/movie/deleteMovie", method = RequestMethod.GET)
	public String deleteMovie(Locale locale, Model model) {

		return "admin/movie/adminMovie";

	}
	
	@RequestMapping(value = "/admin/movie/updateMovie", method = RequestMethod.GET)
	public String updateMovie(Locale locale, Model model) {

		return "admin/movie/updateMovie";

	}
	
	@RequestMapping(value = "/admin/movie/deleteReview", method = RequestMethod.GET)
	public String adminReview(Locale locale, Model model) {

		return "admin/movie/adminReview";

	}
}
