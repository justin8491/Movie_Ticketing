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
      <div class="container">
        <div class="row">
           <h1>로그인</h1>
           <form action="${contextPath}/user/login" method="post">
                ID : <input type="text" name="mem_id" id="mem_id"><br>
                PW : <input type="text" name="mem_password" id="mem_password">
                <input type="submit" value="로그인">
           </form>
           <a href="${contextPath}/user/createMemberForm">회원가입</a>
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
