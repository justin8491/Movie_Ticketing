package com.box.small.user.theaterseat;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class TheaterseatServiceImpl implements TheaterseatService {

	@Autowired
	private TheaterseatDAO dao;


	
	@Override
	public List<TheaterseatDto> theaterseatList(Map<String, Object> params) {
		System.out.println("서비스");
		return dao.theaterseatList(params);
	}



	@Override
	public void reservationSeat(Map<Object, Object> params) {
		dao.reservationSeat(params);
	}



	@Override
	public void cancelSeat(Map<String, Object> params) {
		dao.cancelSeat(params);
		
	}



	@Override
	public TheaterseatDto selectSeat(Map<String, Object> params) {
		return dao.selectSeat(params);
	}



	@Override
	public List<TheaterseatDto> seatListAll() {
		return dao.seatListAll();
	}

	

}
