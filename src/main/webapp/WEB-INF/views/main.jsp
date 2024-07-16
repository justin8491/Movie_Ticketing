<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@include file="./test/include/header.jsp" %>

<%

%>

	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">

		<section class="content">
			<div>
				 <h1>메인페이지</h1>
			</div>

			<c:if test="${member != null}">
                <div>
                    <p>${member.mem_name}</p>
                    <a href="${contextPath}/user/loginForm">로그아웃</a>
                </div>
			</c:if>

			<c:if test="${member == null}">
                 <div>
                    <a href="${contextPath}/user/loginForm">로그인하기</a>
                 </div>
            </c:if>
		</section>
	</div>
<%@include file="./test/include/footer.jsp" %>
