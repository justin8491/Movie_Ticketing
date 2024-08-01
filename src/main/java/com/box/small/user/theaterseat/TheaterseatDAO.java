package com.box.small.user.theaterseat;


import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

public interface TheaterseatDAO {

	List<TheaterseatDto> theaterseatList(@RequestParam Map<String, Object> params);
	
	void reservationSeat(@RequestParam Map<Object, Object> params); 
	
	void cancelSeat(@RequestParam Map<String, Object> params); 
	
	TheaterseatDto selectSeat(@RequestParam Map<String, Object> params);
	
	List<TheaterseatDto> seatListAll();
	
}
