<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
  <head>
        <%@ include file = "/resources/include/head_beta.jsp"%>
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
   <header id="header">
        <%@ include file = "/resources/include/header_beta.jsp"%>
   </header>
    <!-- //메인 콘텐츠-->
    <section class="content">
      <div class="container mt-5">
                <h2>회원정보 상세보기</h2>
                <div class="memberInfo border">
                  <form class="float_form row">
                    <div class="form-group row float">
                      <div class="box">
                        <label for="mem_id" class="col-sm-2 col-form-label"
                          >아이디</label
                        >
                        <div class="col-sm-10">
                          <input
                            type="text"
                            class="form-control"
                            id="mem_id"
                            value="${member.mem_id}"
                            readonly
                          />
                        </div>
                      </div>
                    </div>
                    <div class="form-group row float">
                      <div class="box">
                        <label for="mem_password" class="col-sm-2 col-form-label"
                          >비밀번호</label
                        >
                        <div class="col-sm-10">
                          <input
                            type="text"
                            class="form-control"
                            id="mem_password"
                            value="${member.mem_password}"
                            placeholder="비밀번호"
                            readonly
                          />
                        </div>
                      </div>
                    </div>
                    <div class="form-group row float">
                      <div class="box">
                        <label for="mem_name" class="col-sm-2 col-form-label"
                          >이름</label
                        >
                        <div class="col-sm-10">
                          <input
                            type="text"
                            class="form-control"
                            id="mem_name"
                            value="${member.mem_name}"
                            placeholder="이름"
                            readonly
                          />
                        </div>
                      </div>
                    </div>
                    <div class="form-group row float">
                      <div class="box">
                        <label for="mem_ssn" class="col-sm-2 col-form-label"
                          >주민번호</label
                        >
                        <div class="col-sm-10">
                          <input
                            type="text"
                            class="form-control"
                            id="mem_ssn"
                            value="${member.mem_ssn}"
                            placeholder="주민등록번호"
                            readonly
                          />
                        </div>
                      </div>
                    </div>
                    <div class="form-group row float">
                      <div class="box">
                        <label for="mem_phoneNumber" class="col-sm-2 col-form-label"
                          >전화번호</label
                        >
                        <div class="col-sm-10">
                          <input
                            type="text"
                            class="form-control"
                            id="mem_phoneNumber"
                            value="${member.mem_phoneNumber}"
                            placeholder="전화번호"
                            readonly
                          />
                        </div>
                      </div>
                    </div>
                    
                      <div class="form-group row float">
                      <div class="box">
                        <label for="mem_address" class="col-sm-2 col-form-label"
                          >주소</label
                        >
                        <div class="col-sm-10">
                          <input
                            type="text"
                            class="form-control"
                            id="mem_address"
                            value="${member.mem_address}"
                            placeholder="주소"
                            readonly
                          />
                        </div>
                      </div>
                    </div>
                    
                    <div class="form-group row float">
                      <div class="box">
                        <label
                          for="mem_accumulatedAmount"
                          class="col-sm-2 col-form-label"
                          ></label
                        >
                        <div class="col-sm-10">
                          <input
                            type="hidden"
                            class="form-control"
                            id="mem_accumulatedAmount"
                            value="${member.mem_accumulatedAmount}"
                            placeholder="누적금액"
                            readonly
                          />
                        </div>
                      </div>
                    </div>

                  
                    
                    <div class="form-group row float">
                      <div class="box">
                        <div class="offset-sm-2">
                          <!-- <a class="btn btn-success" href="${contextPath}/user/main"
                                >메인</a
                              > -->
                          <a
                            class="btn btn-warning"
                            href="${contextPath}/user/updateMemberForm"
                            >개인정보 변경</a
                          >
                        </div>
                      </div>
                    </div>
                  </form>
                </div>
              </div>
              <div class="container mt-5">
                <h2>예약 내역</h2>
                <div class="reservationInfo border heihgt">
	                <table style="width: 100%; border-collapse: collapse; text-align: center;">
	                   <tr style="background-color: #f2f2f2;">
	                       <th style="border: 1px solid #ddd; padding: 8px;">예매번호</th>
	                       <th style="border: 1px solid #ddd; padding: 8px;">영화제목</th>
	                       <th style="border: 1px solid #ddd; padding: 8px;">상영일자</th>
	                       <th style="border: 1px solid #ddd; padding: 8px;">영화관</th>
	                       <th style="border: 1px solid #ddd; padding: 8px;">상영관</th>
	                       <th style="border: 1px solid #ddd; padding: 8px;">좌석</th>
	                       <th style="border: 1px solid #ddd; padding: 8px;">예매취소</th>
	                   </tr>
	                   <c:forEach var="reservation" items="${dataList[0].reservationList}">
	                       <tr>
	                           <td style="border: 1px solid #ddd; padding: 8px;">${reservation.res_no}</td>
	                           <c:forEach var="movie" items="${dataList[0].movieList}">
	                               <c:if test="${movie.mo_no == reservation.mo_no }">
	                                   <td style="border: 1px solid #ddd; padding: 8px;">${movie.mo_name}</td>
	                               </c:if>
	                           </c:forEach>
	                           <c:forEach var="schedeule" items="${dataList[0].schedeuleList}">
	                               <c:if test="${schedeule.sch_no == reservation.sch_no }">
	                                   <td style="border: 1px solid #ddd; padding: 8px;">${schedeule.sch_startTime}</td>
	                                   <c:forEach var="screen" items="${dataList[0].screenList }">
	                                       <c:if test="${screen.sc_no == schedeule.sc_no }">
	                                           <c:forEach var="theater" items="${dataList[0].theaterList }">
	                                               <c:if test="${theater.th_no == screen.th_no }">
	                                                   <td style="border: 1px solid #ddd; padding: 8px;">${theater.th_name}</td>
	                                               </c:if>
	                                           </c:forEach>
	                                           <td style="border: 1px solid #ddd; padding: 8px;">${screen.sc_name}</td>
	                                       </c:if>
	                                   </c:forEach>
	                               </c:if>
	                           </c:forEach>
	                           <c:forEach var="seat" items="${dataList[0].theaterseatList}">
	                               <c:if test="${reservation.ts_no == seat.ts_no }">
	                                   <td style="border: 1px solid #ddd; padding: 8px;">${seat.ts_id}</td>
	                               </c:if>
	                           </c:forEach>
	                           <td style="border: 1px solid #ddd; padding: 8px;">
	                               <button onclick="cancel(${reservation.res_no}, ${reservation.pay_no})" style="padding: 5px 10px; border: none; background-color: #f44336; color: white; cursor: pointer;">예매취소</button>
	                           </td>
	                       </tr>
	                   </c:forEach>
	               </table>
                </div>
              </div>
              <div class="container diviContainer">
                <div class="container rem_1">
                  <h2>나의 리뷰</h2>
                  <div class="reviewInfo border heihgt">
                  <c:forEach var="item" items="${reviewList}">
                    <div class="review-item" id="review-${item.rev_no}">
                      <!-- 사용자 아이디 주석 -->
                      <!-- <span>${item.mem_id}</span> -->
                      <!-- 영화 제목 표시 할 방법 찾기 -->
                      <span>${item.mo_name}</span>
                      <span class="review-content" id="review-content-${review.rev_no}"
                        >${item.rev_content}</span
                      >
                      <div
                        class="star-rating"
                        id="review-rating-${review.rev_no}"
                        title="Rated ${item.rev_rating}.00 out of 5"
                      >
                        <span style="width:${item.rev_rating * 20}%">
                          <strong class="rating">${item.rev_rating}.00</strong> out of 5
                        </span>
                      </div>
                      <span>${item.rev_createdAt}</span>
                    </div>
                  </c:forEach>
                  </div>
                </div>
                <div class="container rem_2">
                  <h2>나의 글</h2>
                  <div class="boardInfo border heihgt"></div>
                </div>
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
