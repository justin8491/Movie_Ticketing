<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제</title>




<script >
	function paymentWindow(){
		// var str = prompt("안녕하세요");
		// alert(str);
		
		//var window = window.open(url, windowName, [windowFeatures]);
		//let popOption = "width = 650px, height=550px, top=300px, left=300px, scrollbars=yes";
		//let name = "http://localhost:8080/smallbox";
		// window.open(name, windowName, popOption);
		//let popup = window.open('paymentPop', '결제팝업', 'width=700px,height=800px,scrollbars=yes');	
		
		  
		var selectElement = document.getElementById('cardCompany');
		var selectedValue = selectElement.value;
		  // URL에 선택된 값 전달
		var url = 'paymentPop?selectedCard=' + encodeURIComponent(selectedValue);
		let popup = window.open(url, '결제팝업', 'width=700px,height=800px,scrollbars=yes');	
	}

	
	
	
</script>

</head>
<body>

<h3>예매</h3>
<hr>
	<div>
		<h4>등급 할인혜택</h4>
		<h5>고객님의 등급은 ???으로 ???원 할인이 가능합니다.
			<input type="radio" name="sale" value="아니요" checked>아니요
			<input type="radio" name="sale" value="예" >예
		</h5>
	</div>
<hr>
<h3>결제수단선택</h3>	
	<div>
		<input type="radio" name="payment" value="신용/체크카드" checked>신용/체크카드
		<input type="radio" name="payment" value="무통장입금" >무통장입금 
		<hr>
		<h4>카드사선택
			<select  id="cardCompany" name="cardCompany" >
				<optgroup label="카드사"></optgroup>
					<option value="롯데카드">롯데카드</option>
					<option value="비씨카드">비씨카드</option>
					<option value="삼성카드">삼성카드</option>
					<option value="우리카드">우리카드</option>
					<option value="하나카드">하나카드</option>
					<option value="현대카드">현대카드</option>
					<option value="KB국민카드">KB국민카드</option>
				<optgroup label="은행"></optgroup>
					<option value="IBK기업은행">IBK기업은행</option>
					<option value="NH농협은행">NH농협은행</option>	
					<option value="카카오뱅크">카카오뱅크</option>
					<option value="씨티은행">씨티은행</option>
					<option value="SC제일은행">SC제일은행</option>
					<option value="대구은행">대구은행</option>
					<option value="부산은행">부산은행</option>
					<option value="경남은행">경남은행</option>
			</select>			
			<input type="radio" name="paymentType" value="일반결제" onclick="paymentWindow();">일반결제		
		</h4>
	</div>
	
	<div>
		<input type="button" value="이전">
		<input type="button" value="결제">
	</div>

</body>
</html>