package com.box.small.admin.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminSupportServiceImpl implements AdminSupportService{

	@Autowired
	private AdminSupportDAO dao;

	@Override
	public List<AdminSupportDto> adminFaq() {
		// TODO Auto-generated method stub
		return dao.adminFaq();
	}

	@Override
	public AdminSupportDto adminSelectFaq(int bo_no) {
		// TODO Auto-generated method stub
		return dao.adminSelectFaq(bo_no);
	}

	@Override
	public List<AdminSupportDto> adminNotice() {
		// TODO Auto-generated method stub
		return dao.adminNotice();
	}

	@Override
	public AdminSupportDto adminSelectNotice(int bo_no) {
		// TODO Auto-generated method stub
		return dao.adminSelectNotice(bo_no);
	}

	@Override
	public int adminInquiryWrite(AdminSupportDto sp) {
		// TODO Auto-generated method stub
		return dao.adminInquiryWrite(sp);
	}

	@Override
	public List<AdminSupportDto> adminInquiry() {
		// TODO Auto-generated method stub
		return dao.adminInquiry();
	}

	@Override
	public int adminInquiryDelete(int bo_no) {
		// TODO Auto-generated method stub
		return dao.adminInquiryDelete(bo_no);
	}

	@Override
	public int adminBoardAdd(AdminSupportDto sp) {
		// TODO Auto-generated method stub
		return dao.adminBoardAdd(sp);
	}

	@Override
	public AdminSupportDto adminSelectFreeBoardWrite(int bo_no) {
		// TODO Auto-generated method stub
		return dao.adminSelectFreeBoardWrite(bo_no);
	}

	@Override
	public List<AdminSupportDto> adminFreeBoard() {
		// TODO Auto-generated method stub
		return dao.adminFreeBoard();
	}

	@Override
	public int adminFreeBoardUpdate(AdminSupportDto sp) {
		// TODO Auto-generated method stub
		return dao.adminFreeBoardUpdate(sp);
	}

	@Override
	public int adminFreeBoardDelete(AdminSupportDto sp) {
		// TODO Auto-generated method stub
		return dao.adminFreeBoardDelete(sp);
	}

	@Override
	public List<AdminSupportDto> adminMyBoard() {
		// TODO Auto-generated method stub
		return dao.adminMyBoard();
	}

	
	
	

}
