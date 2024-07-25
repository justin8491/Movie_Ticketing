package com.box.small.admin.support;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AdminSupportDAOImpl implements AdminSupportDAO{

	@Autowired
	private SqlSession sqlSession;
	
	private final static String nameSpace = "com.box.small.supportMapper"; 
	
	@Override
	public List<AdminSupportDto> faq() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".faq");
	}

	@Override
	public AdminSupportDto selectFaq(int bo_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+".selectFaq", bo_no);
	}

	@Override
	public List<AdminSupportDto> notice() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".notice");
	}

	@Override
	public AdminSupportDto selectNotice(int bo_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+".selectNotice", bo_no);
	}

	@Override
	public int inquiryWrite(AdminSupportDto sp) {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace+".inquiryWrite", sp);
	}

	@Override
	public List<AdminSupportDto> inquiryView() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".inquiryView");
	}

	@Override
	public int inquiryDelete(int bo_no) {
		// TODO Auto-generated method stub
		return sqlSession.delete(nameSpace+".inquiryDelete", bo_no);
	}

	@Override
	public int freeBoardWrite(AdminSupportDto sp) {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace+".freeBoardWrite", sp);
	}

	@Override
	public AdminSupportDto selectFreeBoardWrite(int bo_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+".selectFreeBoardWrite", bo_no);
	}

	@Override
	public List<AdminSupportDto> freeBoard() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".freeBoard");
	}

	@Override
	public int freeBoardUpdate(AdminSupportDto sp) {
		// TODO Auto-generated method stub
		return sqlSession.update(nameSpace+".freeBoardUpdate", sp);
	}

	@Override
	public int freeBoardDelete(AdminSupportDto sp) {
		// TODO Auto-generated method stub
		return sqlSession.delete(nameSpace+".freeBoardDelete", sp);
	}

	@Override
	public List<AdminSupportDto> myBoard() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".myBoard");
	}

	

}
