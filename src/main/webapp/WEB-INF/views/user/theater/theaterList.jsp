<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <%@ include file = "/resources/include/head_beta.jsp"%>
    <title>극장 목록</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
    .theater img {
	width: 100%;
	height: auto;
	}
	.theater-name {
	font-size: 1.2rem;
	font-weight: bold;
	}
    .page-title {
	font-size: 2.5rem; /* 제목 크기 조정 */
	font-weight: bold;
	margin-top: 20px; /* 위쪽 여백 추가 */
     }
    </style>
</head>
<body>
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

    <!-- Bootstrap JS and dependencies (optional but recommended) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>