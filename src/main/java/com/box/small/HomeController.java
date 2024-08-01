package com.box.small;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.box.small.user.movie.CategoryDto;
import com.box.small.user.movie.MovieDto;
import com.box.small.user.movie.MovieService;

/**
 * Handles requests for the application home page.
 */


@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@Autowired
	private MovieService service;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView selectAllmovie() throws SQLException {

		System.out.println("메인 페이지로 이동");
		ModelAndView mav = new ModelAndView();
		List<MovieDto>movieList = service.selectAllMovieLive();

		List<CategoryDto>category = service.allCategory();
		mav.addObject("movieList", movieList);
		mav.addObject("category",category);
		mav.setViewName("home_beta");
		return mav;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminhome() {
		return "homeAdmin_beta";
	}


}
