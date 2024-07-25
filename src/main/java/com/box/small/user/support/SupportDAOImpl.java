package com.box.small.user.support;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SupportDAOImpl implements SupportDAO{

	@Autowired
	private SqlSession sqlSession;
	
	private final static String nameSpace = "com.box.small.supportMapper"; 
	
	@Override
	public List<SupportDto> faq() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".faq");
	}

	@Override
	public SupportDto selectFaq(int bo_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+".selectFaq", bo_no);
	}

	@Override
	public List<SupportDto> notice() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".notice");
	}

	@Override
	public SupportDto selectNotice(int bo_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+".selectNotice", bo_no);
	}

	@Override
	public int inquiryWrite(SupportDto sp) {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace+".inquiryWrite", sp);
	}

	@Override
	public List<SupportDto> inquiryView() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".inquiryView");
	}

	@Override
	public int inquiryDelete(int bo_no) {
		// TODO Auto-generated method stub
		return sqlSession.delete(nameSpace+".inquiryDelete", bo_no);
	}

	@Override
	public int freeBoardWrite(SupportDto sp) {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace+".freeBoardWrite", sp);
	}

	@Override
	public SupportDto selectFreeBoardWrite(int bo_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+".selectFreeBoardWrite", bo_no);
	}

	@Override
	public List<SupportDto> freeBoard() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".freeBoard");
	}

	@Override
	public int freeBoardUpdate(SupportDto sp) {
		// TODO Auto-generated method stub
		return sqlSession.update(nameSpace+".freeBoardUpdate", sp);
	}

	@Override
	public int freeBoardDelete(SupportDto sp) {
		// TODO Auto-generated method stub
		return sqlSession.delete(nameSpace+".freeBoardDelete", sp);
	}

	@Override
	public List<SupportDto> myBoard() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".myBoard");
	}

	

}
