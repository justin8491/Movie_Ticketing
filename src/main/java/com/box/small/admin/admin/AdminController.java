package com.box.small.admin.admin;


import com.box.small.user.member.MemberDto;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    AdminService adminService;


    @GetMapping(value = "loginForm")
    public ModelAndView adminLoginForm() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("admin/admin/login");
        return mav;
    }

    @PostMapping(value = "login")
    public @ResponseBody Map<String, Object> adminLogin(@RequestParam("a_id") String a_id, @RequestParam("a_password") String a_password, HttpSession session, RedirectAttributes redirectAttributes) {
        Map<String, Object> map = new HashMap<>();
//        ModelAndView mav = new ModelAndView();
        try {
            AdminDto admin = new AdminDto();
            admin.setA_id(a_id);
            admin.setA_password(a_password);
            admin = adminService.login(admin);
            if (admin != null) {
                session.setAttribute("admin", admin);
                session.setAttribute("isLogin", true);
                session.setAttribute("type", "admin");
//              mav.addObject("memberList", memberList);
//              mav.setViewName("/homeAdmin_beta");
                map.put("msg", "로그인 성공");
                map.put("location", "/admin");
            } else {
                session.setAttribute("isLogin", false);
                map.put("msg", "로그인 실패");
                map.put("location", "/admin/loginForm");
            }
        } catch (NullPointerException e) {
            session.setAttribute("isLogin", false);
            map.put("msg","비밀번호가 틀립니다.");
            map.put("location", "/admin/loginForm");
        }
//        return mav;
        return map;
    }

    @GetMapping(value = "selectAllMember")
    public ModelAndView selectAllMember() {
        ModelAndView mav = new ModelAndView();
        List<MemberDto> memberList = adminService.selectAllMember();
        mav.addObject("memberList", memberList);
        mav.setViewName("/admin");
        return mav;
    }


    @GetMapping(value = "logout")
    public ModelAndView logout(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        session.invalidate();
        mav.setViewName("redirect:/");
        return mav;
    }


}







