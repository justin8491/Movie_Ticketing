<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
   <%@ include file = "/resources/include/header.jsp"%>
<meta charset="UTF-8">
<title>movie</title>
</head>
<body>
	<h1>상세영화 페이지 입니다.</h1>
	<div class="movie-container">
            <div class="movie">
                <img src="${contextPath}${movie.mo_photoURL}" alt="${movie.mo_name}">
				<p>영화이름 : "${movie.mo_name}"</p>
				<p>상영일 : "${movie.mo_releaseDate}"</p>
				<p>러닝타임 : "${movie.mo_runningTime}"</p>
				<p>감독 : "${movie.mo_director}"</p>
				<p>주연배우 : "${movie.mo_mainActor}"</p>
				<p>줄거리 : "${movie.mo_plot}"</p>
            </div>
    </div>
</body>
</html>