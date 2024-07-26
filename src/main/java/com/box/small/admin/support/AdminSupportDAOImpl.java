package com.box.small.admin.support;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AdminSupportDAOImpl implements AdminSupportDAO{

	@Autowired
	private SqlSession sqlSession;
	
	private final static String nameSpace = "com.box.small.adminSupportMapper"; 
	
	@Override
	public List<AdminSupportDto> adminFaq() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".adminFaq");
	}

	@Override
	public AdminSupportDto adminSelectFaq(int bo_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+".adminSelectFaq", bo_no);
	}

	@Override
	public List<AdminSupportDto> adminNotice() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".adminNotice");
	}

	@Override
	public AdminSupportDto adminSelectNotice(int bo_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+".adminSelectNotice", bo_no);
	}

	@Override
	public int adminInquiryWrite(AdminSupportDto sp) {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace+".adminInquiryWrite", sp);
	}

	@Override
	public List<AdminSupportDto> adminInquiry() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".adminInquiry");
	}

	@Override
	public int adminInquiryDelete(int bo_no) {
		// TODO Auto-generated method stub
		return sqlSession.delete(nameSpace+".adminInquiryDelete", bo_no);
	}

	@Override
	public int adminBoardAdd(AdminSupportDto sp) {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace+".adminBoardAdd", sp);
	}

	@Override
	public AdminSupportDto adminSelectFreeBoardWrite(int bo_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+".adminSelectFreeBoardWrite", bo_no);
	}

	@Override
	public List<AdminSupportDto> adminFreeBoard() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".adminFreeBoard");
	}

	@Override
	public int adminFreeBoardUpdate(AdminSupportDto sp) {
		// TODO Auto-generated method stub
		return sqlSession.update(nameSpace+".adminFreeBoardUpdate", sp);
	}

	@Override
	public int adminFreeBoardDelete(AdminSupportDto sp) {
		// TODO Auto-generated method stub
		return sqlSession.delete(nameSpace+".adminFreeBoardDelete", sp);
	}

	@Override
	public List<AdminSupportDto> adminMyBoard() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".adminMyBoard");
	}

	

}
