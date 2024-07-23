<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <%@ include file = "/resources/include/head_beta.jsp"%>
</head>
<body>
    
 <header id="header">
        <%@ include file = "/resources/include/header_beta.jsp"%>
</header>
    <!-- //header -->

  <section class="content">
    <div class="container">
        <h1 class="text-center my-4">Movie List</h1>
        <div class="row movielist">
            <c:forEach var="movie" items="${movielist}">
                <div class="col-md-4 mb-4">
                    <div class="text-center">
                        <img src="${contextPath}/resources/images/${movie.mo_photo}" alt="${movie.mo_name}" class="img-fluid">
                        <div class="movie-name">
                            <a href="${contextPath}/user/movie/detailMovie?mo_no=${movie.mo_no}">${movie.mo_name}</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
  </section>
   
    
    <footer>
        <%@ include file = "/resources/include/footer_beta.jsp"%>
    </footer>
    <!-- 플러그인 -->
        <%@ include file = "/resources/include/plugin_cdn.jsp"%>
    <!-- //footer -->
    

    <!-- 트레일러 -->
    <aside role="complementary" id="blackout" class="overlay">
        <div id="trailerModal" class="modal">
            <div id="trailer"></div><!-- YouTube 플레이어로 대체되는 부분 -->
        </div>
        <button id="hideTrailer" class="modal_close">닫기</button>
    </aside>
    
    
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