package com.box.small.admin.theater;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.box.small.HomeController;
import com.box.small.user.theater.TheaterDto;
import com.box.small.user.theater.TheaterService;

@Controller
public class AdminTheaterController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private AdminTheaterService service;
	
	@Autowired
	private TheaterService mService;

	@GetMapping(value = "/admin/theater/adminTheater")
	public ModelAndView adminTheater() throws SQLException {
		
		ModelAndView mav = new ModelAndView();
		
		List<TheaterDto>theater = mService.selectAllTheater();
		mav.addObject("theater", theater);
		mav.setViewName("/admin/theater/adminTheater");
		
		return mav;
	}
	
	@GetMapping(value = "/admin/theater/addTheater")
	public ModelAndView addTheaterPage() throws SQLException{
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/admin/theater/addTheater");
		return mav;
	}
	
	@PostMapping(value = "/admin/theater/addTheater")
	public ModelAndView addTheater(
			@ModelAttribute("theater")TheaterDto theater,
			@RequestParam(value = "th_image", required = false) MultipartFile th_image) throws SQLException, IllegalStateException, IOException{
		System.out.println("극장이름 : "+theater.getTh_name());
		System.out.println("극장상태 : "+theater.getTh_status());
		System.out.println("극장위치 : "+theater.getTh_location());
		ModelAndView mav = new ModelAndView();
		
		String photoFileName = handleFileUpload(th_image);
	    theater.setTh_photo(photoFileName);
		
		service.addTheater(theater);
		
		System.out.println(theater);
		
		mav.setViewName("redirect:/admin/theater/adminTheater");
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
	
	@PostMapping(value = "/admin/theater/deleteTheater")
	public ModelAndView deleteTheater(@RequestParam("th_no")int th_no) throws SQLException{
		
		ModelAndView mav = new ModelAndView();
		
		service.deleteTheater(th_no);
		
		mav.setViewName("redirect:/admin/theater/adminTheater");
		return mav;
	}
	
	@GetMapping(value = "/admin/theater/updateTheater")
	public ModelAndView updateTheaterPage(@RequestParam("th_no")int th_no) throws SQLException{
		
		
		ModelAndView mav = new ModelAndView();
		
		TheaterDto theater = mService.selectTheater(th_no);
		
		mav.addObject("theater", theater);
		
		mav.setViewName("/admin/theater/updateTheater");
		return mav;
	}
	
	@PostMapping(value = "/admin/theater/updateTheater")
	public ModelAndView updateTheater(
			@ModelAttribute("theater")TheaterDto theater,
			@RequestParam(value = "th_image", required = false) MultipartFile th_image) throws SQLException, IllegalStateException, IOException{
		System.out.println("극장이름 : "+theater.getTh_name());
		System.out.println("극장상태 : "+theater.getTh_status());
		System.out.println("극장위치 : "+theater.getTh_location());
		
		ModelAndView mav = new ModelAndView();
		
		String photoFileName = handleFileUpload(th_image);
	    theater.setTh_photo(photoFileName);
		
		service.updateTheater(theater);
		
		mav.setViewName("redirect:/admin/theater/adminTheater");
		return mav;
	}
}
