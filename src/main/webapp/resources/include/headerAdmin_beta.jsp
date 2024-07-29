<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <div class="container">
        <div class="row">
          <div class="header clearfix">
            <h1>
              <a href="/">
                <em
                  ><img
                    style="height: 100%"
                    src="${path}/images/logo3.png"
                    alt="SMALLBOX"
                /></em>
              </a>
            </h1>
            <nav class="nav">
              <ul class="clearfix">
                <c:if test="${admin != null && type == 'admin'}">
                    <!-- <li><a href="/admin">관리자</a></li> -->
                    <li><a href="${contextPath}/admin/movie/adminMovie">영화</a></li>
                    <li><a href="${contextPath}/admin/theater/adminTheater">영화관</a></li>
                    <li><a href="${contextPath}/admin/schedule/adminSchedule">상영스케줄</a></li>
                    <li><a href="#">예매하기</a></li>
                    <li><a href="${contextPath}/admin/support/support">고객센터</a></li>
                    <c:if test="${admin != null && isLogin == true}">
                        <li><a href="/admin">관리자</a></li>
                        <li><a href="${contextPath}/admin/logout">로그아웃</a></li>
                    </c:if>
                </c:if>
              </ul>
            </nav>
          </div>
        </div>
      </div>
    <!-- //header -->