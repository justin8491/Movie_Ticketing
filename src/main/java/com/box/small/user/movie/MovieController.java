package com.box.small.user.movie;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovieController {

	@Autowired
	private MovieService service;
	
	@GetMapping(value = "/user/movie/movieList")
	public ModelAndView selectAllmovie() throws SQLException {
		
		System.out.println("영화 페이지로 이동");
		
		ModelAndView mav = new ModelAndView();
		
		List<MovieDto>movieList = service.selectAllMovieLive();
		
		List<CategoryDto>category = service.allCategory();
		mav.addObject("movieList", movieList);
		mav.addObject("category",category);
		mav.setViewName("/user/movie/movieList");
		return mav;
	}
	
	@GetMapping(value = "/user/movie/detailMovie")
	public ModelAndView selectMovie(@RequestParam("mo_no")int mo_no) throws SQLException {
		
		System.out.println("상세영화페이지로이동");
		
		ModelAndView mav = new ModelAndView();
		
		MovieDto movie = service.selectMovie(mo_no);
		
		String cat_name = service.category(movie.getCat_no());
		
		mav.addObject("movie", movie);
		mav.addObject("cat_name", cat_name);
		mav.setViewName("/user/movie/detailMovie");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "/user/movie/selectCategory", method = RequestMethod.POST)
	public List<MovieDto> selectCategory(@RequestParam("cat_no") int cat_no) throws SQLException {
		List<MovieDto> data;
	    if (cat_no == 0) {
	    	System.out.println("전체영화를 선택하셨습니다");
	    	data = service.selectAllMovie();
	    	System.out.println(data);
	    } else {
	    	System.out.println("cat_no 가 "  + cat_no +"인 영화를 선택하셨습니다.");
	    	data = service.selectMovieCategory(cat_no);
	    	System.out.println(data);
	    }
	    return data;
	}
	
}
