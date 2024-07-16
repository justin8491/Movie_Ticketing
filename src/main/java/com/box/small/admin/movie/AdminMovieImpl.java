package com.box.small.admin.movie;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.box.small.user.movie.MovieDto;

public class AdminMovieImpl implements AdminMovieDAO{
	@Autowired
	private final static String namespace="com.box.small.adminMovieMapper";
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void addMovie(MovieDto movie) throws SQLException {	//	영화 추가
		
		sqlSession.insert(namespace+".addMovie", movie);
	}

	@Override
	public void deleteMovie(MovieDto movie) throws SQLException {	//	영화 삭제
		sqlSession.update(namespace+".deleteMovie", movie);
	}

	@Override
	public void updateMovie(MovieDto movie) throws SQLException {	//	영화 수정
		sqlSession.update(namespace+".updateMovie", movie);
	}

}
