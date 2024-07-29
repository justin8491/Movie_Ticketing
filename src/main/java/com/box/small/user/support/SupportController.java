package com.box.small.user.support;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.box.small.HomeController;
import com.box.small.user.member.MemberDto;

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
	public ModelAndView inquiryForm() {
		logger.info("1대1 문의 페이지 이동");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/support/inquiry");
		
		return mav;
	}
	@PostMapping(value = "/user/support/inquiry")
	public ModelAndView inquiry(@ModelAttribute("sp") SupportDto sp) {
		logger.info("1대1 문의 작성");
		ModelAndView mav = new ModelAndView();
		
		service.inquiryWrite(sp);
		
		mav.setViewName("redirect:/user/support/support");
		
		return mav;
	}
	@GetMapping(value="/user/support/myBoard")
	public ModelAndView myBoard() {
		logger.info("문의글 보기");
		
		List<SupportDto> inquiryView = service.inquiryView();
		List<SupportDto> freeBoard = service.freeBoard();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("inquiryView", inquiryView);
		mav.addObject("freeBoard", freeBoard);
		mav.setViewName("/user/support/myBoard");
		
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
	
	@GetMapping(value = "/user/support/freeBoardWrite")
	public ModelAndView freeBoardWriteForm() {
		logger.info("게시판 작성 폼");
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/user/support/freeBoardWrite");
		
		return mav;
	}
	
	@PostMapping(value = "/user/support/freeBoardWrite")
	public ModelAndView freeBoardWrite(@ModelAttribute("sp") SupportDto sp
			,@ModelAttribute("mb") MemberDto mb) {
		logger.info("게시판 작성 페이지");
		ModelAndView mav = new ModelAndView();
		
		service.freeBoardWrite(sp);
		
			mav.setViewName("redirect:/user/support/freeBoard");
			return mav;
		}
	
	@GetMapping(value = "/user/support/freeBoardDelete")
	public ModelAndView freeBoardDeleteForm(@RequestParam("bo_no") int bo_no) {
		logger.info("게시판 삭제 폼");
		ModelAndView mav = new ModelAndView();
		
		SupportDto sp = service.selectFreeBoardWrite(bo_no);
		
		mav.addObject("sp", sp);
		mav.setViewName("/user/support/freeBoardDelete");
		
		return mav;
	}
	
	@PostMapping(value = "/user/support/freeBoardDelete")
	public ModelAndView freeBoardDelete(@RequestParam("bo_no")int bo_no) {
		logger.info("게시판 삭제");
		ModelAndView mav = new ModelAndView();
		
		SupportDto sp = service.selectFreeBoardWrite(bo_no);
		
		service.freeBoardDelete(sp);
		
		mav.setViewName("redirect:/user/support/freeBoard");
		
		return mav;
	}
	
	@GetMapping(value = "/user/support/freeBoardUpdate")
	public ModelAndView freeBoardUpdateForm(@RequestParam("bo_no")int bo_no) {
		logger.info("게시판 수정 폼");
		ModelAndView mav = new ModelAndView();
		
		SupportDto sp = service.selectFreeBoardWrite(bo_no);
		
		mav.addObject("sp", sp);
		mav.setViewName("/user/support/freeBoardUpdate");
		
		return mav;
	}
	@PostMapping(value = "/user/support/freeBoardUpdate")
	public ModelAndView freeBoardUpdate(@ModelAttribute SupportDto sp) {
		logger.info("게시판 수정");
		ModelAndView mav = new ModelAndView();
		
		service.freeBoardUpdate(sp);
		
		mav.setViewName("redirect:/user/support/freeBoard");
		
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}