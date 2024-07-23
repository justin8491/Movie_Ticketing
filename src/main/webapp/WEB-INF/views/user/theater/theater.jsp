<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file = "/resources/include/head_beta.jsp"%>
</head>
<body>
 <header id="header">
        <%@ include file = "/resources/include/header_beta.jsp"%>
</header>

	<h1>상세극장 페이지 입니다!</h1>
 <section class="content">
    <div class="container">
        <h1 class="text-center my-4">Movie List</h1>
        <div class="row movielist">
            <div class="theater">
                <img src="${contextPath}/resources/images/${theater.th_photo}" alt="${theater.th_name}" class="img-fluid">
				<p>영화관 이름 : "${theater.th_name}"</p>
				<p>영화관 주소 : "${theater.th_location}"</p>
				<p> : "${theater.th_photo}"</p>
            </div>
        </div>
    </div>
  </section>
   <footer>
        <%@ include file = "/resources/include/footer_beta.jsp"%>
    </footer>
    <!-- 플러그인 -->
        <%@ include file = "/resources/include/plugin_cdn.jsp"%>
    <!-- //footer -->
    
</body>
</html>