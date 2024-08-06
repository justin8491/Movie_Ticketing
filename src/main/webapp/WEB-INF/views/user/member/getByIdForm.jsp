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
              <form id="selectById" action="${contextPath}/user/selectById" method="post">
                <input type="text" name="mem_name" id="mem_name" placeholder="이름"/><br/>
                <input type="text" name="mem_phoneNumber" id="mem_phoneNumber" placeholder="전화번호"/><br/>
                <input type="submit" value="아이디 찾기" />
              </form>
          </div>

          <div>
              <h2>비밀번호 찾기</h2> <br>
              <form id="selectByPwd" action="${contextPath}/user/selectByPwd" method="post">
                <input type="text" name="mem_id" id="mem_id" placeholder="아이디"/><br/>
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

  <script>
    $(document).ready(function () {
      $("#selectById").submit(function (event) {
        event.preventDefault();
        var mem_name = $("#mem_name").val();
        var mem_phoneNumber = $("#mem_phoneNumber").val();

        $.ajax({
          type: "POST",
          url: "/user/selectById", // 회원가입 처리 URL
          data: $("#selectById").serialize(),
          success: function (response) {
            console.dir(response);
            alert(response.msg);
            window.location.href = response.location;
          },
          error: function (xhr, status, error) {
            console.error("AJAX Error: " + error);

          },
        });
      });

      $("#selectByPwd").submit(function (event) {
          event.preventDefault();
          var mem_id = $("#mem_id").val();
          var mem_phoneNumber = $("#mem_phoneNumber").val();

          $.ajax({
            type: "POST",
            url: "/user/selectByPwd", // 회원가입 처리 URL
            data: $("#selectByPwd").serialize(),
            success: function (response) {
              console.dir(response);
              alert(response.msg);
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
