<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
   <%@ include file = "/resources/include/header.jsp"%>
</head>
<body>
	<h1>자유게시판 페이지입니다.</h1>
	
		<div><a href="freeBoardWrite">작성</a></div>
	<table class="table table-hover">
				<tr>
					<th>번호</th><th>제목</th><th>작성자ID</th><th>생성일</th>
				</tr>
				
			<c:forEach var="board" items="${freeboardlist }">
				<tr>
					<td>${board.bo_no}</td>
					<td><a href="selectFreeBoard?bo_no=${board.bo_no}">${board.bo_title}</a></td>
					<td>${board.bo_writerId}</td>
					<td>${board.bo_createAt}</td>
				</tr>
			</c:forEach>
				<tr>
					<td colspan = "4"></td>
				</tr>
			
			</table>
	
	
</body>
</html>