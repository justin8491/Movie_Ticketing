package com.box.small.admin.comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminCommentDAOImpl implements AdminCommentDAO{
	@Autowired
	private SqlSession sqlsession;
	private final static String nameSpace = "com.box.small.adminCommentMapper"; 
	
	@Override
	public int adminCommentAdd(AdminCommentDto cDto) {
		// TODO Auto-generated method stub
		return sqlsession.insert(nameSpace+".adminCommentAdd", cDto);
	}

	@Override
	public int adminCommentUpdate(AdminCommentDto cDto) {
		// TODO Auto-generated method stub
		return sqlsession.update(nameSpace+".commentUpdate", cDto);
	}

	@Override
	public int adminCommentDelete(int com_no) {
		// TODO Auto-generated method stub
		return sqlsession.update(nameSpace+".adminCommentDelete", com_no);
	}

	@Override
	public List<AdminCommentDto> adminCommentList(int bo_no) {
		// TODO Auto-generated method stub
		return sqlsession.selectList(nameSpace+".adminCommentList",bo_no);
	}

}
