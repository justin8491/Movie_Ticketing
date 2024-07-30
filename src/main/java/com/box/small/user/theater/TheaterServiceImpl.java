package com.box.small.user.theater;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterServiceImpl implements TheaterService{

	@Autowired
	TheaterDAO dao;
	
	@Override
	public List<TheaterDto> selectAllTheater() throws SQLException {
		return dao.selectAllTheater();
	}

	@Override
	public TheaterDto selectTheater(int th_no) throws SQLException {
		return dao.selectTheater(th_no);
	}

	@Override
	public List<TheaterDto> selectAllTheaterLive() {
		return dao.selectAllTheaterLive();
	}

}
