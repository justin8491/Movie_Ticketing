package com.box.small.user.review;


import com.box.small.HomeController;
import com.box.small.user.movie.MovieDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user/movie/*")
public class ReviewController {

    private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

    @Autowired
    ReviewService reviewService;

    @PostMapping(value = "createReview")
    public @ResponseBody Map<String, Object> createReview(ReviewDto review) {
        ModelAndView mav = new ModelAndView();
        reviewService.createReview(review);
        Map<String, Object> map = new HashMap<>();
        map.put("review", review);
        map.put("location", "/user/movie/detailMovie?mo_no=" + review.getMo_no());
        logger.info("Movie No : " + review.getMo_no());
        return map;
    }

    //    @GetMapping(value = "reviewAll")
//    public ModelAndView reviewAll(MovieDto movie) {
//        ModelAndView mav = new ModelAndView();
//        List<ReviewDto> reviewList = reviewService.reviewAll(movie);
//        mav.addObject("reviews", reviewList);
//        mav.setViewName("user/review/reviewList");
//        return mav;
//    }


    @PostMapping(value = "updateReview")
    public @ResponseBody Map<String, Object> updateReview(ReviewDto review) {
        reviewService.updateReview(review);
        Map<String, Object> map = new HashMap<>();
        System.out.println(review.getMo_no());
        map.put("review", review);
        map.put("location", "/user/movie/detailMovie?mo_no=" + review.getMo_no());
        logger.info("Movie No : " + review.getMo_no());
        return map;
    }

    @PostMapping(value = "deleteReview")
    public @ResponseBody Map<String, Object> deleteReview(ReviewDto review) {
        reviewService.deleteReview(review);
        Map<String, Object> map = new HashMap<>();
        map.put("review", review);
        map.put("location", "/user/movie/detailMovie?mo_no=" + review.getMo_no());
        logger.info("Movie No : " + review.getMo_no());
        return map;
    }


}
