package com.box.small.user.review;


import com.box.small.user.member.MemberDto;
import com.box.small.user.movie.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements  ReviewService{

    @Autowired
    ReviewDAO dao;
    @Override
    public List<ReviewDto> reviewAll(int mo_no) {
        return dao.reviewAll(mo_no);
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

    @Override
    public List<ReviewMNDto> findReview(MemberDto member) {
        return dao.findReview(member);
    }
}
