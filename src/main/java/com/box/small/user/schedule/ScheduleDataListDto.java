package com.box.small.user.schedule;

import java.util.List;

import com.box.small.user.movie.MovieDto;
import com.box.small.user.theater.TheaterDto;

public class ScheduleDataListDto {
	
	private List<ScheduleDto> scheduleList;
	
	private List<MovieDto> movieList;
	
	private List<ScreenDto> screenList;
	
	private List<TheaterDto> theaterList;

	
	
	@Override
	public String toString() {
		return "ScheduleDataDto [scheduleList=" + scheduleList + ", movieList=" + movieList + ", screenList="
				+ screenList + ", theaterList=" + theaterList + "]";
	}

	public ScheduleDataListDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScheduleDataListDto(List<ScheduleDto> scheduleList, List<MovieDto> movieList, List<ScreenDto> screenList,
			List<TheaterDto> theaterList) {
		super();
		this.scheduleList = scheduleList;
		this.movieList = movieList;
		this.screenList = screenList;
		this.theaterList = theaterList;
	}

	public List<ScheduleDto> getscheduleList() {
		return scheduleList;
	}

	public void setscheduleList(List<ScheduleDto> scheduleList) {
		this.scheduleList = scheduleList;
	}

	public List<MovieDto> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<MovieDto> movieList) {
		this.movieList = movieList;
	}

	public List<ScreenDto> getScreenList() {
		return screenList;
	}

	public void setScreenList(List<ScreenDto> screenList) {
		this.screenList = screenList;
	}

	public List<TheaterDto> getTheaterList() {
		return theaterList;
	}

	public void setTheaterList(List<TheaterDto> theaterList) {
		this.theaterList = theaterList;
	}
	
	
	
}
