<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 헤더쪽에 path있음 -->
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제</title>
<%@ include file = "/resources/include/head_beta.jsp"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	let CardPassword = 0;
	let isCardChecked = false;
	let cardCompany = '';
	
	function showPaymentForm() {
        const paymentForm = document.getElementById('paymentForm');
        paymentForm.style.display = 'block'; // 보이기
    }
		
	// 카드번호 조합
	function getCardNumber() {
        const card1 = document.getElementById('card1').value;
        const card2 = document.getElementById('card2').value;
        const card3 = document.getElementById('card3').value;
        const card4 = document.getElementById('card4').value;
        const cardCompanySelect = document.getElementById('cardCompany');
        
       
        // 카드사 선택
        cardCompany = cardCompanySelect.options[cardCompanySelect.selectedIndex].value;

        const cardNumber = card1 + card2 + card3 + card4;     

        // 데이터베이스에서 검사
        cardCheck(cardNumber, cardCompany);
        
        // 숨겨진 입력 필드에 카드 번호 설정
        document.getElementById('ca_id').value = cardNumber;
	}
	
	// 카드번호 체크
	function cardCheck(cardNumber, cardCompany) {
		var url = "/user/payment/payment";
		
		const memId = document.getElementById('mem_id').value;

        const params = {
            "ca_id": cardNumber,
            "ca_cardCompany": cardCompany,
            "mem_id": memId
        };

		$.ajax({
			type: "POST",
			url: url,
			data: JSON.stringify(params),
			contentType: "application/json",
			dataType: "json",
			success: function(result) {
				
					window.alert('카드번호가 확인되었습니다.');
					CardPassword = result.ca_password;
					isCardChecked = true;
				
			},
			error: function() {
				window.alert('카드번호와 카드사가 일치하지 않습니다.');
				isCardChecked = false;
			}
		});
	}

	// 결제 전 확인
	function checkForm() {
		if (!isCardChecked) {
			alert("카드를 확인해주세요.");
			return false;
		}

		const passwordField = document.querySelector('input[name="password"]');
		if (!passwordField.value) {
			alert("비밀번호를 입력하세요.");
			return false;
		}

		// 비밀번호 일치 여부 체크
		if (passwordField.value != CardPassword) {
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}

		const checkbox = document.querySelector('input[name="box"]:checked');
		if (!checkbox) {
			alert("결제대행 서비스 약관에 모두 동의해야 합니다.");
			return false;
		}
		
		alert("예매가 완료되었습니다.");
	}
</script>

<style>
   

    #content {
        max-width: 800px; /* 최대 폭 설정 */
        margin: 0 auto; /* 좌우 중앙 정렬 */
        padding: 20px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h3, h4 {
        margin-top: 0;
        
    }
    
    h1{
    	font-size: 20px;
    }

    form input[type="text"] {
        width: 60px;
        margin-right: 5px;
    }

    button {
        padding: 10px 20px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        margin-top: 15px;
        margin-bottom: 15px;
    }

    button:hover {
        background-color: #0056b3;
    }
</style>

</head>
<body>
<header id="header">
	<%@ include file = "/resources/include/header_beta.jsp"%>
</header>

<div id="content">
	<h1>예매</h1>

	<hr>
	<h3>결제수단선택</h3>	
		<div>
			<input type="radio" name="payment" value="신용/체크카드" checked>신용/체크카드
			<input type="radio" name="payment" value="무통장입금" >무통장입금 
			<hr>
			<h4>카드사선택
				<select id="cardCompany" name="cardCompany">
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
				<input type="radio" name="paymentType" value="일반결제" onclick="showPaymentForm();">일반결제		
			</h4>
		</div>
		<div id="paymentForm" style="display: none;">
			<hr>	
			<div>
				<form id="cardForm">
			        <input type="text" id="card1" maxlength="4" placeholder="0000"> -
			        <input type="text" id="card2" maxlength="4" placeholder="0000"> -
			        <input type="text" id="card3" maxlength="4" placeholder="0000"> -
			        <input type="text" id="card4" maxlength="4" placeholder="0000">
			    </form>
			    <button onclick="getCardNumber()">카드번호 확인</button>
			</div>
		    <!-- 티켓 계산식 -->
		  	<% 
		       int baseAmount = 15000;
		       int reservtionCnt = (Integer) request.getAttribute("reservtionCnt");
		       int payAmount = baseAmount * reservtionCnt;
			%>
			<h4>비밀번호 <input type="text" name="password" placeholder="4자리를 입력해주세요"></h4>		
			<div>
			<input type="checkbox" name="box">결제대행 서비스 약관에 모두 동의
			<h4>전자금융거래 이용약관> 개인정보의 수 및 이용안내> 개인정보 제공 및 위탁안내></h4>
			</div>
		   	 
			<form name="check" action="/" method="post" onsubmit="return checkForm()">
				<input type="hidden" name="ca_id" id="ca_id" value="">
				<input type="hidden" name="mo_no" id="mo_no" value="<%= request.getParameter("mo_no") %>">
			    <input type="hidden" name="th_no" id="th_no" value="<%= request.getParameter("th_no") %>">
			    <input type="hidden" name="sc_no" id="sc_no" value="<%= request.getParameter("sc_no") %>" >
			    <input type="hidden" name="sch_no" id="sch_no" value="<%= request.getParameter("sch_no") %>"> 
			    <input type="hidden" name="ts_list" id="ts_list" value="${ts_list }"> 
			    <input type="hidden" name="ts_no" id="ts_no" value="<%= request.getParameter("ts_no") %>"> 
			    <input type="hidden" name="pay_amount" id="pay_amount" value="<%= payAmount %>">
			    <input type="hidden" name="reservtionCnt" id="reservtionCnt" value="<%= reservtionCnt %>">
			    <input type="hidden" name="pay_amount" id="pay_amount" value="<%= payAmount %>"> 
			   	<input type="hidden" name="mem_id" id="mem_id" value="${member.mem_id }">
				<button type="submit" value="결제">결제</button>
			</form>
		</div>
</div>

<!-- //footer -->
<footer>
    <%@ include file = "/resources/include/footer_beta.jsp"%>
</footer>
<!-- 플러그인 -->
<%@ include file = "/resources/include/plugin_cdn.jsp"%>

</body>
</html>