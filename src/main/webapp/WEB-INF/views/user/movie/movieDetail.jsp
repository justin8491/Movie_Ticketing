<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="/resources/include/head_beta.jsp"%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">
    <!-- Loading third party fonts -->
    <link href="http://fonts.googleapis.com/css?family=Roboto:300,400,700|" rel="stylesheet" type="text/css">
    <link href="fonts/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- Loading main css file -->
    <link rel="stylesheet" href="style.css">
    <!--[if lt IE 9]>
    <script src="js/ie-support/html5.js"></script>
    <script src="js/ie-support/respond.js"></script>
    <![endif]-->
<style>
 .movie-list .movie .movie-poster {
      border-radius: 5px;
      overflow: hidden;
      margin-bottom: 20px;
      border: 1px solid transparent; }
      .movie-list .movie .movie-poster img {
        display: block;
        width: 100%;
        max-width: 100%;
        height: auto;
        -webkit-transition: .3s ease;
                transition: .3s ease; }
    .movie-list .movie:hover img {
      -webkit-transform: scale(1.2);
          -ms-transform: scale(1.2);
              transform: scale(1.2); }
    .movie-list .movie .movie-title {
      font-size: 24px;
      font-size: 1.6em;
      font-weight: 300;
      margin-bottom: 20px; }
      .movie-list .movie .movie-title a {
        color: #84878d;
        -webkit-transition: .3s ease;
                transition: .3s ease; }
        .movie-list .movie .movie-title a:hover {
          color: #ffaa3c; }
          .movie-meta, .starring {
  margin-bottom: 30px;
  list-style: none; }
  .movie-meta li, .starring li {
    margin-bottom: 10px; }
</style>
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
                    <a href="/">Movie Review</a> <!-- 리뷰사이트로 이동하는 기능 넣을거면 추가해야함 -->
                    <span>"${movie.mo_name}"</span>
                </div>

                <div class="content">
                    <div class="row">
                        <div class="col-md-6">
                            <figure class="movie-poster"><img src="${contextPath}/resources/images/${movie.mo_photo}" alt="${movie.mo_name}"></figure>
                        </div>
                        <div class="col-md-6">
                            <h2 class="movie-title">"${movie.mo_name}"</h2>
                            <div class="movie-summary">
                                <p>${movie.mo_plot}</p>
                            </div>
                            <ul class="movie-meta">
                                <li><strong>Rating:</strong>
                                    <div class="star-rating" title="Rated 4.00 out of 5"><span style="width:80%"><strong class="rating">4.00</strong> out of 5</span></div>
                                </li>
                                <li><strong>Length:</strong> ${movie.mo_runningTime}분</li>
                                <li><strong>Premiere:</strong> ${movie.mo_releaseDate}</li>
                                <li><strong>Category:</strong> ${cat_name}</li>
                            </ul>

                            <ul class="starring">
                                <li><strong>Directors:</strong> ${movie.mo_director}</li>
                                <li><strong>Main Actors:</strong> ${movie.mo_mainActor}</li>
                            </ul>
                        </div>
                    </div> <!-- .row -->
                    <div class="entry-content">
                        <!-- 여기에다가 별점 리뷰 댓글 놓으면 될거같음! -->
                        <p>별점과 리뷰 댓글 기능을 여기에다가 써보아요.</p>
                    </div>
                </div>
            </div>
        </div> <!-- .container -->
    </main>
</div>

<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/plugins.js"></script>
<script src="js/app.js"></script>

<footer>
    <%@ include file="/resources/include/footer_beta.jsp"%>
</footer>
<!-- 플러그인 -->
<%@ include file="/resources/include/plugin_cdn.jsp"%>

</body>
</html>