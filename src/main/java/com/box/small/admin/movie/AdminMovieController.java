package com.box.small.admin.movie;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.box.small.user.movie.CategoryDto;
import com.box.small.user.movie.MovieDto;
import com.box.small.user.movie.MovieService;

@Controller
public class AdminMovieController {
	
	
	
	@Autowired
	private ServletContext servletContext;
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
		
		List<CategoryDto> categoryList = mService.allCategory();
		mav.addObject("categoryList", categoryList);
		
		mav.setViewName("/admin/movie/addMovie");
		return mav;
	}
	
	@PostMapping(value = "/admin/movie/addMovie")
	public ModelAndView addMovie(
	        @ModelAttribute("movie") MovieDto movie,
	        @RequestParam(value = "mo_image", required = false) MultipartFile mo_image) throws SQLException, IllegalStateException, IOException {
	    
	    System.out.println("addMovie 메서드 호출됨");  // 이 로그가 출력되는지 확인

	    ModelAndView mav = new ModelAndView();

	    // 파일 업로드 처리
	    String photoFileName = handleFileUpload(mo_image);
	    movie.setMo_photo(photoFileName);

	    // MovieDto를 DB에 추가
	    service.addMovie(movie);

	    System.out.println(movie);

	    mav.setViewName("redirect:/admin/movie/adminMovie");
	    return mav;
	}

	private String handleFileUpload(MultipartFile file) throws IllegalStateException, IOException {
	    if (file == null || file.isEmpty()) {
	    	System.out.println("사진이미지비었음. file이 null임");
	        return "no_image.jpg"; // 기본 이미지로 설정
	    }
	    
	    System.out.println("사진이 이미지가 있으면 이거나옴.");
	    
	    String uploadDir = servletContext.getRealPath("/resources/images");
	    
	    System.out.println("uploadDir = "+uploadDir);
	    
	    File uploadDirectory = new File(uploadDir);

	    String OriginalFileName = file.getOriginalFilename();
	    
	    String uuid = UUID.randomUUID().toString();
	    
	    File targetFile = new File(uploadDirectory, uuid+"_"+OriginalFileName);
	    
	    file.transferTo(targetFile);
	    
	    System.out.println(targetFile.getName());
	    
	    return targetFile.getName();
	}
	
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
		
		List<CategoryDto> categoryList = mService.allCategory();
		mav.addObject("categoryList", categoryList);
		mav.addObject("movie", movie);
		
		mav.setViewName("/admin/movie/updateMovie");
		return mav;
	}
	
	@PostMapping(value = "/admin/movie/updateMovie")
	public ModelAndView updateMovie(
			@ModelAttribute("movie")MovieDto movie,
			@RequestParam(value = "mo_image", required = false) MultipartFile mo_image) throws SQLException, IllegalStateException, IOException{
		
		 	System.out.println("updateMovie 메서드 호출됨");  // 이 로그가 출력되는지 확인

		    ModelAndView mav = new ModelAndView();

		    // 파일 업로드 처리
		    String photoFileName = handleFileUpload(mo_image);
		    movie.setMo_photo(photoFileName);
		
		    service.updateMovie(movie);
		    mav.setViewName("redirect:/admin/movie/adminMovie");
		    return mav;
	}
	

	
}
