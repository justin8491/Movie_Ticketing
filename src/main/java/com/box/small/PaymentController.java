package com.box.small;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PaymentController {

	
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
