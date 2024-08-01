package com.box.small.user.schedule;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.box.small.user.movie.MovieDto;
import com.box.small.user.movie.MovieService;
import com.box.small.user.theater.TheaterDto;
import com.box.small.user.theater.TheaterService;


@Controller
public class ScheduleController {

	@Autowired
	private ScheduleService service;
	
	@Autowired
	private MovieService mService;
	
	@Autowired
	private TheaterService tService;
	
	@GetMapping(value = "/user/schedule/scheduleList")
	public ModelAndView selectAllSchedule() throws SQLException {
		
		ModelAndView mav = new ModelAndView();
		
		List<ScheduleDto>scheduleList = service.selectAllSchedule();
		List<MovieDto>movieList = mService.selectAllMovie();
		List<ScreenDto>screenList = service.selectAllScreen();
		List<TheaterDto>theaterList = tService.sellectAlltheater();
		
		List<ScheduleDataListDto> scheduleDataList = new ArrayList<>();

		 scheduleDataList.add(new ScheduleDataListDto(scheduleList, movieList, screenList, theaterList));
	
		mav.addObject("scheduleDataList", scheduleDataList);
		
		mav.setViewName("/user/schedule/scheduleList");
		return mav;
	}
	
	@GetMapping(value = "/user/Schedule/detailSchedule")
	public ModelAndView selectSchedule(@RequestParam("sch_no")int sch_no) throws SQLException {
		
		ModelAndView mav = new ModelAndView();
		
		ScheduleDto schedule = service.selectSchedule(sch_no);
		MovieDto movie = mService.selectMovie(schedule.getMo_no());
		ScreenDto screen = service.selectScreen(schedule.getSc_no());
		TheaterDto theater = tService.sellectTheater(screen.getTh_no());
		
		ScheduleDataDto scheduleData = new ScheduleDataDto(schedule, movie, screen, theater);
		    
		mav.addObject("scheduleData", scheduleData);
		
		mav.setViewName("/user/schedule/detailSchedule");
		return mav;
	}
	
	
	
}
