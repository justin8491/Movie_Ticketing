package com.box.small.user.member;


import com.box.small.user.review.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/*")
public class MemberController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    MemberService memberService;

    @Autowired
    ReviewService reviewService;



    @GetMapping(value = "loginForm")
    public ModelAndView loginForm() {
        ModelAndView mav = new ModelAndView();
        logger.info("로그인 폼 이동");
        mav.setViewName("user/member/loginForm");

        return mav;
    }

    @PostMapping("login")
    public ModelAndView login(MemberDto member, HttpSession session, RedirectAttributes redirectAttributes) {
        ModelAndView mav = new ModelAndView();
        logger.info("로그인 프로세스");
        try {
            member = memberService.login(member);
            if (member != null) {
                redirectAttributes.addFlashAttribute("loginMessage", "로그인 성공");
                session.setAttribute("member", member);
                session.setAttribute("isLogin", true);
                session.setAttribute("type", "user");
                mav.setViewName("redirect:/");
            }
        } catch (NullPointerException e) {
            redirectAttributes.addFlashAttribute("loginMessage", "로그인 실패");
            mav.setViewName("user/member/loginForm");
        }
        return mav;
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







