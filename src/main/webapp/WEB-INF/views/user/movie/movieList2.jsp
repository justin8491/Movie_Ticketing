<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	.center{
	background-color: yellow;	
	}
</style>
<meta charset="UTF-8">
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<title>main</title>
<link rel="stylesheet" href="${contextPath}/resources/css/header.css" />
<link href="${contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery 3.4.1 -->
<script src="${contextPath}/resources/jQuery/jquery-3.4.1.min.js"></script>
<script src="${contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>


</head>
<body>
	<section>	
	<div class="center">
		<nav class ="navbar">
		<a href = "/"><img src="${contextPath}/resources/images/test.png" alt="logo"></a>
			<ul >
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

    <div id="banner">
        <h2>최신 영화</h2>
        <p>최신 영화 목록을 확인하세요!</p>
    </div>
    
    <div class="container">
        <h1 class="text-center my-4">Movie List</h1>
        <div class="row movielist">
            <c:forEach var="movie" items="${movielist}">
                <div class="col-md-4 mb-4">
                    <div class="text-center">
                        <img src="${contextPath}/resources/images/${movie.mo_photo}" alt="${movie.mo_name}" class="img-fluid">
                        <div class="movie-name">
                            <a href="${contextPath}/user/movie/detailMovie?mo_no=${movie.mo_no}">${movie.mo_name}</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <!-- Pagination -->
        <nav aria-label="Page navigation">
            <ul class="pagination justify-content-center">
                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                <li class="page-item active"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">Next</a></li>
            </ul>
        </nav>
    </div>

    <!-- Bootstrap JS and dependencies (optional but recommended) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>