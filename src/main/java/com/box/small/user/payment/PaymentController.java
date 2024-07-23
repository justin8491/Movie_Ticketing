package com.box.small.user.payment;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	//아마 마이페이지에서 한번에 보여줄 듯
	@GetMapping(value="/user/mapage")
	public ModelAndView paymentList() {
		PaymentDTO paymentDTO = service.paymentdata();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject(paymentDTO);
		mav.setViewName("user/mypage/mypage");
		return mav;
	}
	
	@RequestMapping(value = "/user/payment", method = RequestMethod.GET)
	public String pay() {
		return "user/payment/payment";
	}
	
	
	@RequestMapping(value="/user/paymentPop",method = RequestMethod.GET)
	public String login(HttpServletRequest request, Model model) {
		String card = request.getParameter("selectedCard");
		System.out.println(card);
		model.addAttribute("cardCompany", card);
		return "user/payment/paymentPop";
	}
	
}
