package com.box.small.user.comment;

import java.util.List;

public interface CommentService {
//	댓글 추가
	int commentAdd(CommentDto cDto);
//	댓글 수정
	int commentUpdate(CommentDto cDto);
//	댓글 삭제
	int commentDelete(int com_no);
//	댓글 조회
	List<CommentDto> commentList(int bo_no);
}
