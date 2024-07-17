<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file = "/resources/include/header.jsp"%>
<title>Insert title here</title>
</head>
<body>

	<table class="table table-hover">
				<tr>
					<th>번호</th><th>제목</th><th>작성자ID</th><th>생성일</th>
				</tr>
			
				<tr>
					<td>${freeBoard.bo_no}</td>
					<td>${freeBoard.bo_title}</td>
					<td>${freeBoard.bo_writerId}</td>
					<td>${freeBoard.bo_createAt}</td>
				</tr>
				<tr>
				<th>내용:</th>
					<td colspan = "4">${freeBoard.bo_content}</td>
				</tr>
			
			</table>
</body>
</html>