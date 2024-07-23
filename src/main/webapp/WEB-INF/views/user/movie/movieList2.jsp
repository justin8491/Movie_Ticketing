<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<head>
    <%@ include file = "/resources/include/head_beta.jsp"%>
</head>
</head>
<body>
	 <header id="header">
        <%@ include file = "/resources/include/header_beta.jsp"%>
   	</header>

    <div id="banner">
        <h2>최신 영화</h2>
        <p>최신 영화 목록을 확인하세요!</p>
    </div>
    
  <section class="content">
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
    </div>
  </section>
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
    <footer>
        <%@ include file = "/resources/include/footer_beta.jsp"%>
    </footer>
    <!-- 플러그인 -->
        <%@ include file = "/resources/include/plugin_cdn.jsp"%>
</body>