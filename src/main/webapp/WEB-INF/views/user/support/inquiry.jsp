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
	<c:if test="${member.mem_id==null }">
		<script type="text/javascript">
			alert("로그인 후 이용 가능합니다");
			 history.back();
		</script>
 				
 			</c:if>     
 			<c:if test="${member.mem_id!=null }">
	<section class="content">
			<div>∴고객님의 문의에 답변하는 직원은 고객 여러분의 가족 중 한 사람일 수 있습니다.<br>
				 고객의 언어폭력(비하, 욕설, 협박, 성희롱 등)으로부터 직원을 보호하기 위해<br>
				 관련 법에 따라 수사기관에 필요한 조치를 요구할 수 있으며, 형법에 의해 처벌 대상이 될 수 있습니다.</div><br>
			<div>∴문의하시기 전 FAQ를 확인하시면 궁금증을 더욱 빠르게 해결하실 수 있습니다.</div>
			<form action= "inquiry" method = "post" >
		<p><input type = "hidden" name = "bo_writerId" value = "${member.mem_id }"><br></p>
		<p>제목 : <input type = "text" name = "bo_title"><br></p>
		<p>내용 : <input type = "text" name = "bo_content" style="height:700px; width: 1000px;"  ><br></p>
	
		<input type = "submit" value = "확인"> 
	</form>
 			</c:if>
	
		</section>
	
    <!-- //footer -->
    <footer>
        <%@ include file = "/resources/include/footer_beta.jsp"%>
    </footer>
    <!-- 플러그인 -->
        <%@ include file = "/resources/include/plugin_cdn.jsp"%>

</body>
</html>