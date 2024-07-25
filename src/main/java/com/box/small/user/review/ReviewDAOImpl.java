package com.box.small.user.review;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewDAOImpl implements ReviewDAO {

    @Autowired
    SqlSession sqlSession;
    String SQL_NAME_SAPCE = "com.box.small.reviewMapper.";

    @Override
    public List<ReviewDto> reviewAll() {
        return sqlSession.selectList(SQL_NAME_SAPCE + "reviewAll");
    }

    @Override
    public int createReview(ReviewDto review) {
        return sqlSession.insert(SQL_NAME_SAPCE + "createReview",review);
    }

    @Override
    public int updateReview(ReviewDto review) {
        return 0;
    }

    @Override
    public int deleteReview(ReviewDto review) {
        return 0;
    }
}
