package com.box.small.admin.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminCommentServiceImpl implements AdminCommentService{
	@Autowired
	private AdminCommentDAO dao;
	
	@Override
	public int adminCommentAdd(AdminCommentDto cDto) {
		// TODO Auto-generated method stub
		return dao.adminCommentAdd(cDto);
	}

	@Override
	public int adminCommentUpdate(AdminCommentDto cDto) {
		// TODO Auto-generated method stub
		return dao.adminCommentUpdate(cDto);
	}

	@Override
	public int adminCommentDelete(int com_no) {
		// TODO Auto-generated method stub
		return dao.adminCommentDelete(com_no);
	}

	@Override
	public List<AdminCommentDto> adminCommentList(int bo_no) {
		// TODO Auto-generated method stub
		return dao.adminCommentList(bo_no);
	}

}
