package com.box.small.admin.movie;



import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.box.small.user.movie.MovieDto;

@Controller
public class AdminMovieController {

	@Autowired
	private AdminMovieService service;
	
	@PostMapping(value = "/admin/movie/addMovie")
	public ModelAndView addMovie(@ModelAttribute("movie")MovieDto movie) throws SQLException{
		
		ModelAndView mav = new ModelAndView();
		
		service.addMovie(movie);
		
		mav.setViewName("redirect:/admin/movie/adminMovie");
		return mav;
	}
	
	@PostMapping(value = "/admin/movie/deleteMovie")
	public ModelAndView deleteMovie(@RequestParam("mo_no")int mo_no) throws SQLException{
		
		ModelAndView mav = new ModelAndView();
		
		service.deleteMovie(mo_no);
		
		mav.setViewName("redirect:/admin/movie/adminMovie");
		return mav;
	}
	
	@PostMapping(value = "/admin/movie/update")
	public ModelAndView updateMovie(@ModelAttribute("movie")MovieDto movie) throws SQLException{
		
		ModelAndView mav = new ModelAndView();
		
		service.updateMovie(movie);
		mav.setViewName("redirect:/admin/movie/adminMovie");
		return mav;
	}
	

	
}
