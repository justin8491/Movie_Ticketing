package com.box.small.admin.support;

import java.util.List;


public interface AdminSupportDAO {
//	자주 묻는 질문 리스트 보여주기
	List<AdminSupportDto> adminFaq();
	
//	자주 묻는 질문 상세 페이지
	AdminSupportDto adminSelectFaq(int bo_no);
	
//	공지사항 리스트 보여주기
	List<AdminSupportDto> adminNotice();
	
//	공지사항 상세 페이지
	AdminSupportDto adminSelectNotice(int bo_no);
	
//	1대1 문의 페이지 작성
	int adminInquiryWrite(AdminSupportDto sp);
	
//	1대1 문의 리스트 보여주기
	List<AdminSupportDto> adminInquiry();
	
//	1대1 문의 삭제
	int adminInquiryDelete(int bo_no);
	
//	자유게시판 작성
	int adminBoardAdd(AdminSupportDto sp);
	
//	자유게시판 상세 페이지
	AdminSupportDto adminSelectFreeBoardWrite(int bo_no);
	
//	자유게시판 리스트 보여주기
	List<AdminSupportDto> adminFreeBoard();
	
//	자유게시판 수정
	int adminFreeBoardUpdate(AdminSupportDto sp);
	
//	자유게시판 삭제
	int adminFreeBoardDelete(AdminSupportDto sp);
	
//	내가 쓴 글 조회
	List<AdminSupportDto> adminMyBoard();
}
