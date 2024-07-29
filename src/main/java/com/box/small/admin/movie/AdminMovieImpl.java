package com.box.small.admin.movie;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.box.small.user.movie.MovieDto;

@Repository
public class AdminMovieImpl implements AdminMovieDAO{
	@Autowired
	private final static String namespace="com.box.small.adminMovieMapper";
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void addMovie(MovieDto movie) throws SQLException {	//	영화 추가
		System.out.println("addMovie서비스실행");
		
		
		
		sqlSession.insert(namespace+".addMovie", movie);
	}

	@Override
	public void deleteMovie(int mo_no) throws SQLException {	//	영화 삭제
		sqlSession.update(namespace+".deleteMovie", mo_no);
	}

	@Override
	public void updateMovie(MovieDto movie) throws SQLException {	//	영화 수정
		sqlSession.update(namespace+".updateMovie", movie);
	}

}
