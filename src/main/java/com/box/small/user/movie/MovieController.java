package com.box.small.user.movie;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.box.small.user.member.MemberDto;
import com.box.small.user.review.ReviewDto;
import com.box.small.user.review.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
		
		System.out.println("영화 페이지로 이동");
		ModelAndView mav = new ModelAndView();
		List<MovieDto>movieList = service.selectAllMovieLive();
		List<CategoryDto>category = service.allCategory();
		mav.addObject("movieList", movieList);
		mav.addObject("category",category);
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
            // 로그인 상태 확인
            boolean isLogin = (boolean) session.getAttribute("isLogin");
            if (isLogin == true) { //로그인 이라면
                MemberDto member = (MemberDto) session.getAttribute("member");
                // 아이디 값이 존재 한다면
                ml.setMo_no(mo_no);
                ml.setMem_id(member.getMem_id());
                boolean exists = service.checkMovieLike(ml);
                if (!exists) {// 레코드가 없으면
                    service.insertMovieLike(ml);
                } else {
//                  service.updateMovieLike(ml);
                }
                // 영화 좋아요
                ml = service.MovieLikeStatus(ml);
                mav.addObject("ml_status", ml.getMl_status());
                logger.info("MovieLike > ml_status : " + ml.getMl_status());

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

    @ResponseBody
    @RequestMapping(value = "/user/movie/selectCategory", method = RequestMethod.POST)
    public List<MovieDto> selectCategory(@RequestParam("cat_no") int cat_no) throws SQLException {
        List<MovieDto> data;
        if (cat_no == 0) {
            System.out.println("전체영화를 선택하셨습니다");
            data = service.selectAllMovieLive();
            System.out.println(data);
        } else {
            System.out.println("cat_no 가 "  + cat_no +"인 영화를 선택하셨습니다.");
            data = service.selectMovieCategory(cat_no);
            System.out.println(data);
        }
        return data;
    }


    @PostMapping(value = "/user/movie/updateMovieLike")
    public Map<String, Object> updateMovieLike(@RequestParam("mo_no") int mo_no, HttpSession 		session, MovieLikeDto ml) {
        Map<String, Object> map = new HashMap<>();
        logger.info("영화 좋아요 업데이트");

        // 세션에서 로그인 상태 확인
        Boolean isLogin = (Boolean) session.getAttribute("isLogin");
        if (isLogin == null || !isLogin) {
            logger.warn("User is not logged in.");
            return map; // 로그인하지 않은 경우 빈 맵 반환
        }

        MemberDto member = (MemberDto) session.getAttribute("member");
        logger.info("Member id : " + member.getMem_id());
        logger.info("Movie No : " + mo_no);

        ml.setMem_id(member.getMem_id());
        ml.setMo_no(mo_no);

        service.updateMovieLike(ml);
        map.put("location", "/user/movie/detailMovie?mo_no=" + ml.getMo_no());


        return map;
    }

}
