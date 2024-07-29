package com.box.small.admin.admin;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    AdminService adminService;





    @GetMapping(value ="login")
    public Map<String, Object> adminLogin(AdminDto admin){
        Map<String, Object> map = new HashMap<String, Object>();
        adminService.login(admin);

        map.put("location", "/admin/admin/login");
        return map;
    }




}







