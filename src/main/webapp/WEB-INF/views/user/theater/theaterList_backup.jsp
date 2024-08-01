<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
    <%@ include file = "/resources/include/head_beta.jsp"%>
</head>
<body>
<header id="header">
<%@ include file = "/resources/include/header_beta.jsp"%>
</header>


    <div class="container">
        <h1 class="text-center page-title">극장 목록</h1> <!-- 제목 클래스 변경 -->
        <div class="row theaterlist">
            <c:forEach var="theater" items="${theaterlist}">
                <div class="col-md-4 mb-4 theater">
                    <div class="text-center">
                        <img src="${contextPath}/resources/images/${theater.th_photo}" alt="${theater.th_name}" class="img-fluid">
                        <div class="theater-name">
                            <a href="${contextPath}/user/theater/theater?th_no=${theater.th_no}">${theater.th_name}</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

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
    <!-- //footer -->
</body>
</html>