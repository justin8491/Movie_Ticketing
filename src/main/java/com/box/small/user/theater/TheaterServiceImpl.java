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
	public List<TheaterDto> sellectAlltheater() throws SQLException {
		return dao.sellectAlltheater();
	}

	@Override
	public TheaterDto sellectTheater(int th_no) throws SQLException {
		return dao.sellectTheater(th_no);
	}

}
