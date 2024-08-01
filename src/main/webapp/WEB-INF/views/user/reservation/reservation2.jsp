<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 헤더쪽에 path있음 -->
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<!DOCTYPE html>
<html >

<head>
<meta charset="UTF-8">
<%@ include file = "/resources/include/head_beta.jsp"%>  
<title>예매사이트</title>

<style>
#container{
    display: flex;
    flex-direction: column;
    justify-content: center;	/*세로정렬*/
    align-items: center;	  /*가로정렬*/ 
    height: 800px;

}

.showcase{
    background-color: #777;
    background: rgba(0, 0, 0, 0.1);
    border-radius: 5px;
    display: flex;
    justify-content: center;
    margin: 16px 0;
    padding: 5px 10px;
}

.movieContainer select{
    margin: 10px;
    padding: 5px 15px 5px 15px;
    border-radius: 7px;
    appearance: none;
    border: 0;
}

li{
    display: flex;
    justify-content: center;
    align-items: center;
    margin-left: 10px;
}

.small{
    color: #777;
    margin-left: 2px;
}

.showcase .seat:hover{
    cursor: default;
    scale: 1;
}

.showcase .selectedSeat:hover{
    cursor: default;
    scale: 1;
}

.screen{
   background-color: #444451;
   margin: 25px;
   padding: 5px;
   width: 140px;
   height: 80px;
   transform: rotateX(-45deg);
   box-shadow: 0 3px 10px rgb(255 255 255 / 70%);
}

.seat{
    background-color: #444451;
    width: 15px;
    height: 12px;
    margin: 3px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    cursor: pointer;
}

.availableSeat{
    background-color: #444451;
    width: 15px;
    height: 12px;
    margin: 3px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    cursor: default;
}

.selectedSeatIcon{
    background-color: #6feaf6;
    width: 15px;
    height: 12px;
    margin: 3px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    cursor: default;
}

.seat:hover{
    scale: 1.2;
}

.selectedSeat:hover{
    scale: 1.2;
}

.selectedSeat{
    background-color: #6feaf6;
    width: 15px;
    height: 12px;
    margin: 3px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    cursor: pointer;
}

.occupiedSeat{
    background-color: red;
    width: 15px;
    height: 12px;
    margin: 3px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
}

.row{
    display: flex;
    justify-content: center;
}

.text{
    margin-top: 30px;
    padding: 20px;
}

#count{
    color: #6feaf6;
}

#costs{
    color: #6feaf6;
}

</style>

<script>

document.addEventListener('DOMContentLoaded', () =>{

const seatContainer = document.querySelector('.seatContainer');
let count = document.querySelector('#count'); // 인원수
const form = document.querySelector('form');

// 선택한 좌석수 텍스트 변경해주기

function countSeatPrice(){
    const selectedSeatCount = document.querySelectorAll('.selectedSeat').length;
    count.textContent = selectedSeatCount;
}

// 선택좌석 저장
 function updateSelectedSeats() {
       const selectedSeats = document.querySelectorAll('.selectedSeat');
       const seatNames = Array.from(selectedSeats).map(seat => seat.getAttribute('name')).filter(name => name);
       document.querySelector('input[name="ts_no"]').value = seatNames.join(',');
   }


//좌석 클릭했을때

seatContainer.addEventListener('click', (e) => {

    if(e.target.className === 'seat'){
        e.target.className = 'selectedSeat';
    } else if(e.target.className === 'selectedSeat'){
        e.target.className = 'seat';
    }

    countSeatPrice();
    updateSelectedSeats();
})

form.addEventListener('submit', (e) => {
    updateSelectedSeats();
});
})

</script>
</head>

    
<body>
<header id="header">
	<%@ include file = "/resources/include/header_beta.jsp"%>
</header>
	
<div id="container">
	<form action="/user/payment/payment" method="get">
		<ul class="showcase">
		    <li>
		        <div class="availableSeat"></div>
		        <small class="small">Available Seat</small>
		    </li>
		    <li>
		        <div class="selectedSeatIcon"></div>
		        <small class="small">Selected Seat</small>
		    </li>
		    <li>
		        <div class="occupiedSeat"></div>
		        <small class="small">Occupied Seat</small>
		    </li>
		</ul>
		<%
		String sch_no = request.getParameter("sch_no");
		pageContext.setAttribute("sch_no", sch_no);
		%>
		
		<div class="seatContainer">
		   <c:forEach var="rowChar" items="${alphabetList}">
				<div class="row">
				    <c:forEach var="seat" items="${params.theaterSeatList}">
						<c:if test="${seat.sch_no == sch_no }">
							<c:if test="${seat.ts_id.startsWith(rowChar)}">
								<span class="${seat.ts_reservationStatus == 0 ? 'seat' : 'occupiedSeat'}" name="${seat.ts_no}" ></span>
							</c:if>
						</c:if>
					</c:forEach>
				</div>
			</c:forEach>
	    </div>
	    <p class="text">You have selected <span id="count">0</span> seats for a price of $ <span id="costs">0</span></p>
	 	<button >결제test</button>
	<input type="hidden" name="mo_no" id="mo_no" value="<%= request.getParameter("mo_no") %>">
	<input type="hidden" name="th_no" id="th_no" value="<%= request.getParameter("th_no") %>">
	<input type="hidden" name="sc_no" id="sc_no" value="<%= request.getParameter("sc_no") %>" >
	<input type="hidden" name="sch_date" id="sch_date" value="<%= request.getParameter("sch_date") %>"> 
	<input type="hidden" name="sch_no" id="sch_no" value="<%= request.getParameter("sch_no") %>">
	<input type="hidden" name="ts_no" id="ts_no" value="">
 	</form>
</div>

	
<!-- //footer -->
<footer>
	<%@ include file = "/resources/include/footer_beta.jsp"%>
</footer>
<!-- 플러그인 -->
<%@ include file = "/resources/include/plugin_cdn.jsp"%>

</body>

</html>
