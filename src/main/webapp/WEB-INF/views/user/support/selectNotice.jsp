<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file = "/resources/include/head_beta.jsp"%>
</head>
<body>

	<table class="table table-hover">
				<tr>
					<th>번호</th><th>제목</th><th>작성자ID</th><th>생성일</th>
				</tr>
			
				<tr>
					<td>${noticelist.bo_no}</td>
					<td>${noticelist.bo_title}</td>
					<td>${noticelist.bo_writerId}</td>
					<td>${noticelist.bo_createAt}</td>
				</tr>
				<tr>
				<th>내용:</th>
					<td colspan = "4">${noticelist.bo_content}</td>
				</tr>
			
			</table>
</body>
</html>