package com.box.small.admin.movie;



import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.box.small.user.movie.CategoryDto;
import com.box.small.user.movie.MovieDto;
import com.box.small.user.movie.MovieService;

@Controller
public class AdminMovieController {

	@Autowired
	private AdminMovieService service;
	@Autowired
	private MovieService mService;
	
	@GetMapping(value = "/admin/movie/adminMovie")
	public ModelAndView adminMovie() throws SQLException {
		
		ModelAndView mav = new ModelAndView();
		
		List<MovieDto>movie = mService.selectAllMovie();
		List<CategoryDto>category = mService.allCategory();
		mav.addObject("category",category);
		mav.addObject("movie", movie);
		mav.setViewName("/admin/movie/adminMovie");
		
		return mav;
	}
	
	@GetMapping(value = "/admin/movie/addMovie")
	public ModelAndView addMoviePage() throws SQLException{
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/admin/movie/addMovie");
		return mav;
	}
	
	@PostMapping(value = "/admin/movie/addMovie")
	public ModelAndView addMovie(@ModelAttribute("movie")MovieDto movie) throws SQLException{
		
		ModelAndView mav = new ModelAndView();
		
		service.addMovie(movie);
		
		mav.setViewName("redirect:/admin/movie/adminMovie");
		return mav;
	}
	
//	아무리 생각해도 얘는 GetMapping이 필요없음. 삭제 누르면 그냥 삭제되게 만들어야함.
//	@GetMapping(value = "/admin/movie/deleteMovie")
//	public ModelAndView deleteMoviePage(@RequestParam("mo_no")int mo_no) throws SQLException{
//		
//		ModelAndView mav = new ModelAndView();
//		
//		MovieDto movie = mService.selectMovie(mo_no);
//		
//		mav.addObject("movie", movie);
//		
//		mav.setViewName("/admin/movie/deleteMovie");
//		return mav;
//	}
	
	@PostMapping(value = "/admin/movie/deleteMovie")
	public ModelAndView deleteMovie(@RequestParam("mo_no")int mo_no) throws SQLException{
		
		ModelAndView mav = new ModelAndView();
		
		service.deleteMovie(mo_no);
		
		mav.setViewName("redirect:/admin/movie/adminMovie");
		return mav;
	}
	
	@GetMapping(value = "/admin/movie/updateMovie")
	public ModelAndView updateMoviePage(@RequestParam("mo_no")int mo_no) throws SQLException{
		
		ModelAndView mav = new ModelAndView();
		
		MovieDto movie = mService.selectMovie(mo_no);
		
		mav.addObject("movie", movie);
		
		mav.setViewName("/admin/movie/updateMovie");
		return mav;
	}
	
	@PostMapping(value = "/admin/movie/updateMovie")
	public ModelAndView updateMovie(@ModelAttribute("movie")MovieDto movie) throws SQLException{
		
		ModelAndView mav = new ModelAndView();
		
		service.updateMovie(movie);
		mav.setViewName("redirect:/admin/movie/adminMovie");
		return mav;
	}
	

	
}
