<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@include file="/resources/include/header.jsp" %>
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">

		<section class="content">
			<div class="container mt-5">
                    <h2>회원정보 변경</h2>
                    <form action="${contextPath}/user/updateMember" method="post">
                        <div class="form-group row">
                            <label for="mem_id" class="col-sm-2 col-form-label">아이디</label>
                            <div class="col-sm-5">
                                <input type="text" name="mem_id" class="form-control" id="mem_id" value="${member.mem_id}" >
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="mem_password" class="col-sm-2 col-form-label">비밀번호</label>
                            <div class="col-sm-10">
                                <input type="text" name="mem_password" class="form-control" id="mem_password" value="${member.mem_password}" placeholder="비밀번호" >
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="mem_name" class="col-sm-2 col-form-label">이름</label>
                            <div class="col-sm-5">
                                <input type="text" name="mem_name" class="form-control" id="mem_name" value="${member.mem_name}" placeholder="이름" >
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="mem_ssn"  class="col-sm-2 col-form-label">주민등록번호</label>
                            <div class="col-sm-5">
                                <input type="text" name="mem_ssn" class="form-control" id="mem_ssn" value="${member.mem_ssn}" placeholder="주민등록번호" >
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="mem_phoneNumber" class="col-sm-2 col-form-label">전화번호</label>
                            <div class="col-sm-5">
                                <input type="text" name="mem_phoneNumber" class="form-control" id="mem_phoneNumber" value="${member.mem_phoneNumber}" placeholder="전화번호" >
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="mem_accumulatedAmount" class="col-sm-2 col-form-label">누적금액</label>
                            <div class="col-sm-5">
                                <input type="text" name="mem_accumulatedAmount" class="form-control" id="mem_accumulatedAmount" value="${member.mem_accumulatedAmount}" placeholder="누적금액" >
                            </div>
                        </div>
                        <!--<div class="form-group row">
                            <label for="mem_status" class="col-sm-2 col-form-label">상태</label>
                            <div class="col-sm-5">
                                <input type="text" name="mem_status" class="form-control" id="mem_status" placeholder="상태">
                            </div>
                        </div> -->
                        <div class="form-group row">
                            <label for="mem_address" class="col-sm-2 col-form-label">주소</label>
                            <div class="col-sm-5">
                                <input type="text" name="mem_address" class="form-control" id="mem_address" value="${member.mem_address}" placeholder="주소" >
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-5 offset-sm-2">
                                <button type="submit" class="btn btn-primary">저장</button>
                                <a class="btn btn-success" href="${contextPath}/user/main">메인</a>
                                <a class="btn btn-warning" href="${contextPath}/user/updateMember/${member.mem_id}">개인정보 변경</a>
                            </div>
                        </div>
                    </form>
                </div>

		</section>
	</div>
<%@include file="/resources/include/footer.jsp" %>
