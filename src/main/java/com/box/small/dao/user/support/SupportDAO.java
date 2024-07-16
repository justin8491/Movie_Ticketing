package com.box.small.dao.user.support;

import java.util.List;

import com.box.small.dto.Support;

public interface SupportDAO {
//	자주 묻는 질문 리스트 보여주기
	List<Support> faq();
	
//	자주 묻는 질문 상세 페이지
	Support selectFaq(int bo_no);
	
//	공지사항 리스트 보여주기
	List<Support> notice();
	
//	공지사항 상세 페이지
	Support selectNotice(int bo_no);
	
//	1대1 문의 페이지 작성
	int inquiryWrite(Support sp);
	
//	1대1 문의 리스트 보여주기
	List<Support> inquiryView();
	
//	1대1 문의 삭제
	int inquiryDelete(int bo_no);
	
//	자유게시판 작성
	int freeBoardWrite(Support sp);
	
//	자유게시판 상세 페이지
	Support selectFreeBoardWrite(int bo_no);
	
//	자유게시판 리스트 보여주기
	List<Support> freeBoard();
	
	
}
