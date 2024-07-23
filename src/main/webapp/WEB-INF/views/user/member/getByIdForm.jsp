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
           <h1>아이디 찾기</h1>
           <form action="${contextPath}/user/getById" method="post">
                이름     : <input type="text" name="mem_name" id="mem_name"><br>
                전화번호 : <input type="text" name="mem_phoneNumber" id="mem_phoneNumber">
                <input type="submit" value="아이디 찾기">
           </form>
            <br>
           <h1>비밀번호 찾기 찾기</h1>
                <form action="${contextPath}/user/getByPwd" method="post">
                ID    : <input type="text" name="mem_id" id="mem_id"><br>
                Email : <input type="text" name="mem_email" id="mem_password">
              <input type="submit" value="비밀번호 찾기">
           </form>
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
