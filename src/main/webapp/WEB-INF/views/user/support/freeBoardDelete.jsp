<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제</title>
</head>
<body>
	<h1>삭제하시겠습니까?</h1>
	<form action="freeBoardDelete?bo_no=${sp.bo_no}" method="post">
        <input type="hidden" name="bo_no" value="${sp.bo_no}">
        <a>bo_no : ${sp.bo_no}</a>
    	<input type="submit" value="삭제하기">
    </form>
</body>
</html>