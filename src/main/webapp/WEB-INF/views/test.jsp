<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function cancel(res_no,pay_no) {
	var url ="/test"
	var params ={
			"res_no" : res_no,
			"pay_no" : pay_no
	};
	
	$.ajax({
	  	type: "POST",
	    url: url,
	    data: JSON.stringify(params),
	    contentType: "application/json",
	    dataType: "json",
	    success: function(result) {
                window.alert('예약이 취소되었습니다.');
                location.reload();
        },         
        error: function() {
                window.alert('취소에 실패했습니다.');
        }
});
	
}
</script>

</head>
<body>
<h2>test</h2>





<table>
	<tr>
		<th>예매번호</th>
		<th>영화제목</th>
		<th>상영일자</th>
		<th>영화관</th>
		<th>상영관</th>
		<th>좌석</th>
		<th>예매취소</th>
		</tr>
	<c:forEach var = "reservation" items = "${dataList[0].reservationList}">
		<tr>
			<td>${reservation.res_no}</td>
		
			<c:forEach var ="movie" items = "${dataList[0].movieList}">			
				<c:if test="${movie.mo_no == reservation.mo_no }">
				<td>	${movie.mo_name}</td>
				</c:if>
			</c:forEach>
			<c:forEach var="schedeule" items="${dataList[0].schedeuleList}">
				<c:if test="${schedeule.sch_no == reservation.sch_no }">
					<td>${schedeule.sch_startTime }</td>				
					<c:forEach var="screen" items="${dataList[0].screenList }">
						<c:if test="${screen.sc_no == schedeule.sc_no }">
							<c:forEach var="theater" items="${dataList[0].theaterList }">
								<c:if test="${theater.th_no == screen.th_no }">
								<td>	${theater.th_name }</td>
								</c:if>
							</c:forEach>
							<td>${screen.sc_name }</td>
						</c:if>					
					</c:forEach>
				</c:if>
			</c:forEach>
			<c:forEach var="seat" items ="${ dataList[0].theaterseatList}">
				<c:if test ="${reservation.ts_no == seat.ts_no }">
					<td>${seat.ts_id}</td>	
				</c:if>	
			</c:forEach>
			
		
			<td><button onclick="cancel(${reservation.res_no },${reservation.pay_no })">예매취소</button></td>		
		</tr>		
	</c:forEach>
</table>
</body>
</html>