package com.box.small.user.review;


import com.box.small.user.movie.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RequestMapping("/user/movie/*")
public class ReviewController {

    @Autowired
    ReviewService reviewService;


//    @GetMapping(value = "reviewAll")
//    public ModelAndView reviewAll(MovieDto movie) {
//        ModelAndView mav = new ModelAndView();
//        List<ReviewDto> reviewList = reviewService.reviewAll(movie);
//        mav.addObject("reviews", reviewList);
//        mav.setViewName("user/review/reviewList");
//        return mav;
//    }
//
//
//    @GetMapping(value = "createReview")
//    public ModelAndView createReviewForm() {
//        ModelAndView mav = new ModelAndView();
//
//        mav.setViewName("user/review/createReview");
//        return mav;
//    }
//
//    @PostMapping(value = "createReview")
//    public ModelAndView createReview(ReviewDto review) {
//        ModelAndView mav = new ModelAndView();
//        reviewService.createReview(review);
//        mav.setViewName("user/movie/detail");
//        return mav;
//    }
//
//    @PostMapping(value = "updateReview")
//    public ModelAndView updateReview(ReviewDto review) {
//        ModelAndView mav = new ModelAndView();
//        reviewService.updateReview(review);
//        mav.setViewName("redirect:user/movie/detailMovie");
//        return mav;
//    }
//
//    @PostMapping(value = "deleteReview")
//    public ModelAndView deleteReview(ReviewDto review) {
//        ModelAndView mav = new ModelAndView();
//
//        mav.setViewName("");
//        return mav;
//    }


}
