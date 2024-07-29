package com.box.small.user.review;

import com.box.small.user.member.MemberDto;
import com.box.small.user.movie.MovieDto;

import java.util.List;

public interface ReviewDAO {

    //    리뷰 전체 보기
    List<ReviewDto> reviewAll(int mo_no);

    //    리뷰 추가
    int createReview(ReviewDto review);

    //    리뷰 수정
    int updateReview(ReviewDto review);

    //    리뷰 삭제
    int deleteReview(ReviewDto review);

    // 마이페이지 내 리뷰 보기
    List<ReviewMNDto> findReview(MemberDto member);
}
