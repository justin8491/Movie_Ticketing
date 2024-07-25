package com.box.small.admin.support;

import java.util.List;


public interface AdminSupportService {

//	자주 묻는 질문 리스트 보여주기
	List<AdminSupportDto> faq();
	
//	자주 묻는 질문 상세 페이지
	AdminSupportDto selectFaq(int bo_no);
	
//	공지사항 리스트 보여주기
	List<AdminSupportDto> notice();
	
//	공지사항 상세 페이지
	AdminSupportDto selectNotice(int bo_no);
	
//	1대1 문의 페이지 작성
	int inquiryWrite(AdminSupportDto sp);
	
//	1대1 문의 리스트 보여주기
	List<AdminSupportDto> inquiryView();
	
//	1대1 문의 삭제
	int inquiryDelete(int bo_no);
	
//	자유게시판 작성
	int freeBoardWrite(AdminSupportDto sp);
	
//	자유게시판 상세 페이지
	AdminSupportDto selectFreeBoardWrite(int bo_no);
	
//	자유게시판 리스트 보여주기
	List<AdminSupportDto> freeBoard();
	
//	자유게시판 수정
	int freeBoardUpdate(AdminSupportDto sp);
	
//	자유게시판 삭제
	int freeBoardDelete(AdminSupportDto sp);
	
//	내가 쓴 글 조회
	List<AdminSupportDto> myBoard();
	
}
