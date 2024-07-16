package com.box.small.service.user.member;

import com.box.small.dto.Member;
import org.springframework.stereotype.Service;

import java.util.List;



public interface MemberService {

//   로그인
    Member login(Member member);
//   회원가입
    int createMember(Member member);
//    아이디 찾기
    Member selectById(Member member);
//    비밀번호 찾기
    Member selectByPwd(Member member);
//    유저 전체 검색
    List<Member> selectAllMember();
//    유저 정보 변경
    int updateMember(String mem_id);
//    유저 정보 삭제
    int deleteMember(String mem_id);


}
