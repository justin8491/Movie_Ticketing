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
	public List<MovieDto> selectAllMovieLive() throws SQLException {
		return sqlSession.selectList(namespace+".selectAllMovieLive");
	}

    private final static String namespace = "com.box.small.movieMapper";

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<MovieDto> selectAllMovie() throws SQLException {
        return sqlSession.selectList(namespace + ".selectAllMovie");
    }

    @Override
    public MovieDto selectMovie(int mo_no) throws SQLException {
        return sqlSession.selectOne(namespace + ".selectMovie", mo_no);
    }

    @Override
    public String category(int cat_no) {
        return sqlSession.selectOne(namespace + ".selectCategory", cat_no);
    }

    @Override
    public List<CategoryDto> allCategory() {
        return sqlSession.selectList(namespace + ".selectAllCategory");
    }

    @Override
    public boolean checkMovieLike(MovieLikeDto ml) {
        return sqlSession.selectOne(namespace + ".checkMovieLike", ml);
    }

    @Override
    public int insertMovieLike(MovieLikeDto ml) {
        return sqlSession.insert(namespace + ".insertMovieLike", ml);
    }

    @Override
    public int updateMovieLike(MovieLikeDto ml) {
        System.out.println("Update ML mem_id : " + ml.getMem_id());
        System.out.println("Update ML mo_no : " + ml.getMo_no());
        return sqlSession.update(namespace + ".updateMovieLike", ml);
    }

    @Override
    public MovieLikeDto MovieLikeStatus(MovieLikeDto ml) {
        return sqlSession.selectOne(namespace + ".MovieLikeStatus", ml);
    }


}
