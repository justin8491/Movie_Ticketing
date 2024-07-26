<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="/resources/include/head_beta.jsp"%>
</head>
<body>
<header id="header">
    <%@ include file="/resources/include/header_beta.jsp"%>
</header>

<div id="site-content">
    <main class="main-content">
        <div class="container">
            <div class="page">
                <div class="breadcrumbs">
                    <a href="/">Home</a>
                    <a href="${contextPath}/user/movie/movieList">영화 전체리스트</a>
                    <span>"${movie.mo_name}"</span>
                </div>

                <div class="content">
                    <div class="row">
                        <div class="col-md-6">
                            <figure class="movie-poster">
                                <img src="${contextPath}/resources/images/${movie.mo_photo}" alt="${movie.mo_name}">
                            </figure>
                        </div>
                            <div class="col-md-6">
                                <h2 class="movie-title">"${movie.mo_name}"</h2>
                                <div class="movie-summary">
                                    <p>${movie.mo_plot}</p>
                                    <br>
                                    <br>
                                </div>
                                <ul class="movie-meta">
                                    <li><strong>Rating:</strong>
                                        <div class="star-rating" title="Rated 4.00 out of 5">
                                            <span style="width:80%">
                                                <strong class="rating">4.00</strong> out of 5
                                            </span>
                                        </div>
                                    </li>
                                    
                                    <li><strong>러닝타임 : </strong> ${movie.mo_runningTime}분</li>
                                    <li><strong>상영일 : </strong> ${movie.mo_releaseDate}</li>
                                    <li><strong>연령제한 : </strong> ${movie.mo_rating}</li>
                                    <li><strong>카테고리 : </strong> ${cat_name}</li>
                                    <li><strong>감독 : </strong> ${movie.mo_director}</li>
                                    <li><strong>주연배우 : </strong> ${movie.mo_mainActor}</li>
                                </ul>
                            </div>
                    </div> <!-- row -->
                    <div class="entry-content">
                        <!-- 여기에다가 별점 리뷰 댓글 놓으면 될거같음! -->
                        
                    </div>
                </div>
            </div>
        </div> <!-- .container -->
    </main>
</div>

<footer>
    <%@ include file="/resources/include/footer_beta.jsp"%>
</footer>
<!-- 플러그인 -->
<%@ include file="/resources/include/plugin_cdn.jsp"%>

</body>
</html>
