<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<%@ include file = "/resources/include/head_beta.jsp"%>
</head>
<body>
   <header id="header">
        <%@ include file = "/resources/include/header_beta.jsp"%>
   </header>
	<!-- //메인 콘텐츠-->
	 <section class="content">
      <div class="container">
        <div class="row">
	<div><a href="${contextPath}/admin/support/adminNotice">공지사항 페이지</a></div>
	<div><a href="${contextPath}/admin/support/adminFaq">자주 묻는 질문 페이지</a></div>
	<div><a href="${contextPath}/admin/support/adminInquiry">1대1 문의 페이지 리스트</a></div>
	<div><a href="${contextPath}/admin/support/adminFreeBoard">자유게시판 페이지</a></div>
	</section>
	
    <!-- //footer -->
    <footer>
        <%@ include file = "/resources/include/footer_beta.jsp"%>
    </footer>
    <!-- 플러그인 -->
        <%@ include file = "/resources/include/plugin_cdn.jsp"%>
</body>
</html>