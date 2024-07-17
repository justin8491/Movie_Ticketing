package com.box.small.user.theater;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.box.small.user.movie.MovieDto;
import com.box.small.user.movie.MovieService;

@Controller
public class TheaterController {
	@Autowired
	private TheaterService service;
	
	@GetMapping(value = "/user/theater/theaterList")
	public ModelAndView selectAllmovie() throws SQLException {
		
		ModelAndView mav = new ModelAndView();
		
		List<TheaterDto>theaterlist = service.sellectAlltheater();
		
		mav.addObject("theaterlist", theaterlist);
		
		mav.setViewName("/user/theater/theaterList");
		
		return mav;
	}
	
	@GetMapping(value = "/user/theater/theater")
	public ModelAndView selectMovie(@RequestParam("th_no")int th_no) throws SQLException {
		
		ModelAndView mav = new ModelAndView();
		
		TheaterDto theater = service.sellectTheater(th_no);
		
		mav.addObject("theater", theater);
		mav.setViewName("/user/theater/theater");
		
		return mav;
	}
}
