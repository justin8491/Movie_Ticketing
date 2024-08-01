<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="contextPath" value="${pageContext.request.contextPath }" />
  <c:set var="path" value="${pageContext.request.contextPath }/resources" />
<!DOCTYPE html>
<html>
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
                    <a href="${contextPath}/user/theater/theaterList">All Theater</a> <!-- 리뷰사이트로 이동하는 기능 넣을거면 추가해야함 -->
                    <span>"${theater.th_name}"</span>
                </div>
		
                <div class="content">
                    <div class="row">
                        <div class="col-md-6">
                            <figure class="movie-poster" id="movie-poster-custom">
                                <img src="${contextPath}/resources/images/${theater.th_photo}" alt="${theater.th_name}">
                            </figure>
                        </div>
                        <div class = "col-md-6">
                            <div class="movie-details">
								<p>영화관 이름 : "${theater.th_name}"</p>
								<p>영화관 주소 : "${theater.th_location}"</p>
                            </div>
                        </div>
                    </div> <!-- .movie-list -->
                    
                    <div class="entry-content">
                        <!-- 여기에다가 영화관 주소 찍어주기 -->
                        
                    </div>
                </div>
            </div>
        </div>
    </main>
		</div>
		<!-- Default snippet for navigation -->
      
    <footer>
        <%@ include file = "/resources/include/footer_beta.jsp"%>
    </footer>
    
    <!-- 플러그인 -->
        <%@ include file = "/resources/include/plugin_cdn.jsp"%>
	</body>

</html>