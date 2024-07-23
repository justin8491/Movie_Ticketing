<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의글 보기</title>
</head>
<body>
	<table class="table table-hover">
				<tr>
					<th>번호</th><th>제목</th><th>작성자ID</th><th>생성일</th>
				</tr>
			
				<tr>
					<td>${inquiry.bo_no}</td>
					<td>${inquiry.bo_title}</td>
					<td>${inquiry.bo_writerId}</td>
					<td>${inquiry.bo_createAt}</td>
				</tr>
				<tr>
				<th>내용:</th>
					<td colspan = "4">${inquiry.bo_content}</td>
				</tr>
			
			</table>
			<div>
			<a href = "freeBoardDelete?bo_no=${inquiry.bo_no}">삭제</a>
			</div>
</body>
</html>