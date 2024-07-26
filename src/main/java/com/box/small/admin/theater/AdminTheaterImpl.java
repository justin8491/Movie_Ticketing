package com.box.small.admin.theater;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.box.small.user.movie.MovieDto;
import com.box.small.user.theater.TheaterDto;

@Repository
public class AdminTheaterImpl implements AdminTheaterDAO{
	@Autowired
	private final static String namespace="com.box.small.adminMovieMapper";
	@Autowired
	private SqlSession sqlSession;
	@Override
	public void addTheater(TheaterDto theater) throws SQLException {
		sqlSession.insert(namespace+".addtheater", theater);		
	}
	@Override
	public void deleteTheater(int th_no) throws SQLException {
		sqlSession.insert(namespace+".deleteTheater", th_no);
	}
	@Override
	public void updateTheater(TheaterDto theater) throws SQLException {
		sqlSession.insert(namespace+".updateTheater", theater);		
	}

}
