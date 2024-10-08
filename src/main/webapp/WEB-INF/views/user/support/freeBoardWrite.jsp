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
   <div class="container">
    <div class="row align-items-center">
        <div class="col-md-6">
            <div class="mb-3">
            </div>
         <div>
          <c:if test="${member.mem_id==null }">
             <script type="text/javascript">
                 // 로그인 필요 알림을 띄우고 로그인 페이지로 리디렉션
                 alert("로그인 하셔야 합니다.");
                 window.location.href = '/user/loginForm'; // 로그인 페이지 URL로 리디렉션
                </script>
          </c:if>     
          <c:if test="${member.mem_id!=null }">
             
   <h1>게시판 작성</h1>
   <form action="freeBoardWrite" method="post">
   
        <label for="writerId"></label><br>
        <input type="hidden" id="writerId" name="bo_writerId" value = "${member.mem_id}"><br><br>
        
        <label for="title">제목:</label><br>
        <input type="text" id="title" name="bo_title" required><br><br>
        
        <label for="content">내용:</label><br>
        <textarea id="content" name="bo_content" rows="4" cols="50" required></textarea><br><br>
        
        <input type="submit" value="작성하기">
    </form>
          </c:if>       
         </div>
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