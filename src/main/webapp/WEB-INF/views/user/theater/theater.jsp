<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <%@ include file = "/resources/include/header.jsp"%>
<title>theater</title>
</head>
<body>
	<h1>상세극장 페이지 입니다!</h1>
	<div class="theater-container">
            <div class="theater">
                <img src="${contextPath}/resources/images/${theater.th_photo}" alt="${theater.th_name}" class="img-fluid">
				<p>영화관 이름 : "${theater.th_name}"</p>
				<p>영화관 주소 : "${theater.th_location}"</p>
				<p> : "${theater.th_photo}"</p>
            </div>
    </div>
</body>
</html>