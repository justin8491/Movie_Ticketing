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
                    <a href="${contextPath}/user/schedule/scheduleList">스케줄 전체리스트</a>
                    <span>"${scheduleData.movie.mo_name}"</span>
                </div>

                <div class="content">
                    <div class="row">
                        <div class="col-md-6">
                            <figure class="movie-poster">
                                <img src="${contextPath}/resources/images/${scheduleData.movie.mo_photo}" alt="${scheduleData.movie.mo_name}">
                            </figure>
                        </div>
                            <div class="col-md-6">
                                <h2 class="movie-title">"${scheduleData.movie.mo_name}"</h2>
                                <div class="movie-summary">
                                    <p>${movie.mo_plot}</p>
                                    <br>
                                    <br>
                                </div>
                                <ul class="movie-meta">
                                    <li><strong>영화이름 : </strong> ${scheduleData.movie.mo_name}</li>
                                    <li><strong>상영관 : </strong> ${scheduleData.screen.sc_name}</li>
                                    <li><strong>상영날짜 : </strong> ${scheduleData.schedule.sch_date}</li>
                                    <li><strong>시작시간 : </strong> ${scheduleData.schedule.sch_startTime}</li>
                                    <li><strong>종료시간 : </strong> ${scheduleData.schedule.sch_endTime}</li>
                                </ul>
                            </div>
                    </div> <!-- row -->
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