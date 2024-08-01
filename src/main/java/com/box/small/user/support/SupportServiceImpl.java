package com.box.small.user.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupportServiceImpl implements SupportService{

   @Autowired
   private SupportDAO dao;

   @Override
   public List<SupportDto> faq() {
      // TODO Auto-generated method stub
      return dao.faq();
   }

   @Override
   public SupportDto selectFaq(int bo_no) {
      // TODO Auto-generated method stub
      return dao.selectFaq(bo_no);
   }

   @Override
   public List<SupportDto> notice() {
      // TODO Auto-generated method stub
      return dao.notice();
   }

   @Override
   public SupportDto selectNotice(int bo_no) {
      // TODO Auto-generated method stub
      return dao.selectNotice(bo_no);
   }

   @Override
   public int inquiryWrite(SupportDto sp) {
      // TODO Auto-generated method stub
      return dao.inquiryWrite(sp);
   }

   @Override
   public List<SupportDto> inquiryView() {
      // TODO Auto-generated method stub
      return dao.inquiryView();
   }

   @Override
   public int inquiryDelete(int bo_no) {
      // TODO Auto-generated method stub
      return dao.inquiryDelete(bo_no);
   }

   @Override
   public int freeBoardWrite(SupportDto sp) {
      // TODO Auto-generated method stub
      return dao.freeBoardWrite(sp);
   }

   @Override
   public SupportDto selectFreeBoardWrite(int bo_no) {   
      // TODO Auto-generated method stub
      return dao.selectFreeBoardWrite(bo_no);
   }

   @Override
   public List<SupportDto> freeBoard() {
      // TODO Auto-generated method stub
      return dao.freeBoard();
   }

   @Override
   public int freeBoardUpdate(SupportDto sp) {
      // TODO Auto-generated method stub
      return dao.freeBoardUpdate(sp);
   }

   @Override
   public int freeBoardDelete(SupportDto sp) {
      // TODO Auto-generated method stub
      return dao.freeBoardDelete(sp);
   }

   @Override
   public List<SupportDto> myBoard(String bo_writerId) {
      // TODO Auto-generated method stub
      return dao.myBoard(bo_writerId);
   }

   @Override
   public List<SupportDto> noticeTop4List() {
      // TODO Auto-generated method stub
      return dao.noticeTop4List();
   }
   
   

}
