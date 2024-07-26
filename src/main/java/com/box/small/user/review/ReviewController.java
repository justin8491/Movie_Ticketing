package com.box.small.user.review;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user/movie/*")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping(value = "reviewAll")
    public ModelAndView reviewAll() {
        ModelAndView mav = new ModelAndView();
        List<ReviewDto> reviewList = reviewService.reviewAll();
        mav.addObject("reviews", reviewList);
        mav.setViewName("user/review/reviewList");
        return mav;
    }


}
