<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ include file="/resources/include/header.jsp" %>

<!-- 로그인 성공 모달 -->
            <div class="modal" id="loginSuccessModal" tabindex="-1" aria-labelledby="loginSuccessModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="loginSuccessModalLabel">알림</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            ${loginMessage}
                        </div>
                    </div>
                </div>
            </div>
        <!-- 로그인 성공 모달 End -->
<script>
   document.addEventListener('DOMContentLoaded', function () {
               var loginMessage = "${loginMessage}";
               if (loginMessage) {
                   var myModal = new bootstrap.Modal(document.getElementById('loginSuccessModal'), {
                       keyboard: false
                   });
                   myModal.show();

                   setTimeout(function () {
                       myModal.hide();
                   }, 1000); // 3초 후 모달 숨기기
               }
           });
</script>
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<section class="content">
			<div>
				 <h1>메인페이지</h1>
			</div>

			<c:if test="${member != null && isLogin == true}">
                <div>
                    <p><a href="${contextPath}/user/detailMember/${member.mem_id}">${member.mem_name}</a></p>
                    <a href="${contextPath}/user/logout">로그아웃</a>
                </div>
			</c:if>

			<c:if test="${member == null}">
                 <div>
                    <a href="${contextPath}/user/loginForm">로그인</a>
                    <a href="${contextPath}/user/createMember">회원가입</a>
                 </div>
            </c:if>

		</section>
	</div>
<%@include file="/resources/include/footer.jsp" %>
