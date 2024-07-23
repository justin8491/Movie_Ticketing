<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header id="header">
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
                <li><a href="#">영화</a></li>
                <li><a href="#">영화관</a></li>
                <li><a href="#">예매하기</a></li>
                <li><a href="#">고객센터</a></li>
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
    </header>
    <!-- //header -->