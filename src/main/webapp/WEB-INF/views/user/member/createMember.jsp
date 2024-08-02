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
      <div class="container mt-5 user-form join-form">
                          <h2>회원가입</h2>
                          <form id="signupForm" action="${contextPath}/user/createMember" method="post">
                              <div>
                                  <label for="mem_id">아이디<span class="red">*</span></label>

                                  <input type="text" name="mem_id" id="mem_id" value="" placeholder="아이디">
                                  <button id="checkIdBtn">아이디 중복 확인</button>
                                  <div id="idCheckResult"></div>

                              </div>
                              <div>
                                  <label for="mem_password">비밀번호<span class="red">*</span></label>
                                  <input type="text" name="mem_password" id="mem_password" value="" placeholder="비밀번호" >
                              </div>
                              <div>
                                  <label for="mem_name">이름<span class="red">*</span></label>
                                  <input type="text" name="mem_name" id="mem_name" value="" placeholder="이름" >
                              </div>
                              <div>
                                  <label for="mem_ssn">주민등록번호<span class="red">*</span></label>
                                  <input type="text" name="mem_ssn" id="mem_ssn" value="" placeholder="주민등록번호" >
                              </div>
                              <div>
                                  <label for="mem_phoneNumber">전화번호<span class="red">*</span></label>
                                  <input type="text" name="mem_phoneNumber" id="mem_phoneNumber" value="" placeholder="전화번호" >
                              </div>
                              <div>
                                  <label hidden for="mem_accumulatedAmount">누적금액</label>
                                  <input hidden type="text" name="mem_accumulatedAmount" id="mem_accumulatedAmount" value="0" placeholder="누적금액" >
                              </div>
                              <!--<div>
                                  <label for="mem_status">상태</label>
                                  <input type="text" name="mem_status" id="mem_status" placeholder="상태">
                              </div> -->
                              <div>
                                  <label for="mem_address">주소</label>
                                  <input type="text" name="mem_address" id="mem_address" placeholder="주소" >
                              </div>
                              <div class="join-btn">
                                  <button type="submit">회원가입</button>
                              </div>
                          </form>
      </div>
    <!-- //footer -->
    <footer>
        <%@ include file = "/resources/include/footer_beta.jsp"%>
    </footer>
    <!-- 플러그인 -->
        <%@ include file = "/resources/include/plugin_cdn.jsp"%>

<script>
    $(document).ready(function() {
        $('#checkIdBtn').click(function() {
            var mem_id = $('#mem_id').val();
            $.ajax({
                type: 'POST',
                url: 'findId',
                data: { mem_id: mem_id },
                success: function(response) {
                    if (response === "1") {
                        $('#idCheckResult').text('중복된 아이디입니다.');
                    } else {
                        $('#idCheckResult').text('사용 가능한 아이디입니다.');
                    }
                },
                error: function(xhr, status, error) {
                    console.error('AJAX Error: ' + error);
                }
            });
        });

        $('#signupForm').submit(function(event) {
            // 회원가입 폼 제출 시 추가적인 검증을 여기에 작성할 수 있습니다.
            event.preventDefault(); // 폼의 기본 제출 동작을 막음

            // 필요한 추가 작업을 수행한 후 폼을 제출할 수 있습니다.
            // 예를 들어, 아이디 중복 확인 결과에 따라 폼 제출을 막을 수 있습니다.
            var mem_id = $('#mem_id').val();
            var idCheckResult = $('#idCheckResult').text();

            if (idCheckResult === '사용 가능한 아이디입니다.') {
                // AJAX 요청을 통해 서버로 폼 데이터를 전송할 수 있습니다.
                // 예시 코드:
                $.ajax({
                    type: 'POST',
                    url: 'createMember', // 회원가입 처리 URL
                    data: $('#signupForm').serialize(),
                    success: function(response) {
                        alert('회원가입이 완료되었습니다!');
                        // 필요 시 페이지를 리다이렉트하거나 다른 작업을 수행할 수 있습니다.
                        location.href = "/";
                    },
                    error: function(xhr, status, error) {
                        console.error('AJAX Error: ' + error);
                    }
                });
            } else {
                alert('아이디 중복 확인을 해주세요.');
            }
        });
    });
    </script>
  </body>
</html>
