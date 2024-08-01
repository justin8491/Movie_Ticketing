<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<%@ include file = "/resources/include/head_beta.jsp"%>
</head>
<body>
 <header id="header">
        <%@ include file = "/resources/include/header_beta.jsp"%>
   </header>
	<!-- //메인 콘텐츠-->
	<section class="content">
      <div class="container">
        <div class="row">
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
			<a href = "adminFreeBoardDelete?bo_no=${noticelist.bo_no}">삭제</a>
			
			</section>
    <!-- //footer -->
    <footer>
        <%@ include file = "/resources/include/footer_beta.jsp"%>
    </footer>
    <!-- 플러그인 -->
        <%@ include file = "/resources/include/plugin_cdn.jsp"%>
</body>
</html>