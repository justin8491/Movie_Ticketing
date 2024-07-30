package com.box.small.user.movie;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
	public MovieDto selectMovie(int mo_no) throws SQLException {
		return sqlSession.selectOne(namespace+".selectMovie",mo_no);
	}

	@Override
	public String category(int cat_no) {
		return sqlSession.selectOne(namespace+".selectCategory", cat_no);
	}

	@Override
	public List<CategoryDto> allCategory() {
		return sqlSession.selectList(namespace+".selectAllCategory");
	}

	@Override
	public MovieLikeDto insertOrUpdateMovieLike(MovieLikeDto ml) {
		return sqlSession.selectOne(namespace + ".insertOrUpdateMovieLike");
	}

}
