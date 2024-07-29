package com.box.small.admin.admin;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
    @Autowired
    AdminDAO dao;

    @Override
    public AdminDto login(AdminDto admin) {
        return dao.login(admin);
    }
}
