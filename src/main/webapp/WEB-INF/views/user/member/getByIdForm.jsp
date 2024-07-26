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
<section class="container">
    <div class="row">
        <div class="getBy-form">
           <div>
              <h2>아이디 찾기</h2> <br>
              <form action="${contextPath}/user/selectById" method="post">
                <input type="text" name="mem_name" id="mem_name" placeholder="이름"/><br/>
                <input type="text" name="mem_phoneNumber" id="mem_phoneNumber" placeholder="전화번호"/><br/>
                <input type="submit" value="아이디 찾기" />
              </form>
          </div>

          <div>
              <h2>비밀번호 찾기</h2> <br>
              <form action="${contextPath}/user/selectByPwd" method="post">
                <input type="text" name="mem_id" id="mem_id" placeholder="이름"/><br/>
                <input type="text" name="mem_phoneNumber" id="mem_phoneNumber" placeholder="전화번호"/><br/>
                <input type="submit" value="비밀번호 찾기" />
              </form>
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
