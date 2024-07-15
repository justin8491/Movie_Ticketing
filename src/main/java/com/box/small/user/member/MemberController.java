package com.box.small.user.member;

import com.mysql.cj.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public ModelAndView mainPage() {
//		logger.info("메인페이지");
//		ModelAndView mav = new ModelAndView();
//
//		mav.setViewName("/");
//
//
//		return mav;
//	}

	@GetMapping(value = "user/member/loginForm")
	public ModelAndView loginForm(){
		ModelAndView mav = new ModelAndView();
		logger.info("로그인 폼 이동");
		mav.setViewName("user/member/loginForm");

		return mav;
	}

}







