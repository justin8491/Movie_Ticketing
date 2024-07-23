package com.box.small.user.reservation;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.box.small.user.movie.MovieDto;
import com.box.small.user.movie.MovieService;
import com.box.small.user.theater.TheaterDto;
import com.box.small.user.theater.TheaterService;

@Controller
public class ReservationController {
	
	@Autowired
	private MovieService movieService;
	@Autowired
	private TheaterService theaterService;
	
	@GetMapping(value="reservation")
	public ModelAndView  reservateion() throws SQLException {
		List<MovieDto> movieServiceList =  movieService.selectAllMovie();
		List<TheaterDto> theaterList =  theaterService.sellectAlltheater();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("movieServiceList", movieServiceList);
		mav.addObject("theaterList", theaterList);
		mav.setViewName("user/reservation/reservation");
		return mav;
	}
	
	@GetMapping(value="reservation2")
	public ModelAndView  reservateion2() throws SQLException {
		List<MovieDto> movieServiceList =  movieService.selectAllMovie();
		List<TheaterDto> theaterList =  theaterService.sellectAlltheater();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("movieServiceList", movieServiceList);
		mav.addObject("theaterList", theaterList);
		mav.setViewName("user/reservation/reservation2");
		return mav;
	}	
	
}
