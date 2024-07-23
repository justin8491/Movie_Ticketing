<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 작성 페이지</title>
</head>
<body>
	<h1>게시판 작성</h1>
	<form action="freeBoardWrite" method="post">
	
        <label for="writerId">작성자:</label><br>
        <input type="text" id="writerId" name="bo_writerId" required><br><br>
        
        <label for="title">제목:</label><br>
        <input type="text" id="title" name="bo_title" required><br><br>
        
        <label for="content">내용:</label><br>
        <textarea id="content" name="bo_content" rows="4" cols="50" required></textarea><br><br>
        
        <input type="submit" value="작성하기">
    </form>
	
</body>
</html>