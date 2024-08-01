<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
  <head>
        <%@ include file = "/resources/include/head_beta.jsp"%>
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
                        <label
                          for="mem_accumulatedAmount"
                          class="col-sm-2 col-form-label"
                          >누적금액</label
                        >
                        <div class="col-sm-10">
                          <input
                            type="text"
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
                <div class="reservationInfo border heihgt"></div>
              </div>
              <div class="container diviContainer">
                <div class="container rem_1">
                  <h2>나의 리뷰</h2>
                  <div class="reviewInfo border heihgt">
                  <c:forEach var="item" items="${reviewList}">
                    <div class="review-item" id="review-${item.rev_no}">
                      <!-- 사용자 아이디 주석 -->
                      <!-- 영화 제목 표시 할 방법 찾기 -->
                      <a href="${contextPath}/user/movie/detailMovie?mo_no=${item.mo_no}">${item.mo_name}</a>
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
