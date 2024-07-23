<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta
      name="viewport"
      content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"
    />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <meta name="author" content="webstoryboy" />
    <meta
      name="description"
      content="메가박스 사이트 따라하면서 배우는 튜토리얼입니다."
    />
    <meta
      name="keywords"
      content="메가박스, 유투브, 영화, 최신영화, 영화관, CGV, 롯데시네마, 웹스토리보이, 웹스, 사이트 만들기, 따라하기"
    />
    <title>SmallBox</title>

    <!-- css -->
    <link rel="stylesheet" href="${path}/assets/css/reset02.css" />
    <link rel="stylesheet" href="${path}/assets/css/style02.css" />

    <!-- 페이스북 메타 태그 -->
    <meta property="og:title" content="메가박스 사이트 만들기" />
    <meta
      property="og:url"
      content="https://github.com/webstoryboy/megabox2019"
    />
    <meta
      property="og:image"
      content="https://webstoryboy.github.io/megabox2019/mega.jpg"
    />
    <meta
      property="og:description"
      content="메가박스 사이트 따라하면서 배우는 튜토리얼입니다."
    />

    <!-- 트위터 메타 태그 -->
    <meta name="twitter:card" content="summary" />
    <meta name="twitter:title" content="메가박스 사이트 만들기" />
    <meta
      name="twitter:url"
      content="https://github.com/webstoryboy/megabox2019/"
    />
    <meta
      name="twitter:image"
      content="https://webstoryboy.github.io/megabox2019/mega.jpg"
    />
    <meta
      name="twitter:description"
      content="메가박스 사이트 따라하면서 배우는 튜토리얼입니다."
    />

    <!-- 웹 폰트 -->
    <link
      href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,300,400,500,700,900&amp;subset=korean"
      rel="stylesheet"
    />

    <!-- HTLM5shiv ie6~8 -->
    <!--[if lt IE 9]>
      <script src="${path}/assets/js/html5shiv.min.js"></script>
      <script type="text/javascript">
        alert(
          "현재 브라우저는 지원하지 않습니다. 크롬 브라우저를 추천합니다.!"
        );
      </script>
    <![endif]-->
  </head>
  <body>
    <header id="header">
      <div class="container">
        <div class="row">
          <div class="header clearfix">
            <h1>
              <a href="#">
                <em
                  ><img
                    style="height: 100%"
                    src="${path}/images/logo3.png"
                    alt="MEGABOX"
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
                    <a href="${contextPath}/user/detailMember/${member.mem_id}"
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

    <!-- //메인 콘텐츠-->
    <section class="content">
      <div class="container">
        <div class="row">
          <h2 style="text-align: center; font-size: 20rem">콘텐츠</h2>
          <h2 style="text-align: center; font-size: 20rem">콘텐츠</h2>
        </div>
      </div>
    </section>
    <!-- //footer -->
    <footer>
      <div class="container">
        <div class="row">
          <div class="footer_row">
            <div class="footer_infor">
              <ul>
                <li><a href="#">회사소개</a></li>
                <li><a href="#">채용정보</a></li>
                <li><a href="#">제휴/광고/부대사업 문의</a></li>
                <li><a href="#">이용약관</a></li>
                <li><a href="#">개인정보처리방침</a></li>
                <li><a href="#">고객센터</a></li>
                <li><a href="#">윤리경영</a></li>
              </ul>
              <address>
                <p>
                  경기 수원시 팔달구 덕영대로895번길 9-1 SB빌딩 4층 (402호)<br />
                  <span class="bar2">대표자명 윤가을</span> 개인정보보호 책임자
                  경영지원실 팀장 유종현<br />
                  <span class="bar2">사업자등록번호 211-86-59478</span>
                  통신판매업신고번호 제 833호
                </p>
                <p>Copyright 2024 by SmallBox Inc. All right reserved</p>
              </address>
            </div>

            <div class="footer_sns">
              <ul>
                <li class="icon s1">
                  <a href="#"><span class="ir_pm">트위터</span></a>
                </li>
                <li class="icon s2">
                  <a href="#"><span class="ir_pm">페이스북</span></a>
                </li>
                <li class="icon s3">
                  <a href="#"><span class="ir_pm">인스타그램</span></a>
                </li>
                <li class="icon s4">
                  <a href="#"><span class="ir_pm">구글 플레이</span></a>
                </li>
                <li class="icon s5">
                  <a href="#"><span class="ir_pm">아이폰 앱스토어</span></a>
                </li>
              </ul>
              <div class="tel">
                <a href="#">ARS <em>1544-0070</em></a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </footer>
    <!-- 자바스크립트 라이브러리 -->
    <script src="${path}/assets/js/jquery.min_1.12.4.js"></script>
    <script src="${path}/assets/js/modernizr-custom.js"></script>
    <script src="${path}/assets/js/ie-checker.js"></script>
  </body>
</html>
