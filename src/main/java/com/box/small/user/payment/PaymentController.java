package com.box.small.user.payment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.box.small.user.reservation.ReservationService;
import com.box.small.user.theaterseat.TheaterseatService;


@Controller
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private TheaterseatService theaterseatService;
		
	
	@GetMapping(value = "/user/payment/payment")
	public ModelAndView payment(@RequestParam Map<Object, Object> params,@RequestParam String ts_no) {
		String ts_no1 = ts_no;
		String[] ts_idList = ts_no1.split(",");
		int reservtionCnt= ts_idList.length;
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/payment/payment");
		mav.addObject("reservtionCnt", reservtionCnt);
		return mav;
	}

	@ResponseBody
	@PostMapping(value="/user/payment/payment", consumes = MediaType.APPLICATION_JSON_VALUE)
	public CardDto selectCardList(@RequestBody Map<Object, Object> params) {
	    CardDto cardDto = service.selectCardList(params);
	    return cardDto;
	}
	

   @PostMapping(value="/")
    public ModelAndView insertPayment(@RequestParam Map<Object, Object> params, HttpServletRequest request) {
	   
	   	String ts_no = request.getParameter("ts_no");
	   	String[] ts_noList = ts_no.split(",");
	   	params.put("ts_list", ts_noList);
	   
		// 현재시간(결제시간) format
		Date now = new Date();
		SimpleDateFormat format;
		format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		params.put("pay_date", format.format(now));
	
	    // 번호 없음(ai)설정
	   	service.insertPayment(params);
	   	PaymentDto dto =  service.selectPayment(params);
	   	params.put("pay_no", dto.getPay_no());
	   
	   	// 예약정보 기록
	   	reservationService.intsertReservation(params);
	   	
	   	// 예약좌석 상태변경
	   	theaterseatService.reservationSeat(params);
	   
    	ModelAndView mav = new ModelAndView();
    	
    	mav.setViewName("home_beta");
    	return mav;
    }
		
}
