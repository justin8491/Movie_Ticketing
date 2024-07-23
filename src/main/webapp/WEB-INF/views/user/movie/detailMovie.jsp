<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
    <%@ include file = "/resources/include/head_beta.jsp"%>
<meta charset="UTF-8">
<title>movie</title>
</head>
<body>
 <header id="header">
        <%@ include file = "/resources/include/header_beta.jsp"%>
</header>

	<h1>상세영화 페이지 입니다.</h1>
	 <section class="content">
		<div class="container movie">
           	 <div class="row movie">
               	 <img src="${contextPath}/resources/images/${movie.mo_photo}" alt="${movie.mo_name}" class="img-fluid">
					<p>영화이름 : "${movie.mo_name}"</p>
					<p>상영일 : "${movie.mo_releaseDate}"</p>
					<p>러닝타임 : "${movie.mo_runningTime}"</p>
					<p>감독 : "${movie.mo_director}"</p>
					<p>주연배우 : "${movie.mo_mainActor}"</p>
					<p>줄거리 : "${movie.mo_plot}"</p>
          	  </div>
  		  </div>
      </section>
      
      
        <footer>
        <%@ include file = "/resources/include/footer_beta.jsp"%>
    </footer>
    <!-- 플러그인 -->
        <%@ include file = "/resources/include/plugin_cdn.jsp"%>
</body>
</html>