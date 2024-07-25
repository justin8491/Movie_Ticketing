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

   <div class="container">
           <!-- 모달 -->
           <div class="modal" id="searchModal" tabindex="-1" role="dialog" aria-labelledby="searchModal" aria-hidden="true">
               <div class="modal-dialog modal-dialog-centered" role="document">
                   <div class="modal-content">
                       <div class="modal-header">
                           <h5 class="modal-title" id="searchModal">${msg_title}</h5>
                           <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                               <span aria-hidden="true">&times;</span>
                           </button>
                       </div>
                       <div class="modal-body">
                           <strong>${req}</strong>
                           <c:if test="${member != null}">
                               <!-- 다른 내용 추가 가능 -->
                           </c:if>
                       </div>
                       <div class="modal-footer">
                           <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
                       </div>
                   </div>
               </div>
           </div>
       </div>

       <script>
       $(document).ready(function() {
           $('#searchModal').modal('show');
       });
       </script>

    <!-- //메인 콘텐츠-->
    <!-- //메인 콘텐츠-->
      <div class="container mt-5 user-form login-form">
        <div>
           <h2>로그인</h2>
           <form action="${contextPath}/user/login" method="post">
                <input type="text" name="mem_id" id="mem_id" placeholder="아이디"><br>
                <input type="text" name="mem_password" id="mem_password" placeholder="비밀번호"><br>
                <input type="submit" value="로그인">
           </form>
           <div class="login-btn">
                <a href="${contextPath}/user/createMemberForm">회원가입</a>
                <a href="${contextPath}/user/getByIdOrPwd">아이디/비밀번호 찾기</a>
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
