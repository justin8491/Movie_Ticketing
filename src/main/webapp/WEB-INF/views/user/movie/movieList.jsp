<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <%@ include file = "/resources/include/head_beta.jsp"%>
</head>
<body>
    
 <header id="header">
        <%@ include file = "/resources/include/header_beta.jsp"%>
</header>
		<div id="site-content">
			<main class="main-content">
				<div class="container">
					<div class="page">
						<div class="breadcrumbs">
							<a href="/">Home</a>
							<span>영화 전체리스트</span>
						</div>

						<div class="filters">
							<select name="#" id="#" placeholder="Choose Category">
								<c:forEach var = "category" items = "${category}">
									<option value="#">${category.cat_name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="movie-list">
								<c:forEach var="movie" items="${movielist}">
									<div class="movie">
									<figure class="movie-poster"><a href="${contextPath}/user/movie/detailMovie?mo_no=${movie.mo_no}">
									<img src="${contextPath}/resources/images/${movie.mo_photo}" alt="${movie.mo_name}">
									</a></figure>
									<div class="movie-title"><a href="${contextPath}/user/movie/detailMovie?mo_no=${movie.mo_no}">${movie.mo_name}</a></div>
									</div>
								</c:forEach>
						</div> <!-- .movie-list -->

						<div class="pagination">
							<a href="#" class="page-number prev"><i class="fa fa-angle-left"></i></a>
							<span class="page-number current">1</span>
							<a href="#" class="page-number">2</a>
							<a href="#" class="page-number">3</a>
							<a href="#" class="page-number">4</a>
							<a href="#" class="page-number">5</a>
							<a href="#" class="page-number next"><i class="fa fa-angle-right"></i></a>
						</div>
					</div>
				</div> <!-- .container -->
			</main>
		</div>
		<!-- Default snippet for navigation -->		

<footer>
    <%@ include file="/resources/include/footer_beta.jsp"%>
</footer>
<!-- 플러그인 -->
<%@ include file="/resources/include/plugin_cdn.jsp"%>

</body>
</html>