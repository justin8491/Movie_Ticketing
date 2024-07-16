<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<link rel="stylesheet" href="${contextPath}/resources/css/header.css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<title>main</title>

<link rel="stylesheet" href="${contextPath}/resources/css/NewFile.css" />
<link href="${contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<!-- jQuery 3.4.1 -->
<script src="${contextPath}/resources/jQuery/jquery-3.4.1.min.js"></script>
<script src="${contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
</head>

<div class="logo">

</div>

<body>
	
	<div class="center">
		<img src="${contextPath}/resources/images/test.png" alt="logo">
		<nav class ="navbar">
			<ul >
				<li><a href="${contextPath}/user/movie/movieList">영화</a></li>
				<li><a href="#">예매</a></li>
				<li><a href="#">영화관</a></li>
				<li><a href="#">로그인</a></li>	
				<li><a href="#">마이페이지(임시)</a></li>
				<li><a href="${contextPath}/user/support/support">고객센터</a></li>
			</ul>			
		</nav>
	</div>
</body>