package com.box.small.user.movie;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MovieController {

	@Autowired
	private MovieService service;
	
	@GetMapping(value = "/user/movie/movieList")
	public ModelAndView movieList() throws SQLException {
		
		ModelAndView mav = new ModelAndView();
		
		List<MovieDto>movielist = service.selectAllMovie();
		
		mav.addObject("movielist", movielist);
		
		mav.setViewName("/user/movie/movieList");
		
		return mav;
	}
	
	
}
