package com.box.small.user.review;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements  ReviewService{

    @Autowired
    ReviewDAO dao;
    @Override
    public List<ReviewDto> reviewAll() {
        return dao.reviewAll();
    }

    @Override
    public int createReview(ReviewDto review) {
        return dao.createReview(review);
    }

    @Override
    public int updateReview(ReviewDto review) {
        return dao.updateReview(review);
    }

    @Override
    public int deleteReview(ReviewDto review) {
        return dao.deleteReview(review);
    }
}
