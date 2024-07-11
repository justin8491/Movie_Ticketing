<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과값</title>
</head>
<body>
	<h2>로그인 결과</h2><br>
	아이디 : ${userID }<br>
	이름 : ${name }<br>
	<hr>
	아이디 : ${info.userID }<br>
    이름 : ${info.name }<br>
    <hr>
    아이디 : ${login.userID }<br>
    이름 : ${login.name }<br>

</body>
</html>