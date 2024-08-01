package com.box.small.admin.admin;

import com.box.small.user.member.MemberDto;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminDAOImpl implements AdminDAO {

    private static final Logger logger = LoggerFactory.getLogger(AdminDAOImpl.class);

    @Autowired
    SqlSession sqlSession;
    String SQL_NAME_SAPCE = "com.box.small.mappers.adminMapper.";

    @Override
    public AdminDto login(AdminDto admin) {
        return sqlSession.selectOne(SQL_NAME_SAPCE + "login", admin);
    }

    @Override
    public List<MemberDto> selectAllMember() {
        return sqlSession.selectList(SQL_NAME_SAPCE + "selectAllMember");
    }
}
