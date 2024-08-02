package com.box.small.user.member;


import com.box.small.admin.admin.AdminDto;
import com.box.small.user.review.ReviewService;
import com.box.small.user.support.SupportService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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

    @GetMapping(value = "loginForm")
    public ModelAndView loginForm() {
        ModelAndView mav = new ModelAndView();
        logger.info("로그인 폼 이동");
        mav.setViewName("user/member/loginForm");

        return mav;
    }

    @PostMapping(value = "login")
    public @ResponseBody Map<String, Object> login(@RequestParam("mem_id") String mem_id, @RequestParam("mem_password") String mem_password, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
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
                map.put("msg", "로그인 성공");
                map.put("location", "/");
            } else {
                session.setAttribute("isLogin", false);
                map.put("msg", "존재하지 않는 아이디 입니다.");
                map.put("location", "/user/loginForm");
            }
        } catch (NullPointerException e) {
            session.setAttribute("isLogin", false);
            map.put("msg", "비밀번호가 틀립니다.");
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
    public ModelAndView detailMember(MemberDto member, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        member = (MemberDto) session.getAttribute("member");
        logger.info("회원상세 폼");
        mav.addObject("reviewList", reviewService.findReview(member));
        mav.addObject("member", memberService.detailMember(member));
        mav.addObject("myBoard", supportService.myBoard(member.getMem_id()));
        mav.setViewName("user/member/detailMember");
        return mav;
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
    @ResponseBody
    public Map<String, Object> selectById(MemberDto member) {
        Map<String, Object> response = new HashMap<>();
        logger.info(member.getMem_name());
        logger.info(member.getMem_phoneNumber());
        try {
            member = memberService.selectById(member);

            if (member == null) {
                logger.error("검색 아이디가 존재하지 않습니다.");
                response.put("msg", "검색 아이디가 존재하지 않습니다.");
                response.put("location", "/user/getByIdOrPwd");
            } else {
                logger.info("Member ID : " + member.getMem_id());
                response.put("msg", "아이디 : " + member.getMem_id());
                response.put("location", "/user/loginForm");
            }
        } catch (Exception e) {
            logger.error("예외 발생", e);
            response.put("msg", "오류가 발생했습니다.");
            response.put("location", "/user/getByIdOrPwd");
        }
        return response;
    }

    @PostMapping(value = "selectByPwd")
    @ResponseBody
    public Map<String, Object> selectByPwd(MemberDto member) {
        Map<String, Object> response = new HashMap<>();
        try {
            member = memberService.selectByPwd(member);

            if (member == null) {
                logger.error("아이디 전화번호의 비밀번호가 존재하지 않습니다.");
                response.put("msg", "아이디 전화번호의 비밀번호가 존재하지 않습니다.");
                response.put("location", "/user/getByIdOrPwd");
            } else {
                logger.info("Member PWD : " + member.getMem_password());
                response.put("msg", "비밀번호 : " + member.getMem_password());
                response.put("location", "/user/loginForm");
            }
        } catch (Exception e) {
            logger.error("예외 발생", e);
            response.put("msg", "오류가 발생했습니다.");
            response.put("location", "/user/getByIdOrPwd");
        }
        return response;
    }

}







