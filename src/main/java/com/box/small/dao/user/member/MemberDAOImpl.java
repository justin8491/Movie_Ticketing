package com.box.small.dao.user.member;

import com.box.small.dto.Member;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberDAOImpl implements MemberDAO {

    private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);

    @Autowired
    SqlSession sqlSession;
    String SQL_NAME_SAPCE = "com.box.small.mapper.memberMapper.";

    @Override
    public Member login(Member member) {
        return sqlSession.selectOne(SQL_NAME_SAPCE + "login", member);
    }

    @Override
    public Member detailMember(Member member) {
        return sqlSession.selectOne(SQL_NAME_SAPCE + "detailMember", member);
    }

    @Override
    public int createMember(Member member) {
        return sqlSession.insert(SQL_NAME_SAPCE + "createMember", member);
    }

    @Override
    public Member selectById(Member member) {
        return sqlSession.selectOne(SQL_NAME_SAPCE + "selectById", member);
    }

    @Override
    public Member selectByPwd(Member member) {
        return sqlSession.selectOne(SQL_NAME_SAPCE + "selectByPwd", member);
    }

    @Override
    public List<Member> selectAllMember() {
        return sqlSession.selectList(SQL_NAME_SAPCE + "listAll");
    }

    @Override
    public int updateMember(Member member) {
        return sqlSession.update(SQL_NAME_SAPCE+"updateMember",member);
    }


    @Override
    public int deleteMember(String mem_id) {
        return sqlSession.delete(SQL_NAME_SAPCE+"deleteMember",mem_id);
    }
}
