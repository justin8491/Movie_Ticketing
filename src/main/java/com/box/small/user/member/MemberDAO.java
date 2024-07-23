package com.box.small.user.member;

import org.springframework.stereotype.Repository;

import java.util.List;


public interface MemberDAO {
    MemberDto login(MemberDto member);
    //   회원상세
    MemberDto detailMember(MemberDto member);
    //   회원가입
    int createMember(MemberDto member);
    //    아이디 찾기
    MemberDto selectById(MemberDto member);
    //    비밀번호 찾기
    MemberDto selectByPwd(MemberDto member);
    //    유저 전체 검색
    List<MemberDto> selectAllMember();
    //    유저 정보 변경
    int updateMember(MemberDto member);
    //    유저 정보 삭제
    int deleteMember(String mem_id);


}
