package com.box.small.controller.user.member;

import com.box.small.dto.Member;
import com.box.small.service.user.member.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/*")
public class MemberController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    MemberService memberService;

    @GetMapping(value = "main")
    public ModelAndView main(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("main");
        return mav;
    }

    @GetMapping(value = "loginForm")
    public ModelAndView loginForm() {
        ModelAndView mav = new ModelAndView();
        logger.info("로그인 폼 이동");
        mav.setViewName("user/member/loginForm");

        return mav;
    }

    @PostMapping(value = "login")
    public ModelAndView login(Member member, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        logger.info("로그인 프로세스");
        logger.info("Member Id : " + member.getMem_id());
        logger.info("Member Pwd : " + member.getMem_password());

        member = memberService.login(member);
        if(member == null){
            mav.addObject("msg","로그인 실패");
        } else if(member != null ) {
            mav.addObject("msg", "로그인 성공");
            session.setAttribute("user",member);
            mav.setViewName("main");
        }
        return mav;
    }

}







