package com.box.small.admin.admin;



import com.box.small.user.member.MemberDto;

import java.util.List;


public interface AdminService {

    //   로그인
    AdminDto login(AdminDto admin);

    // 전체 사용자
    List<MemberDto> selectAllMember();

}
