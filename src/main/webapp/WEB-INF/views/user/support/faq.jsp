<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <%@ include file = "/resources/include/head_beta.jsp"%>
<title>자주 묻는 질문 페이지입니다.</title>
</head>
<body>
	 <header id="header">
        <%@ include file = "/resources/include/header_beta.jsp"%>
   </header>
	<!-- //메인 콘텐츠-->
	<section class="content">
      <div class="container">
        <div class="row">
        <div class="mb-3">
                <h5 class="card-title text-center" style="font-size: 2.5rem;">자주 묻는 질문 <span class="text-muted fw-normal ms-2"></span></h5>
            </div>
	<table class="table table-hover">
				<tr>
					<th>번호</th><th>제목</th><th>작성자ID</th><th>생성일</th>
				</tr>
			<c:forEach var="board" items="${faqlist }">
				<tr>
					<td>${board.bo_no}</td>
					<td><a href="selectFaq?bo_no=${board.bo_no}">${board.bo_title}</a></td>
					<td>${board.bo_writerId}</td>
					<td>${board.bo_createAt}</td>
				</tr>
			</c:forEach>
				<tr>
					<td colspan = "4"></td>
				</tr>
			
			</table>
</section>
    <!-- //footer -->
    <footer>
        <%@ include file = "/resources/include/footer_beta.jsp"%>
    </footer>
    <!-- 플러그인 -->
        <%@ include file = "/resources/include/plugin_cdn.jsp"%>
</body>
</html>