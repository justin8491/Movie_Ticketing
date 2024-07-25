<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 헤더쪽에 path있음 -->
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<!DOCTYPE html>
<html >

<head>
<meta charset="UTF-8">
<%@ include file = "/resources/include/head_beta.jsp"%>

<!-- 확인후 삭제 css -->
<link rel="stylesheet" href="resources/모음.css"
	media="all">


<script>

function mnClk(mnNum){

	if($('#movieSel').val() == ""){
		$('#mn_' + mnNum).addClass('on');
	} else {
		$('#mn_' + $('#movieSel').val()).removeClass('on');
		$('#mn_' + mnNum).addClass('on');
	}
	$('#movieSel').val(mnNum);
	
	var params = "mnNum=" + mnNum;

	$.ajax({
		type:"POST",
		url:"movieData",
		data: params,
		success:function(data){
			mcRepeat(data.movieData);
		},
		error:function(e){
			alert(e.responseText);
		}
	});
		
	selectConfirm();
}

</script>

<style>

.reserve-title {
    border-bottom: 1px solid #dddddd;
    background-color: #444444;
    text-align: center;
    color: #dddddd;
    padding: 5px;
    font-size: 13px;
    font-weight: bold;
}

.reserve-date {
    padding-top: 5px;
    display: flex;
    flex-direction: column;
    align-items: center;
    height: 430px;
    overflow: scroll;
    overflow-x: hidden;
}

.saturday {
    color: #31597E;
    font-weight: bold;
}

.sunday {
    color: #AF2D2D;
    font-weight: bold;
}

</style>


</head>
<body>

    <header id="header">
        <div class="container">
            <div class="row">
                <div class="header clearfix">
                    <h1>
                        <a href="#">
                            <em><img src="${path}/images/logo.png" alt="MEGABOX"></em>
                        </a>    
                    </h1>
                    <nav id="mNav">
                        <h2 class="ir_so">메가박스 전체메뉴</h2>
                        <a href="#" class="ham"><span></span></a>
                    </nav>
                    <nav class="nav">
                        <ul class="clearfix">
                            <li><a href="/user/movie/movieList">영화</a></li>
                            <li><a href="#">영화관</a></li>
                            <li><a href="reservation">예매하기</a></li>
                            <li><a href="#">고객센터</a></li>
                            <li><a href="#">로그인</a></li>
                        </ul>
                    </nav>    
                </div>
            </div>
        </div>
    </header>
    <!-- //header -->

<div style="height:100px; background-color:red"></div>

 <div class="container" style="padding-bottom: 240px;">
			
	<div class="inner-wrap" style="padding-top: 40px; padding-bottom: 100px;">
	
	
	
	
		<form action="" method="post" name="myForm">
			
			<div class="quick-reserve">
				<div class="tit-util">
					<h2 class="tit">예매</h2>
					
					<div id="btnLangChg" class="right btn-ticket"
						style="display: none">
												
					</div>
				</div>
					
				<div class="mege-quick-reserve-inculde">
					
					<div class="quick-reserve-area">

						<!-- 영화 선택 -->						
						<div class="movie-choice">
							<p class="tit">영화</p>
							<div class="list-area">
								<div class="all-list">
									<button type="button" class="btn-tab on" id="movieAll">전체</button>
									
									<div class="list">
										<div class="scroll m-scroll mCustomScrollbar _mCS_1" id="movieList">
											<div id="mCSB_1"
												class="mCustomScrollBox mCS-light mCSB_vertical mCSB_inside"
												style="max-height: none;" tabindex="0">
												<div id="mCSB_1_container" class="mCSB_container"
													style="position: relative; top: 0; left: 0;" dir="ltr">
													
													<ul>
														<c:forEach var = "movie" items="${movieServiceList}">
															<li><button type="button" class="btn"
																	id="mn_${movie.mo_no }" onclick="mnClk(${movie.mo_no })">
																	
																	<span class="movie-grade small ${movie.mo_rating}"></span>
																	<span class="txt">${movie.mo_name}</span>
																</button></li>
														</c:forEach>
													</ul>
												</div>
	
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						
						
						<!-- 영화관(지역) -->								
						<div class="theater-choice">
							<div class="tit-area">
								<p class="tit">극장</p>
							</div>
							<div class="list-area" id="brchTab">
								<div class="all-list">
									<button type="button" class="btn-tab on">전체</button>
									<div class="list">
										<div class="scroll" id="brchList">
											<ul>
												<c:forEach var = "theater" items="${theaterList}">
												<li>
												<button type="button" class="btn" id="region_${theater.th_no}" onclick="regionClk(${theater.th_no});">
													<span class="txt">${theater.th_name}</span>
												</button>
												</li>
												</c:forEach>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>	
						
						<!--  날짜  -->
						 <div class="date-choice">
						 <div class="tit-area">
           				 <p class="tit">날짜</p>
           				 </div>
    					 <div class="reserve-date"></div>       				 
   					   	 </div>
								
						<!-- 상영시간 정보 입력 후 진행-->
						<div class="time-choice">
							<div class="tit-area">
							<p class="tit">시간</p>
							</div>

							<div class="hour-schedule">
								<button type="button" class="btn-prev-time">이전 시간 보기</button>
									<div class="wrap">
										<div class="view"
											style="position: absolute; width: 1015px; transition: none 0s ease 0s; left: -665px;"
											id="hour-scheduleView">
											<% for (int i = 0; i < 19; i++) {%>
											<button type="button" class="hour">00</button>
											<% } %>
											<c:forEach var="timeList" items="${timeList}" varStatus="status">
												<button type="button" class="hour" style="opacity: 0.5;"
													id="time_${timeList }">${timeList }</button>
											</c:forEach>
										</div>
									</div>
									<button type="button" class="btn-next-time">다음 시간 보기</button>
								</div>
								
								
									<div class="movie-schedule-area">
										<div class="no-result" id="playScheduleNonList"
											style="display: none;">
											<i class="iconset ico-movie-time"></i>
											<p class="txt">
												영화와 극장을 선택하시면<br> 상영시간표를 비교하여 볼 수 있습니다.
											</p>
										</div>
										<!-- 영화, 영화관 선택 했을때 -->
										<div class="result">
											<div
												class="scroll m-scroll mCustomScrollbar _mCS_16 mCS_no_scrollbar"
												id="playScheduleList" style="">
												<div id="mCSB_16"
													class="mCustomScrollBox mCS-light mCSB_vertical mCSB_inside"
													style="max-height: none;" tabindex="0">
													<div id="mCSB_16_container"
														class="mCSB_container mCS_no_scrollbar_y"
														style="position: relative; top: 0; left: 0;" dir="ltr">
														<ul>
															<li id="movieTimePos"></li>
														</ul>
													</div>

												</div>
											</div>

										</div>
									</div>
							</div>		

											
									
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
								
								
								

									
						
						
					</div>
				</div>
			</div>
		</form>
	</div>

		</div>
		
		<script>
        const date = new Date();
        // console.log(date.getFullYear());
        const lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0);
        const reserveDate = document.querySelector(".reserve-date");

      
            const weekOfDay = ["일", "월", "화", "수", "목", "금", "토"]
            const year = date.getFullYear();
            const month = date.getMonth();
            for (i = date.getDate(); i <= lastDay.getDate(); i++) {

                const button = document.createElement("button");
                const spanWeekOfDay = document.createElement("span");
                const spanDay = document.createElement("span");

                //class넣기
                button.classList = "movie-date-wrapper"
                spanWeekOfDay.classList = "movie-week-of-day";
                spanDay.classList = "movie-day";

                //weekOfDay[new Date(2020-03-날짜)]
                const dayOfWeek = weekOfDay[new Date(year + "-" + month + "-" + i).getDay()];

                //요일 넣기
                if (dayOfWeek === "토") {
                    spanWeekOfDay.classList.add("saturday");
                    spanDay.classList.add("saturday");
                } else if (dayOfWeek === "일") {
                    spanWeekOfDay.classList.add("sunday");
                    spanDay.classList.add("sunday");
                }
                spanWeekOfDay.innerHTML = dayOfWeek;
                button.append(spanWeekOfDay);
                button.append(" ");
                //날짜 넣기
                spanDay.innerHTML = i;
                button.append(spanDay);
                //button.append(i);
                reserveDate.append(button);

                dayClickEvent(button);
            }

        


        function dayClickEvent(button) {
            button.addEventListener("click", function() {
                const movieDateWrapperActive = document.querySelectorAll(".movie-date-wrapper-active");
                movieDateWrapperActive.forEach((list) => {
                    list.classList.remove("movie-date-wrapper-active");
                })
                button.classList.add("movie-date-wrapper-active");
            })
        }
    </script>

		

</body>
</html>