package com.box.small.user.reservation;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDAOImpl dao;


	@Override
	public ReservationDto intsertReservation(@RequestParam Map<Object, Object> params) {
		
		return dao.intsertReservation(params);
	}


	@Override
	public List<ReservationDto> reservationList(String mem_id) {
		return dao.reservationList(mem_id);
	}


	@Override
	public void cancelReservation(@RequestParam Map<String, Object> params) {
		dao.cancelReservation(params);
	}


	@Override
	public ReservationDto selectReservation(Map<String, Object> params) {
		return dao.selectReservation(params);
	}

	

}
