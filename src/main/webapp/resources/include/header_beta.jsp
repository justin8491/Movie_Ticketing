<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <div class="container">
        <div class="row">
          <div class="header">
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
                <li><a href="${contextPath}/user/movie/movieList">영화</a></li>
                <li><a href="${contextPath}/user/theater/theaterList">영화관</a></li>
                <li><a href="${contextPath}/user/schedule/scheduleList">상영스케줄</a></li>
                <li><a href="#">예매하기</a></li>
                <li><a href="${contextPath}/user/support/support">고객센터</a></li>
                <c:if test="${member != null && isLogin == true}">
                  <li>
                    <a href="${contextPath}/user/detailMember"
                      >${member.mem_name}</a
                    >
                  </li>
                  <li><a href="${contextPath}/user/logout">로그아웃</a></li>
                </c:if>
                <c:if test="${member == null}">
                  <li><a href="${contextPath}/user/loginForm">로그인</a></li>
                </c:if>
              </ul>
            </nav>
          </div>
        </div>
      </div>
    <!-- //header -->