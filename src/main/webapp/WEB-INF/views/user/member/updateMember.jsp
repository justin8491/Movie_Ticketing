<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <%@ include file = "/resources/include/header.jsp"%>
</head>
<body>
    
    <header id="header">
        <div class="container">
            <div class="row">
                <div class="header clearfix">
                    <h1>
                        <a href="#">
                            <em><img src="${path}/images/logo.png" alt="SmallBox"></em>
                        </a>    
                    </h1>
                    <nav id="mNav">
                        <h2 class="ir_so">스몰박스 전체메뉴</h2>
                        <a href="#" class="ham"><span></span></a>
                    </nav>
                    <nav class="nav">
                        <ul class="clearfix">
                            <li><a href="#">영화</a></li>
                            <li><a href="#">영화관</a></li>
                            <li><a href="#">예매하기</a></li>
                            <li><a href="#">고객센터</a></li>
                            <c:if test="${member != null && isLogin == true}">
                                <li><a href="${contextPath}/user/detailMember/${member.mem_id}">${member.mem_name}</a></li>
                                <li><a href="${contextPath}/user/logout">로그아웃</a></li>
                            </c:if>
                            <c:if test="${member == null}">
                                <li><a href="${contextPath}/user/loginForm">로그인</a></li>
                            </c:if>
                            <!-- <li><a href="${contextPath}/user/loginForm">로그인</a></li> -->
                        </ul>
                    </nav>    
                </div>
            </div>
        </div>
    </header>
    <!-- //header -->


    <section id="banner">
        <div class="slider">
           <div class="swiper-container">
                <div class="swiper-wrapper">
                    <div class="swiper-slide ss1">
                        <div class="container">
                            <div class="row">
                                <h3>어벤져스 : 앤드게임</h3>
                                <p>역대 최단 기간 1000만 관객 돌파 기록 </p>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide ss2">
                        <div class="container">
                            <div class="row">
                                <h3>어벤져스 : 앤드게임</h3>
                                <p>역대 최단 기간 1000만 관객 돌파 기록 </p>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide ss3">
                        <div class="container">
                            <div class="row">
                                <h3>어벤져스 : 앤드게임</h3>
                                <p>역대 최단 기간 1000만 관객 돌파 기록 </p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="swiper-pagination"></div>
                <div class="swiper-button-prev"></div>
                <div class="swiper-button-next"></div>
            </div>
        </div>
    </section>
    <!-- //banner -->


    <div class="content-wrapper">

    		<section class="content">
    			<div class="container mt-5">
                        <h2>회원정보 변경</h2>
                        <form action="${contextPath}/user/updateMember" method="post">
                            <div class="form-group row">
                                <label for="mem_id" class="col-sm-2 col-form-label">아이디</label>
                                <div class="col-sm-5">
                                    <input type="text" name="mem_id" class="form-control" id="mem_id" value="${member.mem_id}" readonly>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="mem_password" class="col-sm-2 col-form-label">비밀번호</label>
                                <div class="col-sm-5">
                                    <input type="text" name="mem_password" class="form-control" id="mem_password" value="${member.mem_password}" placeholder="비밀번호" >
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="mem_name" class="col-sm-2 col-form-label">이름</label>
                                <div class="col-sm-5">
                                    <input type="text" name="mem_name" class="form-control" id="mem_name" value="${member.mem_name}" placeholder="이름" >
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="mem_ssn"  class="col-sm-2 col-form-label">주민등록번호</label>
                                <div class="col-sm-5">
                                    <input type="text" name="mem_ssn" class="form-control" id="mem_ssn" value="${member.mem_ssn}" placeholder="주민등록번호" >
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="mem_phoneNumber" class="col-sm-2 col-form-label">전화번호</label>
                                <div class="col-sm-5">
                                    <input type="text" name="mem_phoneNumber" class="form-control" id="mem_phoneNumber" value="${member.mem_phoneNumber}" placeholder="전화번호" >
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="mem_accumulatedAmount" class="col-sm-2 col-form-label">누적금액</label>
                                <div class="col-sm-5">
                                    <input type="text" name="mem_accumulatedAmount" class="form-control" id="mem_accumulatedAmount" value="${member.mem_accumulatedAmount}" placeholder="누적금액" >
                                </div>
                            </div>
                            <!--<div class="form-group row">
                                <label for="mem_status" class="col-sm-2 col-form-label">상태</label>
                                <div class="col-sm-5">
                                    <input type="text" name="mem_status" class="form-control" id="mem_status" placeholder="상태">
                                </div>
                            </div> -->
                            <div class="form-group row">
                                <label for="mem_address" class="col-sm-2 col-form-label">주소</label>
                                <div class="col-sm-5">
                                    <input type="text" name="mem_address" class="form-control" id="mem_address" value="${member.mem_address}" placeholder="주소" >
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-5 offset-sm-2">
                                    <button type="submit" class="btn btn-primary">수정</button>
                                    <a class="btn btn-success" href="${contextPath}/user/home">홈</a>
                                </div>
                            </div>
                        </form>
                    </div>

    		</section>
    	</div>
    <!-- //movie -->

    
    <!-- //help -->

    <!-- //help end -->
    
    <footer id="footer">
        <%@ include file = "/resources/include/footer.jsp"%>
    </footer>
    <!-- //footer -->
    
    
    <!-- 자바스크립트 라이브러리 -->
    <script src="${path}/assets/js/jquery.min_1.12.4.js"></script>
    <script src="${path}/assets/js/modernizr-custom.js"></script>
    <script src="${path}/assets/js/ie-checker.js"></script>
    <script src="${path}/assets/js/swiper.min.js"></script>
    <script src="${path}/assets/js/iframe_api.js"></script>
    <script src="${path}/assets/js/movie.js"></script>
    <script>
        //배너 이미지 슬라이드
        var swiper = new Swiper('.swiper-container',{
            pagination: {
                el: '.swiper-pagination',
            },
            navigation: {
                nextEl: '.swiper-button-next',
                prevEl: '.swiper-button-prev',
            },
            autoplay: {
                delay: 5000,
            },
        });
        
        //영화차트 이미지 슬라이드
        var swiper = new Swiper('.swiper-container2',{
            slidesPerView: 4,
            spaceBetween: 24,
//            mousewheel: {
//                invert: true,
//            },
            keyboard: {
                enabled: true,
                onlyInViewport: false,
            },
            autoplay: {
                delay: 6000,
            },
            breakpoints: {
                600: {
                    slidesPerView: 1.4,
                    spaceBetween: 24
                },
                768: {
                    slidesPerView: 2,
                    spaceBetween: 24
                },
                960: {
                    slidesPerView: 3,
                    spaceBetween: 24
                }
            }
        });
        
        //영화차트 탭 메뉴
        var movBtn = $(".movie_title > ul > li");    
        var movCont = $(".movie_chart > div");  

        movCont.hide().eq(0).show();

        movBtn.click(function(e){
            e.preventDefault();
            var target = $(this);         
            var index = target.index();  
            movBtn.removeClass("active");   
            target.addClass("active");    
            movCont.css("display","none");
            movCont.eq(index).css("display","block");
        });
        
        //공지사항 탭 메뉴
        var tabMenu = $(".notice");

        //컨텐츠 내용을 숨겨주세요!
        tabMenu.find("ul > li > ul").hide();
        tabMenu.find("li.active > ul").show();

        function tabList(e){
            e.preventDefault();       //#의 기능을 차단
            var target = $(this);
            target.next().show().parent("li").addClass("active").siblings("li").removeClass("active").find("ul").hide();
            //버튼을 클릭하면 ~ div를 보여주고
            //부모의 li 태그에 클래스 추가하고
            //형제의 li 태그에 클래스 제거하고
            //제거한 자식의 div 태그를 숨겨줌 
        }

        tabMenu.find("ul > li > a").click(tabList).focus(tabList);
        
    </script>
</body>
</html>