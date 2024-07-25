package com.box.small.admin.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminSupportServiceImpl implements AdminSupportService{

	@Autowired
	private AdminSupportDAO dao;

	@Override
	public List<AdminSupportDto> faq() {
		// TODO Auto-generated method stub
		return dao.faq();
	}

	@Override
	public AdminSupportDto selectFaq(int bo_no) {
		// TODO Auto-generated method stub
		return dao.selectFaq(bo_no);
	}

	@Override
	public List<AdminSupportDto> notice() {
		// TODO Auto-generated method stub
		return dao.notice();
	}

	@Override
	public AdminSupportDto selectNotice(int bo_no) {
		// TODO Auto-generated method stub
		return dao.selectNotice(bo_no);
	}

	@Override
	public int inquiryWrite(AdminSupportDto sp) {
		// TODO Auto-generated method stub
		return dao.inquiryWrite(sp);
	}

	@Override
	public List<AdminSupportDto> inquiryView() {
		// TODO Auto-generated method stub
		return dao.inquiryView();
	}

	@Override
	public int inquiryDelete(int bo_no) {
		// TODO Auto-generated method stub
		return dao.inquiryDelete(bo_no);
	}

	@Override
	public int freeBoardWrite(AdminSupportDto sp) {
		// TODO Auto-generated method stub
		return dao.freeBoardWrite(sp);
	}

	@Override
	public AdminSupportDto selectFreeBoardWrite(int bo_no) {	
		// TODO Auto-generated method stub
		return dao.selectFreeBoardWrite(bo_no);
	}

	@Override
	public List<AdminSupportDto> freeBoard() {
		// TODO Auto-generated method stub
		return dao.freeBoard();
	}

	@Override
	public int freeBoardUpdate(AdminSupportDto sp) {
		// TODO Auto-generated method stub
		return dao.freeBoardUpdate(sp);
	}

	@Override
	public int freeBoardDelete(AdminSupportDto sp) {
		// TODO Auto-generated method stub
		return dao.freeBoardDelete(sp);
	}

	@Override
	public List<AdminSupportDto> myBoard() {
		// TODO Auto-generated method stub
		return dao.myBoard();
	}
	
	

}
