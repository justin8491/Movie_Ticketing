package com.box.small.controller.user.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.box.small.HomeController;

@Controller
public class SupportController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	
	@GetMapping(value = "user/support/support")
	public ModelAndView support(){
		ModelAndView mav = new ModelAndView();
		logger.info("고객센터 메인 폼 이동");
		mav.setViewName("user/support/support");

		return mav;
	}

	@GetMapping(value = "/user/support/faq")
	public ModelAndView faq() {
		ModelAndView mav = new ModelAndView();
		logger.info("1대1 문의 사항 폼 이동");
		
		mav.setViewName("user/support/faq");
		
		return mav;		
	}

}