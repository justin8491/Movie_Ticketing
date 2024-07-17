<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <%@ include file = "/resources/include/header.jsp"%>
<title>자주 묻는 질문 페이지입니다.</title>
</head>
<body>
	<h1>자주 묻는 질문 페이지입니다.</h1>
	
	<table class="table table-hover">
				<tr>
					<th>번호</th><th>제목</th><th>작성자ID</th><th>생성일</th>
				</tr>
			<c:forEach var="board" items="${faqlist }">
				<tr>
					<td>${board.bo_no}</td>
					<td><a href="selectFaq?bo_no=${board.bo_no}">${board.bo_title}</a></td>
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