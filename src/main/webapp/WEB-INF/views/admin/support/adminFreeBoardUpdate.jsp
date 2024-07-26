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
	<h1>게시글 수정하기</h1>
	<section class="content">
			</div>
			<form action= "adminFreeBoardUpdate?bo_no=${sp.bo_no }" method = "post" >
		<p>작성자 : <input type = "text" name = "bo_writerId"><br></p>
		<p>제목 : <input type = "text" name = "bo_title"><br></p>
		<p>내용 : <input type = "text" name = "bo_content"><br></p>
		<input type = "submit" value = "확인"> 
	</form>
		</section>
		</section>
    <!-- //footer -->
    <footer>
        <%@ include file = "/resources/include/footer_beta.jsp"%>
    </footer>
    <!-- 플러그인 -->
        <%@ include file = "/resources/include/plugin_cdn.jsp"%>
</body>
</html>