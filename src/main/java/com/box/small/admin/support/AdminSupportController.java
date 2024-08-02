package com.box.small.admin.support;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.box.small.admin.comment.AdminCommentDto;
import com.box.small.admin.comment.AdminCommentService;
import com.box.small.user.comment.CommentDto;
import com.box.small.user.member.MemberDto;
import com.box.small.user.support.SupportDto;

@Controller

public class AdminSupportController {
   
   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   
   @Autowired
   AdminSupportService service;
   
   @Autowired
   AdminCommentService adminService;
   
   @GetMapping(value = "/admin/support/adminSupport")
   public ModelAndView support(){
      ModelAndView mav = new ModelAndView();
      logger.info("고객센터 메인 폼 이동");
      mav.setViewName("/admin/support/adminSupport");

      return mav;
   }
   @GetMapping(value = "/admin/support/adminFaq")
   public ModelAndView faq() {
      ModelAndView mav = new ModelAndView();
      logger.info("자주 묻는 질문 페이지 이동");
      
      List<AdminSupportDto> faqlist = service.adminFaq();
      
      mav.addObject("faqlist", faqlist);
      mav.setViewName("admin/support/adminFaq");
      
      return mav;      
   }   
   @GetMapping(value = "/admin/support/adminNotice")
   public ModelAndView notice() {
      ModelAndView mav = new ModelAndView();
      logger.info("공지사항 폼 이동");
      
      List<AdminSupportDto> noticelist = service.adminNotice();
      
      mav.addObject("noticelist", noticelist);
      mav.setViewName("/admin/support/adminNotice");
      
      return mav;
   }
   @GetMapping(value = "/admin/support/adminFreeBoard")
   public ModelAndView freeBoard() {
      logger.info("자유게시판 폼 이동");
      
      List<AdminSupportDto> freeboardlist = service.adminFreeBoard();
      
      ModelAndView mav = new ModelAndView();
      mav.addObject("freeboardlist", freeboardlist);
      mav.setViewName("/admin/support/adminFreeBoard");
      
      return mav;
   }
   @GetMapping(value = "/admin/support/adminInquiry")
   public ModelAndView InquiryView() {
      ModelAndView mav = new ModelAndView();
      logger.info("문의글 리스트");
      
      List<AdminSupportDto> inquiryViewlist = service.adminInquiry();
      
      mav.addObject("inquiryViewlist", inquiryViewlist);
      mav.setViewName("/admin/support/adminInquiry");
      
      return mav;
   }
   
   
   @GetMapping(value = "/admin/support/adminSelectInquiry")
   public ModelAndView selectInquiry(@RequestParam("bo_no") int bo_no) {
      logger.info("문의글 상세페이지 이동");
      
      AdminSupportDto inquiry = service.adminSelectFreeBoardWrite(bo_no);
      ModelAndView mav = new ModelAndView();
      
      mav.setViewName("/admin/support/adminSelectInquiry");
      mav.addObject("inquiry", inquiry);
      
      return mav;
   }
   
   @GetMapping(value = "/admin/support/adminSelectFreeBoard")
   public ModelAndView selectFreeBoard(@RequestParam("bo_no") int bo_no ,
         HttpServletRequest request) {
      logger.info("자유게시판 상세페이지 이동");
      ModelAndView mav = new ModelAndView();
      
      AdminSupportDto freeBoard = service.adminSelectFreeBoardWrite(bo_no);
      List<AdminCommentDto> adminCommentList = adminService.adminCommentList(bo_no);
      
      mav.addObject("freeBoard", freeBoard);
      mav.addObject("adminCommentList", adminCommentList);
//      logger.info("CommentList: " + commentList);
      mav.setViewName("/admin/support/adminSelectFreeBoard");
      
      return mav;
   }
   @GetMapping(value = "/admin/support/adminSelectNotice")
   public ModelAndView selectNotice(@RequestParam("bo_no") int bo_no) {
      logger.info("공지사항 상세페이지 이동");
      
      AdminSupportDto noticelist = service.adminSelectNotice(bo_no);
      ModelAndView mav = new ModelAndView();
      
      mav.setViewName("/admin/support/adminSelectNotice");
      mav.addObject("noticelist", noticelist);
      
      return mav;
   }
   @GetMapping(value = "/admin/support/adminSelectFaq")
   public ModelAndView selectFaq(@RequestParam("bo_no") int bo_no) {
      logger.info("자주 묻는 질문 상세페이지 이동");
      
      AdminSupportDto faqlist = service.adminSelectFaq(bo_no);
      ModelAndView mav = new ModelAndView();
      
      mav.setViewName("/admin/support/adminSelectFaq");
      mav.addObject("faqlist", faqlist);
      
      return mav;
   }
   
   @GetMapping(value = "/admin/support/adminBoardAdd")
   public ModelAndView adminBoardAddForm() {
      logger.info("게시판 작성 폼");
      ModelAndView mav = new ModelAndView();
      
      mav.setViewName("/admin/support/adminBoardAdd");
      
      return mav;
   }
   
   @PostMapping(value = "/admin/support/adminBoardAdd")
   public ModelAndView adminBoardAdd(@ModelAttribute("sp") AdminSupportDto sp
         ,@ModelAttribute("mb") MemberDto mb) {
      logger.info("게시판 작성 페이지");
      ModelAndView mav = new ModelAndView();
      
      service.adminBoardAdd(sp);
      
         mav.setViewName("redirect:/admin/support/adminSupport");
         return mav;
      }
   
   @GetMapping(value = "/admin/support/adminFreeBoardDelete")
   public ModelAndView freeBoardDeleteForm(@RequestParam("bo_no") int bo_no) {
      logger.info("게시판 삭제 폼");
      ModelAndView mav = new ModelAndView();
      
      AdminSupportDto sp = service.adminSelectFreeBoardWrite(bo_no);
      
      mav.addObject("sp", sp);
      mav.setViewName("/admin/support/adminFreeBoardDelete");
      
      return mav;
   }
   
   @PostMapping(value = "/admin/support/adminFreeBoardDelete")
   public ModelAndView freeBoardDelete(@RequestParam("bo_no")int bo_no) {
      logger.info("게시판 삭제");
      ModelAndView mav = new ModelAndView();
      
      AdminSupportDto sp = service.adminSelectFreeBoardWrite(bo_no);
      
      service.adminFreeBoardDelete(sp);
      
      mav.setViewName("redirect:/admin/support/adminSupport");
      
      return mav;
   }
   
   @GetMapping(value = "/admin/support/adminFreeBoardUpdate")
   public ModelAndView freeBoardUpdateForm(@RequestParam("bo_no")int bo_no) {
      logger.info("게시판 수정 폼");
      ModelAndView mav = new ModelAndView();
      
      AdminSupportDto sp = service.adminSelectFreeBoardWrite(bo_no);
      
      mav.addObject("sp", sp);
      mav.setViewName("/admin/support/adminFreeBoardUpdate");
      
      return mav;
   }
   @PostMapping(value = "/admin/support/adminFreeBoardUpdate")
   public ModelAndView freeBoardUpdate(@ModelAttribute AdminSupportDto sp) {
      logger.info("게시판 수정");
      ModelAndView mav = new ModelAndView();
      
      service.adminFreeBoardUpdate(sp);
      
      mav.setViewName("redirect:/admin/support/adminSupport");
      
      return mav;
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   

}