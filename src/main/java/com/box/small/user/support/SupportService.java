package com.box.small.user.support;

import java.util.List;


public interface SupportService {

//   자주 묻는 질문 리스트 보여주기
   List<SupportDto> faq();
   
//   자주 묻는 질문 상세 페이지
   SupportDto selectFaq(int bo_no);
   
//   공지사항 리스트 보여주기
   List<SupportDto> notice();
   
//   공지사항 상위 4개 리스트 보여주기
   List<SupportDto> noticeTop4List();
   
//   공지사항 상세 페이지
   SupportDto selectNotice(int bo_no);
   
//   1대1 문의 페이지 작성
   int inquiryWrite(SupportDto sp);
   
//   1대1 문의 리스트 보여주기
   List<SupportDto> inquiryView();
   
//   1대1 문의 삭제
   int inquiryDelete(int bo_no);
   
//   자유게시판 작성
   int freeBoardWrite(SupportDto sp);
   
//   자유게시판 상세 페이지
   SupportDto selectFreeBoardWrite(int bo_no);
   
//   자유게시판 리스트 보여주기
   List<SupportDto> freeBoard();
   
//   자유게시판 수정
   int freeBoardUpdate(SupportDto sp);
   
//   자유게시판 삭제
   int freeBoardDelete(SupportDto sp);
   
//   내가 쓴 글 조회
   List<SupportDto> myBoard(String bo_writerId);
   
}
