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
                    <span>"영화관추가하기"</span>
                </div>

                <div class="content">
                    <div class="row">
                        <div class="col-md-6">
                            <figure class="theater-poster">
                                <img src="${contextPath}/resources/images/no_image.jpg" alt="사진을 넣어주세요">
                            </figure>
                        </div>
                        <div class="col-md-6">
                            <form action="/admin/theater/addTheater" method="post">
                                <div class="mb-3">
                                    <label for="cat_no" class="form-label">영화관 이름</label>
                                    <input type="text" id="th_name" name="th_name" class="form-control" value="${theater.th_name}" required>
                                </div>
                                <div class="mb-3">
                                    <label for="cat_no" class="form-label">영화관 위치</label>
                                    <input type="text" id="th_location" name="th_location" class="form-control" value="${theater.th_location}" required>
                                </div>
                                <div class="mb-3">
                                    <label for="cat_no" class="form-label">영화관 상태 (1 : 오픈 / 0 : 오픈준비중)</label>
                                    <input type="number" id="th_status" name="th_status" class="form-control" value="${theater.th_status}" required>
                                </div>
     							<div class="mb-3">
                                    <label for="th_photo" class="form-label">영화관 사진이름 (사진이 준비되지 않았을때는 no_image.jpg 를 입력하세요)</label>
                                    <input type="text" id="th_photo" name="th_photo" class="form-control" required>
                                </div>
                                <button type="submit" class="btn btn-primary">추가하기</button>
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