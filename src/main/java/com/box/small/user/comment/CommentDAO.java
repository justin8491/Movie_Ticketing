package com.box.small.user.comment;

import java.util.List;

public interface CommentDAO {
//	댓글 추가
	int commentAdd(CommentDto cDto);
//	댓글 수정
	int commentUpdate(int com_no);
//	댓글 삭제
	int commentDelete(int com_no);
//	댓글 조회
	List<CommentDto> commentList();
}
