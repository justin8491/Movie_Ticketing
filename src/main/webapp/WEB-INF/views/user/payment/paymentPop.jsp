<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팝업창</title>
</head>
<body>

<script type="text/javascript">


</script>

	<h2>${cardCompany}</h2>
	<hr>
	<div>
		<h4>카드번호 <input type="text">-<input type="text">-<input type="text">-<input type="text"></h4>
		<h4>유효기간 <input type="text">/<input type="text"></h4>
		<h4>비밀번호 <input type="text"> 앞 2자리</h4>
		<h4>생년월일 <input type="text"> 생년월일 6자리(카드소유자)사업자리 10자리</h4>
	</div>
		<input type="checkbox">결제대행 서비스 약관에 모두 동의
		<h4>전자금융거래 이용약관> 개인정보의 수 및 이용안내> 개인정보 제공 및 위탁안내></h4>
		<input type="button" value="취소">
		<input type="button" value="결제">
	</body>
</html>