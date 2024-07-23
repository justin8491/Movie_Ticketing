package com.box.small.user.movie;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MovieController {

	@Autowired
	private MovieService service;
	
	@GetMapping(value = "/user/movie/movieList")
	public ModelAndView selectAllmovie() throws SQLException {
		
		ModelAndView mav = new ModelAndView();
		
		List<MovieDto>movielist = service.selectAllMovie();
		
		mav.addObject("movielist", movielist);
		
		mav.setViewName("/user/movie/movieList");
		
		return mav;
	}
	
	@GetMapping(value = "/user/movie/detailMovie")
	public ModelAndView selectMovie(@RequestParam("mo_no")int mo_no) throws SQLException {
		
		ModelAndView mav = new ModelAndView();
		
		MovieDto movie = service.selectMovie(mo_no);
		
		String cat_name = service.category(movie.getCat_no());
		
		mav.addObject("movie", movie);
		mav.addObject("cat_name", cat_name);
//		mav.setViewName("/user/movie/detailMovie");
		mav.setViewName("/user/movie/movieDetail");
		
		return mav;
	}
	
}
