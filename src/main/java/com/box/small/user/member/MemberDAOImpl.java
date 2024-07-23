package com.box.small.user.member;

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
    String SQL_NAME_SAPCE = "com.box.small.mappers.memberMapper.";

    @Override
    public MemberDto login(MemberDto member) {
        return sqlSession.selectOne(SQL_NAME_SAPCE + "login", member);
    }

    @Override
    public MemberDto detailMember(MemberDto member) {
        return sqlSession.selectOne(SQL_NAME_SAPCE + "detailMember", member);
    }

    @Override
    public int createMember(MemberDto member) {
        return sqlSession.insert(SQL_NAME_SAPCE + "createMember", member);
    }

    @Override
    public MemberDto selectById(MemberDto member) {
        return sqlSession.selectOne(SQL_NAME_SAPCE + "selectById", member);
    }

    @Override
    public MemberDto selectByPwd(MemberDto member) {
        return sqlSession.selectOne(SQL_NAME_SAPCE + "selectByPwd", member);
    }

    @Override
    public List<MemberDto> selectAllMember() {
        return sqlSession.selectList(SQL_NAME_SAPCE + "listAll");
    }

    @Override
    public int updateMember(MemberDto member) {
        return sqlSession.update(SQL_NAME_SAPCE+"updateMember",member);
    }


    @Override
    public int deleteMember(String mem_id) {
        return sqlSession.delete(SQL_NAME_SAPCE+"deleteMember",mem_id);
    }
}
