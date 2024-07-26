package com.box.small.user.schedule;

import com.box.small.user.movie.MovieDto;
import com.box.small.user.theater.TheaterDto;

public class ScheduleDataDto {
	
	private ScheduleDto schedule;
	
	private MovieDto movie;
	
	private ScreenDto screen;
	
	private TheaterDto theater;
	
	

	@Override
	public String toString() {
		return "ScheduleDataDto [schedule=" + schedule + ", movie=" + movie + ", screen=" + screen + ", theater="
				+ theater + "]";
	}

	public ScheduleDataDto() {
		super();
	}

	public ScheduleDataDto(ScheduleDto schedule, MovieDto movie, ScreenDto screen, TheaterDto theater) {
		super();
		this.schedule = schedule;
		this.movie = movie;
		this.screen = screen;
		this.theater = theater;
	}

	public ScheduleDto getschedule() {
		return schedule;
	}

	public void setschedule(ScheduleDto schedule) {
		this.schedule = schedule;
	}

	public MovieDto getMovie() {
		return movie;
	}

	public void setMovie(MovieDto movie) {
		this.movie = movie;
	}

	public ScreenDto getScreen() {
		return screen;
	}

	public void setScreen(ScreenDto screen) {
		this.screen = screen;
	}

	public TheaterDto getTheater() {
		return theater;
	}

	public void setTheater(TheaterDto theater) {
		this.theater = theater;
	}

	
	

	
}
