<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<h1>로그인</h1>

<form action="${contextPath}/user/login" method="post">
ID : <input type="text" name="mem_id" id="mem_id">
PW : <input type="text" name="mem_password" id="mem_password">
<input type="submit" value="로그인">
</form>

</body>
</html>












