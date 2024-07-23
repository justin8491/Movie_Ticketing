package com.box.small.user.member;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/*")
public class MemberController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    MemberService memberService;

//    @GetMapping(value = "home")
//    public ModelAndView main() {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("home");
//        return mav;
//    }

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
    public ModelAndView updateMember(MemberDto member) {
        ModelAndView mav = new ModelAndView();
        memberService.updateMember(member);
        mav.setViewName("redirect:detailMember");
        return mav;
    }

    @PostMapping(value = "deleteMember")
    public ModelAndView deleteMember(MemberDto member, HttpSession session){
            ModelAndView mav = new ModelAndView();
            memberService.deleteMember(member.getMem_id());
            session.invalidate();
            mav.setViewName("redirect:/");
            return mav;
        }
}







