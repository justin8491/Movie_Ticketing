<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
  <head>
        <%@ include file = "/resources/include/head_beta.jsp"%>
        <link rel="stylesheet" href="/resources/include/styleMegaBox.css" />
        <link rel="stylesheet" href="${path}/assets/css/swiper.css">
        <style type="text/css">
        .movie_chart > div > div > div{
        	display:block
        }
        .content .container{
        	max-width:1200px;
        	
        }
        .content .swiper-container2{
        	overflow: hidden;
        }
        	.movie_chart .swiper-slide {
        		max-width:270px
        	}
        	
        .movie_chart .swiper-slide .poster{
        max-height:350px;
        overflow: hidden
        }
        </style>
  </head>
  <body>
   <header id="header"  class="clearfix">
        <%@ include file = "/resources/include/header_beta.jsp"%>
   </header>
    <!-- //메인 콘텐츠-->
    <section class="content">
      <div class="container">
        <div class="row">
           <section id="movie">
        <div class="container">
            <div class="row">
                <div class="movie">
                    <div class="movie_title">
                        <ul class="clearfix" style="text-align: center;">
                            <li class="active"><a href="#">박스오피스</a></li>
                            <li><a href="#">상영예정작</a></li>
                        </ul>
                    </div>
                    <div class="movie_chart">
                        <div class="swiper-container2">
                           <div class="chart_cont1 swiper-wrapper">
                                  <c:forEach var="movie" items="${movieList}">
                               <div class="swiper-slide">
                                   <div class="poster">
                                       <figure>
                                           <img src="${contextPath}/resources/images/${movie.mo_photo}" alt="${movie.mo_name}" class="img-fluid">
                                       </figure>
                                       <div class="rank"><strong>1</strong></div>
                                   </div>
                                   <div class="infor">
                                       <h3><span class="icon all ir_pm">${movie.mo_rating}</span> <strong>${movie.mo_name}</strong></h3>
                                       <div class="infor_btn">
                                           <a href="#">상세정보</a>
                                           <a href="#">예매하기</a>
                                       </div>
                                   </div>
                               </div>
                               </c:forEach>
                           </div>
                        </div>
                        <!-- //chart_cont1-->
                         <div class="swiper-container2">
                           <div class="chart_cont2 swiper-wrapper">
                               <div class="swiper-slide">
                                  <c:forEach var="movie" items="${movieList}">
                                   <div class="poster">
                                       <figure>
                                           <img src="${contextPath}/resources/images/${movie.mo_photo}" alt="${movie.mo_name}">
                                       </figure>
                                       <div class="rank"><strong>1</strong></div>
                                   </div>
                                   <div class="infor">
                                       <h3><span class="icon all ir_pm">${movie.mo_rating}</span> <strong>${movie.mo_name}</strong></h3>
                                       <div class="infor_btn">
                                           <a href="#">상세정보</a>
                                           <a href="#">예매하기</a>
                                       </div>
                                   </div>
                               </c:forEach>
                               </div>
                           </div>
                        </div>
                        <!-- //chart_cont2-->
                    </div>
                    <!-- //movie_chart -->
                </div>
            </div>
        </div>
    </section>  
    <!-- //movie -->
          <h2 style="text-align: center; font-size: 20rem">콘텐츠</h2>
        </div>
      </div>
    </section>

    <!-- //footer -->
z    <footer>
        <%@ include file = "/resources/include/footer_beta.jsp"%>
    </footer>
    <!-- 플러그인 -->
        <%@ include file = "/resources/include/plugin_cdn.jsp"%>
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
            spaceBetween: 35,
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
