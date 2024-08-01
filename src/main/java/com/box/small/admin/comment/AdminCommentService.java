package com.box.small.admin.comment;

import java.util.List;

public interface AdminCommentService {
//	댓글 추가
	int adminCommentAdd(AdminCommentDto cDto);
//	댓글 수정
	int adminCommentUpdate(AdminCommentDto cDto);
//	댓글 삭제
	int adminCommentDelete(int com_no);
//	댓글 조회
	List<AdminCommentDto> adminCommentList(int bo_no);
}
