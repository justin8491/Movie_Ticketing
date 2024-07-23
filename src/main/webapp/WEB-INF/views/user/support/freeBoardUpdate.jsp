<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<h1>게시글 수정하기</h1>
	<section class="content">
			<div><h1>사원정보 수정</h1>
			</div>
			<form action= "freeBoardUpdate?bo_no=${sp.bo_no }" method = "post" >
		<p>작성자 : <input type = "text" name = "bo_writerId"><br></p>
		<p>제목 : <input type = "text" name = "bo_title"><br></p>
		<p>내용 : <input type = "text" name = "bo_content"><br></p>
		<input type = "submit" value = "확인"> 
	</form>
		</section>
</body>
</html>