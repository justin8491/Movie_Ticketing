package com.box.small;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

//	메서드 종류
	/*
	GET
	POST
	PUT
	DELETE
	 */

//	@GetMapping(value="login/loginForm")
//	public String loginForm(Model model) {
//		String test = "로그인 폼 처리화면";
////		logger.info("로그인 폼 처리화면");
//		model.addAttribute("test",test);
//		return "login/loginForm";
//	}
//
//	@PostMapping(value = "login/login")
//	public String login(Model model
//			, HttpServletRequest request
//			, HttpServletResponse response) throws UnsupportedEncodingException {
//
//		logger.info("로그인 처리하기");
//		request.setCharacterEncoding("utf-8");
//		String userID = request.getParameter("userID");
//		String name = request.getParameter("name");
//		logger.info(userID);
//		logger.info(name);
//		model.addAttribute("userID",userID);
//		model.addAttribute("name",name);
//		return "login/result";
//	}
//
////	Requset한 파라미터 받는 2번째 방법
//	@PostMapping(value = "login/login2")
//	public String login2(Model model,@RequestParam("userID") String userID, @RequestParam("name") String name, HttpServletRequest req) throws UnsupportedEncodingException {
//		req.setCharacterEncoding("utf-8");
//		model.addAttribute("userID", userID);
//		model.addAttribute("name", name);
//		return "login/result";
//	}


//	Map 방식
//	@PostMapping(value = "login/login3")
//	public ModelAndView login3(@RequestParam Map<String,String> info, Model model){
//
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("info",info);
//		mav.setViewName("login/result");
//
////		model.addAttribute("info",info);
////		model.addAttribute("userID",info.get("userID"));
////		model.addAttribute("name",info.get("name"));
//
//		return mav;
//	}
//
////	Bean 클래스 세팅
//@PostMapping(value = "login/login4")
////public String login4(LoginVO login, Model model){
//public String login4(@ModelAttribute("info")LoginVO login, Model model){
//	model.addAttribute("info",login);
////	model.addAttribute("userID",info.get("userID"));
////	model.addAttribute("name",info.get("name"));
//
//	return "login/result";
//}
}






