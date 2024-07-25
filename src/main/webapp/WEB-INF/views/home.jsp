
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
<%@ include file = "/resources/include/head_beta.jsp"%>
	<title>Home</title>
	<title>smallBox</title>
</head>
<body>
	<section>	
	<div class="center">
		<nav class ="navbar">
			<ul>
				<li><a href = "/"><img src="${contextPath}/resources/images/test.png" alt="logo"></a></li>
				<li><a href="${contextPath}/user/movie/movieList">영화</a></li>
				<li><a href="#">예매</a></li>
				<li><a href="${contextPath}/user/theater/theaterList">영화관</a></li>
				<li><a href="#">로그인</a></li>	
				<li><a href="#">마이페이지(임시)</a></li>
				<li><a href="${contextPath}/user/support/support">고객센터</a></li>
			</ul>			
		</nav>
		</div>
	</section>
	<p></p>
	<section>
			<p> 메인 내용 컨텐츠 구간</p>
	
	</section>
<%@ include file = "/resources/include/footer.jsp"%>