package com.box.small.user.movie;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDAOImpl implements MovieDAO{
	
	private final static String namespace="com.box.small.movieMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<MovieDto> selectAllMovie() throws SQLException {
		return sqlSession.selectList(namespace+".selectAllMovie");
	}

	@Override	
	public MovieDto selectMovie(int mo_id) throws SQLException {
		return sqlSession.selectOne(namespace+".selectMovie",mo_id);
	}

}
