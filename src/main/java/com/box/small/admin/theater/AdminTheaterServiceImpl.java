package com.box.small.admin.theater;

import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.box.small.user.movie.MovieDto;
import com.box.small.user.theater.TheaterDto;

@Service
public class AdminTheaterServiceImpl implements AdminTheaterService{
	
	@Inject
	AdminTheaterDAO dao;

	@Override
	public void addTheater(TheaterDto theater) throws SQLException {
		dao.addTheater(theater);
	}

	@Override
	public void deleteTheater(int th_no) throws SQLException {
		dao.deleteTheater(th_no);
	}

	@Override
	public void updateTheater(TheaterDto theater) throws SQLException {
		dao.updateTheater(theater);
	}
	


}
