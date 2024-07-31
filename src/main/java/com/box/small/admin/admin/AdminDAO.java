package com.box.small.admin.admin;


import com.box.small.user.member.MemberDto;

import java.util.List;

public interface AdminDAO {
    //   로그인
    AdminDto login(AdminDto admin);

    List<MemberDto> selectAllMember();


}
