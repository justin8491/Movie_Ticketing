package com.box.small.admin.schedule;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.box.small.user.movie.MovieDto;
import com.box.small.user.movie.MovieService;
import com.box.small.user.schedule.ScheduleDataListDto;
import com.box.small.user.schedule.ScheduleDto;
import com.box.small.user.schedule.ScheduleService;
import com.box.small.user.schedule.ScreenDto;
import com.box.small.user.theater.TheaterDto;
import com.box.small.user.theater.TheaterService;

@Controller
public class AdminScheduleController {

	@Autowired
	private AdminScheduleService aService;
	
	@Autowired
	private ScheduleService service;
	
	@Autowired
	private MovieService mService;
	
	@Autowired
	private TheaterService tService;
	
	
	// 관리자 스케줄관리 페이지
	@GetMapping(value = "/admin/schedule/adminSchedule")
	public ModelAndView adminSchedule() throws SQLException {
		
		ModelAndView mav = new ModelAndView();
		
		List<ScheduleDto>scheduleList = service.sellectAllSchedule();
		List<MovieDto>movieList = mService.selectAllMovie();
		List<ScreenDto>screenList = service.sellectAllScreen();
		List<TheaterDto>theaterList = tService.sellectAlltheater();
		
		List<ScheduleDataListDto> scheduleDataList = new ArrayList<>();

		 scheduleDataList.add(new ScheduleDataListDto(scheduleList, movieList, screenList, theaterList));
	
		mav.addObject("scheduleDataList", scheduleDataList);
		
		return mav;
	}
	
	// 스케줄 추가 페이지로 이동
	@GetMapping(value = "/admin/schedule/addSchedule")
	public ModelAndView addSchedulePage() throws SQLException{
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/schedule/addSchedule");
		return mav;
	}
	
	// 스케줄 추가
	@PostMapping(value = "/admin/schedule/addsShedule")
	public ModelAndView addSchedule(@ModelAttribute("schedule")ScheduleDto schedule) throws SQLException{
		
		ModelAndView mav = new ModelAndView();
		
		aService.addSchedule(schedule);

		mav.setViewName("redirect:/admin/schedule/adminSchedule");
		return mav;
	}	
	
	// 스케줄 삭제 (상태를 0으로 만듦)
	@PostMapping(value = "/admin/schedule/deleteSchedule")
	public ModelAndView deleteSchedule(@RequestParam("sch_no")int sch_no) throws SQLException{
		
		ModelAndView mav = new ModelAndView();
		
		aService.deleteSchedule(sch_no);
		
		mav.setViewName("redirect:/admin/schedule/adminSchedule");
		return mav;
	}
	
	// 스케줄 수정 페이지로 이동
	@GetMapping(value = "/admin/schedule/updateSchedule")
	public ModelAndView updateSchedulePage(@RequestParam("sch_no")int sch_no) throws SQLException{
		
		ModelAndView mav = new ModelAndView();
		
		ScheduleDto schedule = service.sellectSchedule(sch_no);
		
		MovieDto movie = mService.selectMovie(schedule.getMo_no());
		
		mav.addObject("movie", movie);
		
		mav.addObject("schedule", schedule);
		
		mav.setViewName("/admin/schedule/updateSchedule");
		return mav;
	}
	
	// 스케줄 수정.
	@PostMapping(value = "/admin/schedule/updateSchedule")
	public ModelAndView updateSchedule(@ModelAttribute("schedule")ScheduleDto schedule) throws SQLException{
		
		ModelAndView mav = new ModelAndView();
		
		aService.updateSchedule(schedule);
		mav.setViewName("redirect:/admin/schedule/adminSchedule");
		return mav;
	}
	

	
}
