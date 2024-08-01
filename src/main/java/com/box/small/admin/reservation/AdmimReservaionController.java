package com.box.small.admin.reservation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.box.small.user.movie.MovieDto;
import com.box.small.user.movie.MovieService;
import com.box.small.user.payment.PaymentService;
import com.box.small.user.reservation.ReservationDataListDto;
import com.box.small.user.reservation.ReservationDto;
import com.box.small.user.reservation.ReservationService;
import com.box.small.user.schedule.ScheduleDto;
import com.box.small.user.schedule.ScheduleService;
import com.box.small.user.schedule.ScreenDto;
import com.box.small.user.theater.TheaterDto;
import com.box.small.user.theater.TheaterService;
import com.box.small.user.theaterseat.TheaterseatDto;
import com.box.small.user.theaterseat.TheaterseatService;

@Controller
public class AdmimReservaionController {
	
	@Autowired
	private MovieService movieService;
	@Autowired
	private TheaterService theaterService;
	@Autowired
	private TheaterseatService theartseatService;
	@Autowired
	private ScheduleService scheduleService;
	
	//test용
	@Autowired
	private ReservationService reservationService;
	@Autowired
	private PaymentService payService;
	
	// test
		@GetMapping(value="/admin/reservation/adminReservation")
		public ModelAndView  adminReservation() throws SQLException {
			ModelAndView mav = new ModelAndView();
			List<ReservationDto> reservationList = reservationService.reservationListAdmin();
			List<MovieDto> movieList = movieService.selectAllMovie();
			List<ScheduleDto> schedeuleList = scheduleService.selectAllSchedule();
			List<TheaterDto> theaterList = theaterService.selectAllTheater();
			List<ScreenDto> screenList = scheduleService.selectAllScreen();
			List<TheaterseatDto> theaterseatList = theartseatService.seatListAll();
			List<ReservationDataListDto> dataList = new ArrayList<>();
			dataList.add(new ReservationDataListDto(reservationList,movieList,schedeuleList,theaterList,screenList,theaterseatList));
			
			System.out.println("리스트 체크 :" + dataList);
			mav.addObject("dataList", dataList);
			mav.setViewName("admin/reservation/adminReservation");
			return mav;
		}	
		
		//test
		@ResponseBody
		@PostMapping(value="/admin/reservation/adminReservation", consumes = MediaType.APPLICATION_JSON_VALUE)
		public List<ReservationDataListDto> cancelReservation(@RequestBody Map<String, Object> params) throws SQLException {
			reservationService.cancelReservation(params);
			ReservationDto reservationDto =  reservationService.selectReservation(params);
			payService.canclePayment(params);	
			int ts_no = reservationDto.getTs_no();
			params.put("ts_no", ts_no);
			theartseatService.cancelSeat(params);
			
			List<ReservationDto> reservationList = reservationService.reservationListAdmin();
			List<MovieDto> movieList = movieService.selectAllMovie();
			List<ScheduleDto> schedeuleList = scheduleService.selectAllSchedule();
			List<TheaterDto> theaterList = theaterService.selectAllTheater();
			List<TheaterseatDto> theaterseatList = theartseatService.seatListAll();
			List<ReservationDataListDto> dataList = new ArrayList<>();
			List<ScreenDto> screenList = scheduleService.selectAllScreen();
			dataList.add(new ReservationDataListDto(reservationList,movieList,schedeuleList,theaterList,screenList,theaterseatList));
			return dataList;
		}

	

	
}
