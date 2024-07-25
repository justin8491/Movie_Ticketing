package com.box.small.user.review;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user/movie/*")
public class ReviewController {

    @PostMapping(value = "reviewAll")
    public ModelAndView reviewAll() {
        ModelAndView mav = new ModelAndView();


        mav.setViewName("");
        return mav;
    }


}
