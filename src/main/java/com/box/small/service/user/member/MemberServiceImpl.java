package com.box.small.service.user.member;

import com.box.small.controller.user.member.MemberController;
import com.box.small.dao.user.member.MemberDAO;
import com.box.small.dto.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
    @Autowired
    MemberDAO dao;
    @Override
    public Member login(Member member) {
        Member compareMember = dao.login(member);

        if(member.getMem_id().equals(compareMember.getMem_id())
        && member.getMem_password().equals(compareMember.getMem_password())){
            logger.info("로그인 성공");
            return compareMember;
        }
        return null;
    }

    @Override
    public int createMember(Member member) {
        return dao.createMember(member);
    }

    @Override
    public Member selectById(Member member) {
        return dao.selectById(member);
    }

    @Override
    public Member selectByPwd(Member member) {
        return dao.selectByPwd(member);
    }

    @Override
    public List<Member> selectAllMember() {
        return dao.selectAllMember();
    }

    @Override
    public int updateMember(String mem_id) {
        return dao.updateMember(mem_id);
    }

    @Override
    public int deleteMember(String mem_id) {
        return dao.deleteMember(mem_id);
    }
}
