<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
   <%@ include file = "/resources/include/header.jsp"%>
    <title>Movie List</title>
    <style>
        .movie-container {
            display: flex;
            flex-wrap: wrap;
        }
        .movie {
            border: 1px solid #ccc;
            margin: 10px;
            padding: 10px;
            width: 200px;
            text-align: center;
        }
        .movie img {
            width: 100%;
            height: auto;
        }
        .movie-name {
            font-weight: bold;
        }
    </style>
</head>
<!-- /resources/images/mo1.jpg -->
<body>
    <h1>Movie List</h1>
    <div class="movie-container">
        <c:forEach var = "movie" items="${movielist}">
            <div class="movie">
                <img src="${contextPath}${movie.mo_photoURL}" alt="${movie.mo_name}">
                <div class="movie-name"><a href = "${contextPath}/user/movie/detailMovie?mo_no=${movie.mo_no }">${movie.mo_name}</a></div>
            </div>
        </c:forEach>
    </div>
</body>
</html>