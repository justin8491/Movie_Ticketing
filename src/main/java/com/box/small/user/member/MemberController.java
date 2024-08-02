package com.box.small.user.member;


import com.box.small.user.movie.MovieDto;
import com.box.small.user.movie.MovieService;
import com.box.small.user.payment.PaymentService;
import com.box.small.user.reservation.ReservationDataListDto;
import com.box.small.user.reservation.ReservationDto;
import com.box.small.user.reservation.ReservationService;
import com.box.small.user.review.ReviewService;
import com.box.small.user.schedule.ScheduleDto;
import com.box.small.user.schedule.ScheduleService;
import com.box.small.user.schedule.ScreenDto;
import com.box.small.user.support.SupportService;
import com.box.small.user.theater.TheaterDto;
import com.box.small.user.theater.TheaterService;
import com.box.small.user.theaterseat.TheaterseatDto;
import com.box.small.user.theaterseat.TheaterseatService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/*")
public class MemberController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    MemberService memberService;

    @Autowired
    ReviewService reviewService;
    
    @Autowired
    SupportService supportService;
    
    @Autowired
	private MovieService movieService;
	@Autowired
	private TheaterService theaterService;
	@Autowired
	private TheaterseatService theartseatService;
	@Autowired
	private ScheduleService scheduleService;
	
	//test용
	@Autowired
	private ReservationService reservationService;
	@Autowired
	private PaymentService payService;



    @GetMapping(value = "loginForm")
    public ModelAndView loginForm() {
        ModelAndView mav = new ModelAndView();
        logger.info("로그인 폼 이동");
        mav.setViewName("user/member/loginForm");

        return mav;
    }

    @PostMapping(value = "login")
    public @ResponseBody Map<String, Object> login(@RequestParam("mem_id") String mem_id, @RequestParam("mem_password") String mem_password, HttpSession session) {
        Map<String,Object> map = new HashMap<>();
//        ModelAndView mav = new ModelAndView();
        logger.info("로그인 프로세스");
        try {
            MemberDto member = new MemberDto();
            member.setMem_id(mem_id);
            member.setMem_password(mem_password);
            member = memberService.login(member);
            if (member != null) {
                session.setAttribute("member", member);
                session.setAttribute("isLogin", true);
                session.setAttribute("type", "user");
                map.put("msg","로그인 성공");
                map.put("location","/");
            } else {
                session.setAttribute("isLogin", false);
                map.put("msg","존재하지 않는 아이디 입니다.");
                map.put("location", "/user/loginForm");
            }
        } catch (NullPointerException e) {
            session.setAttribute("isLogin", false);
            map.put("msg","비밀번호가 틀립니다.");
            map.put("location", "/user/loginForm");
        }
        return map;
    }

    @GetMapping(value = "logout")
    public ModelAndView logout(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        session.invalidate();
        mav.setViewName("redirect:/");
        return mav;
    }


    @GetMapping(value = "createMemberForm")
    public ModelAndView createMemberForm() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/member/createMember");
        return mav;
    }

    @PostMapping(value = "findId")
    public @ResponseBody String findId(MemberDto member) {
        member = memberService.findId(member);
        if (member != null && !member.getMem_id().isEmpty()) {
            return "1"; // 중복된 아이디
        } else {
            return "0"; // 사용 가능한 아이디
        }
    }


    @PostMapping(value = "createMember")
    public ModelAndView createMemeber(MemberDto member) {
        ModelAndView mav = new ModelAndView();
        memberService.createMember(member);
        mav.setViewName("redirect:/");
        return mav;
    }

    @GetMapping(value = "detailMember")
    public ModelAndView detailMember(MemberDto member, HttpSession session) throws SQLException {
        ModelAndView mav = new ModelAndView();
        member = (MemberDto) session.getAttribute("member");
        logger.info("회원상세 폼");
        mav.addObject("reviewList", reviewService.findReview(member));
        mav.addObject("member", memberService.detailMember(member));
        mav.addObject("myBoard", supportService.myBoard(member.getMem_id()));
        System.out.println(member.getMem_id());
        //김도현
    	List<ReservationDto> reservationList = reservationService.reservationList(member.getMem_id());
    	System.out.println(reservationList);
		List<MovieDto> movieList = movieService.selectAllMovie();
		List<ScheduleDto> schedeuleList = scheduleService.selectAllSchedule();
		List<TheaterDto> theaterList = theaterService.selectAllTheater();
		List<ScreenDto> screenList = scheduleService.selectAllScreen();
		List<TheaterseatDto> theaterseatList = theartseatService.seatListAll();
		List<ReservationDataListDto> dataList = new ArrayList<>();
		dataList.add(new ReservationDataListDto(reservationList,movieList,schedeuleList,theaterList,screenList,theaterseatList));
		
		mav.addObject("dataList", dataList);
        
        
        mav.setViewName("user/member/detailMember");
        return mav;
    }
    
    @ResponseBody
	@PostMapping(value="detailMember", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<ReservationDataListDto> cancelReservation(@RequestBody Map<String, Object> params, HttpSession session) throws SQLException {
        
    	ModelAndView mav = new ModelAndView();
    	MemberDto member = (MemberDto) session.getAttribute("member");
        logger.info("회원상세 폼");
        mav.addObject("reviewList", reviewService.findReview(member));
        mav.addObject("member", memberService.detailMember(member));
    	
    	reservationService.cancelReservation(params);
		ReservationDto reservationDto =  reservationService.selectReservation(params);
		payService.canclePayment(params);	
		int ts_no = reservationDto.getTs_no();
		params.put("ts_no", ts_no);
		theartseatService.cancelSeat(params);
		
		String mem_id = "test"; 
		List<ReservationDto> reservationList = reservationService.reservationList(mem_id);
		List<MovieDto> movieList = movieService.selectAllMovie();
		List<ScheduleDto> schedeuleList = scheduleService.selectAllSchedule();
		List<TheaterDto> theaterList = theaterService.selectAllTheater();
		List<TheaterseatDto> theaterseatList = theartseatService.seatListAll();
		List<ReservationDataListDto> dataList = new ArrayList<>();
		List<ScreenDto> screenList = scheduleService.selectAllScreen();
		dataList.add(new ReservationDataListDto(reservationList,movieList,schedeuleList,theaterList,screenList,theaterseatList));
		return dataList;
	}
    

    @GetMapping(value = "updateMemberForm")
    public ModelAndView updateMemberForm(MemberDto member, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        member = (MemberDto) session.getAttribute("member");
        logger.info("회원수정 이동");
        mav.addObject("member", memberService.detailMember(member));
        mav.setViewName("user/member/updateMember");
        return mav;
    }

    @PostMapping(value = "updateMember")
    public ModelAndView updateMember(MemberDto member, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        session.getAttribute("member");
        memberService.updateMember(member);
        mav.setViewName("redirect:detailMember");
        return mav;
    }

    @GetMapping(value = "deleteMember")
    public ModelAndView deleteMember(MemberDto member, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        memberService.deleteMember(member);
        session.invalidate();
        mav.setViewName("redirect:/");
        return mav;
    }

    @GetMapping(value = "getByIdOrPwd")
    public ModelAndView getByIdOrPwd() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/member/getByIdForm");
        return mav;
    }

    @PostMapping(value = "selectById")
    public ModelAndView selectById(MemberDto member) {
        ModelAndView mav = new ModelAndView();
        logger.info(member.getMem_name());
        logger.info(member.getMem_phoneNumber());
        try {
            member = memberService.selectById(member);
            logger.info("Member ID : " + member.getMem_id());
            mav.addObject("msg_title", "아이디찾기");
            mav.addObject("req", member.getMem_id());
        } catch (NullPointerException e) {
            logger.error("검색 아이디가 존재하지 않습니다.");
            mav.addObject("msg_title", "아이디찾기");
            mav.addObject("req", "검색 아이디가 존재하지 않습니다.");
        }
        mav.setViewName("user/member/loginForm");
        return mav;
    }

    @PostMapping(value = "selectByPwd")
    public ModelAndView selectByPwd(MemberDto member) {
        ModelAndView mav = new ModelAndView();
        try {
            member = memberService.selectByPwd(member);
            logger.info("Member PWD : " + member.getMem_password());
            mav.addObject("req", member.getMem_password());
            mav.addObject("msg_title", "비밀번호찾기");
        } catch (NullPointerException e) {
            mav.addObject("msg_title", "비밀번호찾기");
            mav.addObject("req", "아이디 전화번호의 비밀번호가 존재하지 않습니다.");
        }
        mav.setViewName("user/member/loginForm");
        return mav;
    }
}







