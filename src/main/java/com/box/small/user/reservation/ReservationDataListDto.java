package com.box.small.user.reservation;

import java.util.List;

import com.box.small.user.movie.MovieDto;
import com.box.small.user.schedule.ScheduleDto;
import com.box.small.user.schedule.ScreenDto;
import com.box.small.user.theater.TheaterDto;
import com.box.small.user.theaterseat.TheaterseatDto;

public class ReservationDataListDto {
	private List<ReservationDto> reservationList;
	private List<MovieDto> movieList;
	private List<ScheduleDto> schedeuleList;
	private List<TheaterDto> theaterList;
	private List<ScreenDto> screenList;
	private List<TheaterseatDto> theaterseatList;
	public List<ReservationDto> getReservationList() {
		return reservationList;
	}
	public void setReservationList(List<ReservationDto> reservationList) {
		this.reservationList = reservationList;
	}
	public List<MovieDto> getMovieList() {
		return movieList;
	}
	public void setMovieList(List<MovieDto> movieList) {
		this.movieList = movieList;
	}
	public List<ScheduleDto> getSchedeuleList() {
		return schedeuleList;
	}
	public void setSchedeuleList(List<ScheduleDto> schedeuleList) {
		this.schedeuleList = schedeuleList;
	}
	public List<TheaterDto> getTheaterList() {
		return theaterList;
	}
	public void setTheaterList(List<TheaterDto> theaterList) {
		this.theaterList = theaterList;
	}
	public List<ScreenDto> getScreenList() {
		return screenList;
	}
	public void setScreenList(List<ScreenDto> screenList) {
		this.screenList = screenList;
	}
	public List<TheaterseatDto> getTheaterseatList() {
		return theaterseatList;
	}
	public void setTheaterseatList(List<TheaterseatDto> theaterseatList) {
		this.theaterseatList = theaterseatList;
	}
	public ReservationDataListDto(List<ReservationDto> reservationList, List<MovieDto> movieList,
			List<ScheduleDto> schedeuleList, List<TheaterDto> theaterList, List<ScreenDto> screenList,
			List<TheaterseatDto> theaterseatList) {
		this.reservationList = reservationList;
		this.movieList = movieList;
		this.schedeuleList = schedeuleList;
		this.theaterList = theaterList;
		this.screenList = screenList;
		this.theaterseatList = theaterseatList;
	}
	public ReservationDataListDto() {
	}
	@Override
	public String toString() {
		return "ReservationDataListDto [reservationList=" + reservationList + ", movieList=" + movieList
				+ ", schedeuleList=" + schedeuleList + ", theaterList=" + theaterList + ", screenList=" + screenList
				+ ", theaterseatList=" + theaterseatList + "]";
	}
	
	
	
}
