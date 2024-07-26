<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <%@ include file="/resources/include/head_beta.jsp"%>
</head>
<body>
<header id="header">
    <%@ include file="/resources/include/headerAdmin_beta.jsp"%>
</header>

<div id="site-content">
    <main class="main-content">
        <div class="container">
            <div class="page">
                <div class="breadcrumbs">
                    <a href="/admin">관리자홈</a>
                    <span>"영화추가하기"</span>
                </div>

                <div class="content">
                    <div class="row">
                        <div class="col-md-6">
                            <figure class="movie-poster">
                                <img src="${contextPath}/resources/images/no_image.jpg" alt="사진을 넣어주세요">
                            </figure>
                        </div>
                        <div class="col-md-6">
                            <form action="/admin/movie/addMovie" method="post">
                                <div class="mb-3">
                                    <label for="cat_no" class="form-label">카테고리</label>
                                    <input type="text" id="cat_no" name="cat_no" class="form-control" value="${movie.cat_no}" required>
                                </div>
                                <div class="mb-3">
                                    <label for="mo_name" class="form-label">이름</label>
                                    <input type="text" id="mo_name" name="mo_name" class="form-control" value="${movie.mo_name}" required>
                                </div>
                                <div class="mb-3">
                                    <label for="mo_releaseDate" class="form-label">상영일</label>
                                    <input type="text" id="mo_releaseDate" name="mo_releaseDate" class="form-control" value="${movie.mo_releaseDate}" required>
                                </div>
                                <div class="mb-3">
                                    <label for="mo_endDate" class="form-label">종영일</label>
                                    <input type="text" id="mo_endDate" name="mo_endDate" class="form-control" value="${movie.mo_endDate}">
                                </div>
                                <div class="mb-3">
                                    <label for="mo_runningTime" class="form-label">러닝타임</label>
                                    <input type="number" id="mo_runningTime" name="mo_runningTime" class="form-control" value="${movie.mo_runningTime}" required> (분)
                                </div>
                                <div class="mb-3">
                                    <label for="mo_plot" class="form-label">줄거리</label>
                                    <textarea id="mo_plot" name="mo_plot" class="form-control" rows="5" required>${movie.mo_plot}</textarea>
                                </div>
                                <div class="mb-3">
                                    <label for="mo_status" class="form-label">상태</label>
                                    <input type="number" id="mo_status" name="mo_status" class="form-control" value="${movie.mo_status}" required> [상영중 : 1 / 종영 : 0]
                                </div>
                                <div class="mb-3">
                                    <label for="mo_director" class="form-label">감독</label>
                                    <input type="text" id="mo_director" name="mo_director" class="form-control" value="${movie.mo_director}" required>
                                </div>
                                <div class="mb-3">
                                    <label for="mo_mainActor" class="form-label">주연배우</label>
                                    <input type="text" id="mo_mainActor" name="mo_mainActor" class="form-control" value="${movie.mo_mainActor}" required>
                                </div>
                                <div class="mb-3">
                                    <label for="mo_rating" class="form-label">연령제한 (전체관람가 / 12세이상관람가 / 15세이상관람가 )</label>
                                    <input type="text" id="mo_rating" name="mo_rating" class="form-control" value="${movie.mo_rating}" required>
                                </div>
                                <div class="mb-3">
                                    <label for="mo_photo" class="form-label">영화포스터이름 (포스터사진이 준비되지 않았으면 no_image.jpg 입력)</label>
                                    <input type="text" id="mo_photo" name="mo_photo" class="form-control" required>
                                </div>
                                <button type="submit" class="btn btn-primary">저장하기</button>
                            </form>
                        </div>
                    </div> <!-- row -->
                    <div class="entry-content">
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