package com.box.small.user.review;

import java.util.List;

public interface ReviewDAO {

    //    리뷰 전체 보기
    List<ReviewDto> reviewAll();

    //    리뷰 추가
    int createReview(ReviewDto review);

    //    리뷰 수정
    int updateReview(ReviewDto review);

    //    리뷰 삭제
    int deleteReview(ReviewDto review);

}
