<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="/resources/include/head_beta.jsp"%>
    <link rel="stylesheet" href="/resources/assets/css/detailMovie.css" />
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
                    <!-- 이쪽에 줄거리 써놓으면 좋을것 같음 -->

                    <div class="entry-content">
                        <!-- 리뷰 작성 -->
                        <h2 style="font-size: 2rem;">리뷰</h2>
                        <hr>
                        <form id="reviewForm">
                            <h3>${member.mem_id}</h3>
                            <input type="hidden" id="mem_id" name="mem_id" value="${member.mem_id}" />
                            <input type="hidden" id="mo_no" name="mo_no" value="${movie.mo_no}" />
                            <textarea id="rev_content" name="rev_content"></textarea>
                            <!-- 별점 추가 -->
                            <div id="star-rating">
                                <span class="star" data-value="1">&#9733;</span>
                                <span class="star" data-value="2">&#9733;</span>
                                <span class="star" data-value="3">&#9733;</span>
                                <span class="star" data-value="4">&#9733;</span>
                                <span class="star" data-value="5">&#9733;</span>
                            </div>
                            <input type="hidden" id="reviewRating" name="rev_rating" value="0" />
                            <input type="submit" value="작성">
                        </form>
                        <hr>
                        <!-- 리뷰 확인 -->
                        <div>${item.rev_no}</div>
                        <c:forEach var="item" items="${reviewList}">
                            <div class="review-item" id="review-${item.rev_no}">
                                <span>${item.mem_id}</span>
                                <span class="review-content" id="review-content-${review.rev_no}">${item.rev_content}</span>
                                <div class="star-rating" id="review-rating-${review.rev_no}" title="Rated ${item.rev_rating}.00 out of 5">
                                    <span style="width:${item.rev_rating * 20}%">
                                        <strong class="rating">${item.rev_rating}.00</strong> out of 5
                                    </span>
                                </div>
                                <span>${item.rev_createdAt}</span>
                                <c:if test="${member.mem_id == item.mem_id}">
                                    <button onclick="showEditForm(${item.rev_no})">수정</button>
                                    <button onclick="deleteReview(${item.rev_no},${movie.mo_no})">삭제</button>
                                </c:if>
                                    <form class="edit-form" id="edit-form-${item.rev_no}" style="display:none;" onsubmit="return false;">
                                    <input type="hidden" id="mem_id" name="mem_id" value="${member.mem_id}" />
                                    <textarea id="edit-content-${item.rev_no}">${item.rev_content}</textarea>
                                    <div id="star-ratingUpdate">
                                        <span class="starUpdate" data-value="1">&#9733;</span>
                                        <span class="starUpdate" data-value="2">&#9733;</span>
                                        <span class="starUpdate" data-value="3">&#9733;</span>
                                        <span class="starUpdate" data-value="4">&#9733;</span>
                                        <span class="starUpdate" data-value="5">&#9733;</span>
                                    </div>
                                    <input type="hidden" id="reviewRatingUpdate" name="rev_rating" value="0" />
                                    <button type="submit" onclick="updateReview(${item.rev_no});">저장</button>
                                    <button type="button" onclick="hideEditForm(${item.rev_no});">취소</button>
                                </form>
                                </div>
                                <br>
                            </div>
                        </c:forEach>
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

<script src="${path}/detailMovie/js/detailMovie_review.js"></script>


</body>
</html>
