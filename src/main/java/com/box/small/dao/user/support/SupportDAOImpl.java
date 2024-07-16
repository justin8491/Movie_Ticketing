package com.box.small.dao.user.support;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.box.small.dto.Support;

@Repository
public class SupportDAOImpl implements SupportDAO{

	@Autowired
	private SqlSession sqlSession;
	
	private final static String nameSpace = "com.box.small.supportMapper"; 
	
	@Override
	public List<Support> faq() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".faq");
	}

	@Override
	public Support selectFaq(int bo_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+".selectFaq", bo_no);
	}

	@Override
	public List<Support> notice() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".notice");
	}

	@Override
	public Support selectNotice(int bo_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+".selectNotice", bo_no);
	}

	@Override
	public int inquiryWrite(Support sp) {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace+".inquiryWrite", sp);
	}

	@Override
	public List<Support> inquiryView() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".inquiryView");
	}

	@Override
	public int inquiryDelete(int bo_no) {
		// TODO Auto-generated method stub
		return sqlSession.delete(nameSpace+".inquiryDelete", bo_no);
	}

	@Override
	public int freeBoardWrite(Support sp) {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace+".freeBoardWrite", sp);
	}

	@Override
	public Support selectFreeBoardWrite(int bo_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+".selectFreeBoardWrite", bo_no);
	}

	@Override
	public List<Support> freeBoard() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".freeBoard");
	}

}
