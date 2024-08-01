<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
  <head>
<%@ include file = "/resources/include/head_beta.jsp"%>

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
        
<style>
body{margin-top:20px;
}
.project-list-table {
    border-collapse: separate;
    border-spacing: 0 12px
}

.project-list-table tr {
    background-color: #eee;
    text-align : center;
}

.table-nowrap td, .table-nowrap th {
    white-space: nowrap;
}
.table-borderless>:not(caption)>*>* {
    border-bottom-width: 0;
}
.table>:not(caption)>*>* {
    padding: 0.75rem 0.75rem;
    background-color: var(--bs-table-bg);
    border-bottom-width: 1px;
    box-shadow: inset 0 0 0 9999px var(--bs-table-accent-bg);
}

.avatar-sm {
    height: 2rem;
    width: 2rem;
}
.rounded-circle {
    border-radius: 50%!important;
}
.me-2 {
    margin-right: 0.5rem!important;
}
img, svg {
    vertical-align: middle;
}

a {
    color: #3b76e1;
    text-decoration: none;
}
.px-2 text-primary{
	color: #3b76e1;
    text-decoration: none;
}

.badge-soft-danger {
    color: #f56e6e !important;
    background-color: rgba(245,110,110,.1);
}
.badge-soft-success {
    color: #63ad6f !important;
    background-color: rgba(99,173,111,.1);
}

.badge-soft-primary {
    color: #3b76e1 !important;
    background-color: rgba(59,118,225,.1);
}

.badge-soft-info {
    color: #57c9eb !important;
    background-color: rgba(87,201,235,.1);
}

.avatar-title {
    align-items: center;
    background-color: #3b76e1;
    color: #fff;
    display: flex;
    font-weight: 500;
    height: 100%;
    justify-content: center;
    width: 100%;
}
.bg-soft-primary {
    background-color: rgba(59,118,225,.25)!important;
}
table.admtheaterDetail button.deleteBtn{
	background-color: transparent;
	padding:0;
	border:none;
	box-shadow: none
	}

 </style>
  </head>
  <body>
   <header id="header">
            <%@ include file="/resources/include/headerAdmin_beta.jsp"%>
   </header>
    <!-- //메인 콘텐츠-->
    <section class="content">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/boxicons/2.1.0/css/boxicons.min.css" integrity="sha512-pVCM5+SN2+qwj36KonHToF2p1oIvoU3bsqxphdOIWMYmgr4ZqD3t5DjKvvetKhXGc/ZG5REYTT6ltKfExEei/Q==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/MaterialDesign-Webfont/5.3.45/css/materialdesignicons.css" integrity="sha256-NAxhqDvtY0l4xn+YVa6WjAcmd94NNfttjNsDmNatFVc=" crossorigin="anonymous" />


<div class="container">
	<table class="table project-list-table table-nowrap align-middle table-borderless admtheaterDetail">
		<thead>
			<tr>
				<th scope="col">예매번호</th>
				<th scope="col">고객</th>
				<th scope="col">영화제목</th>
				<th scope="col">상영일자</th>
				<th scope="col">영화관</th>
				<th scope="col">상영관</th>
				<th scope="col">좌석</th>
				<th scope="col">예매취소</th>
			</tr>
		</thead>
		<c:forEach var = "reservation" items = "${dataList[0].reservationList}">
			<tr>
				<td>${reservation.res_no}</td>
				<td>${reservation.mem_id}</td>
			
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
				
			
				<td><i class="bx bx-trash-alt font-size-18 " onclick="cancel(${reservation.res_no },${reservation.pay_no })"></i></td>	
				
			</tr>		
		</c:forEach>
	</table>
</div>









    </section>
    <!-- //footer -->
    <footer>
        <%@ include file = "/resources/include/footer_beta.jsp"%>
    </footer>
    <!-- 플러그인 -->
        <%@ include file = "/resources/include/plugin_cdn.jsp"%>
  </body>
</html>
