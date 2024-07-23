package com.box.small.user.member;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
    @Autowired
    MemberDAO dao;
    @Override
    public MemberDto login(MemberDto member) {
        MemberDto compareMember = dao.login(member);

        if(member.getMem_id().equals(compareMember.getMem_id())
        && member.getMem_password().equals(compareMember.getMem_password())){
            logger.info("User ID : "+ compareMember.getMem_id() +" User Name : " + compareMember.getMem_name() + " 로그인");
            return compareMember;
        }
        return null;
    }

    @Override
    public Object detailMember(MemberDto member) {
        return dao.detailMember(member);
    }

    @Override
    public int createMember(MemberDto member) {
        return dao.createMember(member);
    }

    @Override
    public MemberDto selectById(MemberDto member) {
        return dao.selectById(member);
    }

    @Override
    public MemberDto selectByPwd(MemberDto member) {
        return dao.selectByPwd(member);
    }

    @Override
    public List<MemberDto> selectAllMember() {
        return dao.selectAllMember();
    }

    @Override
    public int updateMember(MemberDto member) {
        return dao.updateMember(member);
    }

    @Override
    public int deleteMember(MemberDto member) {
        return dao.deleteMember(member);
    }
}
