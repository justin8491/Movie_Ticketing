package com.box.small.user.support;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.box.small.HomeController;

@Controller
public class SupportController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	SupportService service;

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
		logger.info("자주 묻는 질문 페이지 이동");
		
		List<SupportDto> faqlist = service.faq();
		
		mav.addObject("faqlist", faqlist);
		mav.setViewName("user/support/faq");
		
		return mav;		
	}	
	@GetMapping(value = "/user/support/notice")
	public ModelAndView notice() {
		ModelAndView mav = new ModelAndView();
		logger.info("공지사항 폼 이동");
		
		List<SupportDto> noticelist = service.notice();
		
		mav.addObject("noticelist", noticelist);
		mav.setViewName("/user/support/notice");
		
		return mav;
	}
	@GetMapping(value = "/user/support/freeBoard")
	public ModelAndView freeBoard() {
		logger.info("자유게시판 폼 이동");
		
		List<SupportDto> freeboardlist = service.freeBoard();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("freeboardlist", freeboardlist);
		mav.setViewName("/user/support/freeBoard");
		
		return mav;
	}
	@GetMapping(value = "/user/support/inquiry")
	public ModelAndView inquiry() {
		logger.info("1대1 문의 페이지 이동");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/support/inquiry");
		
		return mav;
	}
	@GetMapping(value = "/user/support/selectFreeBoard")
	public ModelAndView selectFreeBoard(@RequestParam("bo_no") int bo_no) {
		logger.info("자유게시판 상세페이지 이동");
		
		SupportDto freeBoard = service.selectFreeBoardWrite(bo_no);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/user/support/selectFreeBoard");
		mav.addObject("freeBoard", freeBoard);
		
		return mav;
	}
	@GetMapping(value = "/user/support/selectNotice")
	public ModelAndView selectNotice(@RequestParam("bo_no") int bo_no) {
		logger.info("공지사항 상세페이지 이동");
		
		SupportDto noticelist = service.selectNotice(bo_no);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/user/support/selectNotice");
		mav.addObject("noticelist", noticelist);
		
		return mav;
	}
	@GetMapping(value = "/user/support/selectFaq")
	public ModelAndView selectFaq(@RequestParam("bo_no") int bo_no) {
		logger.info("자주 묻는 질문 상세페이지 이동");
		
		SupportDto faqlist = service.selectFaq(bo_no);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/user/support/selectFaq");
		mav.addObject("faqlist", faqlist);
		
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}