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
    <!-- //메인 콘텐츠-->
      <div class="container mt-5 user-form login-form">
        <div>
           <h2>로그인</h2>
           <form id="userLogin" action="${contextPath}/user/login" method="post">
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

    <script>
      $(document).ready(function () {
        $("#userLogin").submit(function (event) {
          // 회원가입 폼 제출 시 추가적인 검증을 여기에 작성할 수 있습니다.
          event.preventDefault(); // 폼의 기본 제출 동작을 막음

          // 필요한 추가 작업을 수행한 후 폼을 제출할 수 있습니다.
          // 예를 들어, 아이디 중복 확인 결과에 따라 폼 제출을 막을 수 있습니다.
          var mem_id = $("#mem_id").val();
          var mem_password = $("#mem_password").val();

          // AJAX 요청을 통해 서버로 폼 데이터를 전송할 수 있습니다.
          // 예시 코드:
          $.ajax({
            type: "POST",
            url: "/user/login", // 회원가입 처리 URL
            data: $("#userLogin").serialize(),
            success: function (response) {
              console.dir(response);
              alert(response.msg);
              // 필요 시 페이지를 리다이렉트하거나 다른 작업을 수행할 수 있습니다.
              window.location.href = response.location;

            },
            error: function (xhr, status, error) {
              console.error("AJAX Error: " + error);
              console.error("Response Text:", xhr.responseText);
            },
          });
        });
      });
    </script>
  </body>
</html>
