package com.box.small.dao.user.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.box.small.dto.Support;
@Repository
public class SupportServiceImpl implements SupportService{

	@Autowired
	private SupportDAO dao;

	@Override
	public List<Support> faq() {
		// TODO Auto-generated method stub
		return dao.faq();
	}

	@Override
	public Support selectFaq(int bo_no) {
		// TODO Auto-generated method stub
		return dao.selectFaq(bo_no);
	}

	@Override
	public List<Support> notice() {
		// TODO Auto-generated method stub
		return dao.notice();
	}

	@Override
	public Support selectNotice(int bo_no) {
		// TODO Auto-generated method stub
		return dao.selectNotice(bo_no);
	}

	@Override
	public int inquiryWrite(Support sp) {
		// TODO Auto-generated method stub
		return dao.inquiryWrite(sp);
	}

	@Override
	public List<Support> inquiryView() {
		// TODO Auto-generated method stub
		return dao.inquiryView();
	}

	@Override
	public int inquiryDelete(int bo_no) {
		// TODO Auto-generated method stub
		return dao.inquiryDelete(bo_no);
	}

	@Override
	public int freeBoardWrite(Support sp) {
		// TODO Auto-generated method stub
		return dao.freeBoardWrite(sp);
	}

	@Override
	public Support selectFreeBoardWrite(int bo_no) {
		// TODO Auto-generated method stub
		return dao.selectFreeBoardWrite(bo_no);
	}

	@Override
	public List<Support> freeBoard() {
		// TODO Auto-generated method stub
		return dao.freeBoard();
	}
	
	

}
