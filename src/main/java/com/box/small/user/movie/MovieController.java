package com.box.small.user.movie;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.box.small.user.review.ReviewDto;
import com.box.small.user.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
public class MovieController {

	@Autowired
	private MovieService service;

	@Autowired
	private ReviewService reviewService;

	@GetMapping(value = "/user/movie/movieList")
	public ModelAndView selectAllmovie() throws SQLException {
		
		ModelAndView mav = new ModelAndView();
		
		List<MovieDto>movielist = service.selectAllMovie();
		
		List<CategoryDto>category = service.allCategory();
		mav.addObject("movielist", movielist);
		mav.addObject("category",category);
		
		mav.setViewName("/user/movie/movieList");
		return mav;
	}
	
	@GetMapping(value = "/user/movie/detailMovie")
	public ModelAndView selectMovie(@RequestParam("mo_no")int mo_no, HttpSession session) throws SQLException {
		
		ModelAndView mav = new ModelAndView();
		
		MovieDto movie = service.selectMovie(mo_no);
		
		String cat_name = service.category(movie.getCat_no());
        // 리뷰리스트
        List<ReviewDto> reviewList = reviewService.reviewAll(mo_no);
        mav.addObject("reviewList", reviewList);
		mav.addObject("cat_name", cat_name);
		mav.addObject("movie", movie);
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
}
