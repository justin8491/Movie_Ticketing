package com.box.small.user.reservation;


import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

public interface ReservationDAO {

	ReservationDto intsertReservation(@RequestParam Map<Object, Object> params);
	
	List<ReservationDto>  reservationList(String mem_id);
	
	void cancelReservation(@RequestParam Map<String, Object> params);
	
	ReservationDto selectReservation(@RequestParam Map<String, Object> params);
	
	List<ReservationDto> reservationListAdmin();
}
