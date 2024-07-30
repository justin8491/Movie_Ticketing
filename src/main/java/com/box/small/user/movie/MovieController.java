package com.box.small.user.movie;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.box.small.user.member.MemberDto;
import com.box.small.user.review.ReviewController;
import com.box.small.user.review.ReviewDto;
import com.box.small.user.review.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService service;

    @Autowired
    private ReviewService reviewService;

    @GetMapping(value = "/user/movie/movieList")
    public ModelAndView selectAllmovie() throws SQLException {

        ModelAndView mav = new ModelAndView();

        List<MovieDto> movielist = service.selectAllMovie();

        List<CategoryDto> category = service.allCategory();
        mav.addObject("movielist", movielist);
        mav.addObject("category", category);

        mav.setViewName("/user/movie/movieList");
        return mav;
    }

    @GetMapping(value = "/user/movie/detailMovie")
    public ModelAndView selectMovie(@RequestParam("mo_no") int mo_no, HttpSession session, MovieLikeDto ml) throws SQLException {

        ModelAndView mav = new ModelAndView();
        MovieDto movie = service.selectMovie(mo_no);
        String cat_name = service.category(movie.getCat_no());
        List<ReviewDto> reviewList = reviewService.reviewAll(mo_no);
        logger.info("Movie_No : " + mo_no);

        try {
            boolean isLogin = (boolean) session.getAttribute("isLogin");

            if (isLogin == true) {
                MemberDto member = (MemberDto) session.getAttribute("member");
                logger.info("Member_id : " + member.getMem_id());
                // 영화 좋아요
                ml.setMo_no(mo_no);
                ml.setMem_id(member.getMem_id());
                System.out.println(ml);
//                ml = service.insertOrUpdateMovieLike(ml);
                mav.addObject("ml_status", ml.getMl_status());

                // 리뷰리스트
                mav.addObject("reviewList", reviewList);

                // 영화
                mav.addObject("cat_name", cat_name);
                mav.addObject("movie", movie);
                mav.setViewName("/user/movie/detailMovie");
            }


        } catch (NullPointerException e) {
            logger.info("비회원 상태");
            // 리뷰리스트
            mav.addObject("reviewList", reviewList);

            mav.addObject("cat_name", cat_name);
            mav.addObject("movie", movie);
            mav.setViewName("/user/movie/detailMovie");
        }

        return mav;
    }

}
