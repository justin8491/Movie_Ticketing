package com.box.small.admin.admin;


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
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    AdminService adminService;





    @GetMapping(value = "loginForm")
    public ModelAndView adminLoginForm(){
        ModelAndView mav = new ModelAndView();

        mav.setViewName("admin/admin/login");
        return mav;
    }

    @PostMapping(value ="login")
    public @ResponseBody Map<String,Object> adminLogin(AdminDto admin, HttpSession session, RedirectAttributes redirectAttributes){
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            admin = adminService.login(admin);
            if(admin != null){
                redirectAttributes.addFlashAttribute("loginMessage", "관리자 로그인 성공");
                session.setAttribute("admin", admin);
                session.setAttribute("isLogin", true);
                session.setAttribute("type", "admin");
                map.put("location", "/admin");
            }
        } catch (NullPointerException e){
            redirectAttributes.addFlashAttribute("loginMessage", "관리자 로그인 실패");
            map.put("location", "/admin/loginForm");
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




}







