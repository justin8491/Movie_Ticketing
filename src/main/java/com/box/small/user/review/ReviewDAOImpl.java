package com.box.small.user.review;


import com.box.small.user.movie.MovieDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewDAOImpl implements ReviewDAO {

    @Autowired
    SqlSession sqlSession;
    String SQL_NAME_SAPCE = "com.box.small.mappers.reviewMapper.";

    @Override
    public List<ReviewDto> reviewAll(int mo_no) {
        return sqlSession.selectList(SQL_NAME_SAPCE + "reviewAll", mo_no);
    }

    @Override
    public int createReview(ReviewDto review) {
        return sqlSession.insert(SQL_NAME_SAPCE + "createReview", review);
    }

    @Override
    public int updateReview(ReviewDto review) {
        return sqlSession.update(SQL_NAME_SAPCE + "updateReview", review);
    }

    @Override
    public int deleteReview(ReviewDto review) {
        return sqlSession.delete(SQL_NAME_SAPCE + "deleteReview", review);
    }
}
