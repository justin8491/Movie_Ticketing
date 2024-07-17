package com.box.small.user.theater;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TheaterDAOImpl implements TheaterDAO{
	private final static String namespace = "com.box.small.theaterMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<TheaterDto> sellectAlltheater() throws SQLException {
		return sqlSession.selectList(namespace+".selectAllTheater");
	}

	@Override
	public TheaterDto sellectTheater(int th_no) throws SQLException {
		return sqlSession.selectOne(namespace+".selectTheater",th_no);
	}
	
}
