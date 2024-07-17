<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1대1 문의 페이지 입니다.</title>
</head>
<body>
	<h1>1대1 문의 페이지 입니다.</h1>
	
	<section class="content">
			<div>∴고객님의 문의에 답변하는 직원은 고객 여러분의 가족 중 한 사람일 수 있습니다.<br>
				 고객의 언어폭력(비하, 욕설, 협박, 성희롱 등)으로부터 직원을 보호하기 위해<br>
				 관련 법에 따라 수사기관에 필요한 조치를 요구할 수 있으며, 형법에 의해 처벌 대상이 될 수 있습니다.</div><br>
			<div>∴문의하시기 전 FAQ를 확인하시면 궁금증을 더욱 빠르게 해결하실 수 있습니다.</div>
			<form action= "insert" method = "post" >
		<p>제목 : <input type = "text" name = "bo_title"><br></p>
		<p>내용 : <input type = "text" name = "bo_content"><br></p>
	
		<input type = "submit" value = "확인"> 
	</form>
		</section>

</body>
</html>