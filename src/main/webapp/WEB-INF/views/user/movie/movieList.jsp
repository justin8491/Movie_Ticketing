<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
  <head>
        <%@ include file = "/resources/include/head_beta.jsp"%>
            <!-- 영화 템플릿 -->
    	<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">
		<!-- Loading third party fonts -->
		<link href="http://fonts.googleapis.com/css?family=Roboto:300,400,700|" rel="stylesheet" type="text/css">
		<link href="${path}/detailMovie/fonts/font-awesome.min.css" rel="stylesheet" type="text/css">
  </head>
  <body>
    
 <header id="header">
        <%@ include file = "/resources/include/header_beta.jsp"%>
</header>

		<div id="site-content">
			<main class="main-content">
				<div class="container">
					<div class="page">
						<div class="breadcrumbs">
							<a href="/">Home</a>
							<span>영화 전체리스트</span>
						</div>
						
						<div class="filters">
							<select name="movieCategoryBox" id="movieCategoryBox" onchange = "selectBoxChange()" placeholder="Choose Category">
									<option value= "0">전체영화</option>
								<c:forEach var = "category" items = "${category}">
									<option value="${category.cat_no}">${category.cat_name}</option>
								</c:forEach>
								
								<script>
								    	function selectBoxChange() {
								    		
								    		var langSelect = document.getElementById("movieCategoryBox");
								    		var selectValue = langSelect.options[langSelect.selectedIndex].value;
								    		
								    		console.log("값들어오나 체크 selectValue : " + selectValue);
								    		
								    		var cat_no = selectValue;
								    		
								    		var category = "cat_no="+cat_no;
								    		
								    		console.log("cat_no = " + cat_no);
								    		
								    		
								    		$.ajax({	
								    			url : "${contextPath}/user/movie/selectCategory",
								    			type : "POST",
								    			data : {"cat_no":selectValue},
								    			dataType : "json",
								    			success: function(data){
								 					console.log('ajax 통신 성공');
								 					var htmls = "";
								 					if(data!=null){
								 					 htmls = htmls + '<div class="movie-list">';
													$(data).each(function(){
														console.log(this.mo_no +"="+this.mo_name);
										 	            htmls += '<div class="movie">';
										 	            htmls += '<figure class="movie-poster"><a href="${contextPath}/user/movie/detailMovie?mo_no='+this.mo_no+'">';
										 	            htmls += '<img src="${contextPath}/resources/images/'+this.mo_photo+'">';
										 	            htmls += '</a></figure>';
										 	            htmls += '<div class="movie-title"><a href="${contextPath}/user/movie/detailMovie?mo_no='+this.mo_no+'">'+this.mo_name+'</a></div>';
										 	            htmls += '</div>';
													})	// each End
													htmls += '</div>';
								 					}else{
								 						htmls = htmls + "<h3>등록된 영화가 없습니다.</h3>";
								 					}
								 					document.getElementById("showMovie").style.display ='none';		
													$("#replylist").html(htmls);
								 				},
								 				error: function(){
								 					alert('ajax 통신 실패');		
								 				}
								    		});

								    	}
								</script>
							</select>
						</div>
						<div id = "showMovie">
						<div class="movie-list">
								<c:forEach var="movie" items="${movieList}">
									<div class="movie">
									<figure class="movie-poster"><a href="${contextPath}/user/movie/detailMovie?mo_no=${movie.mo_no}">
									<img src="${contextPath}/resources/images/${movie.mo_photo}" alt="${movie.mo_name}">
									</a></figure>
									<div class="movie-title"><a href="${contextPath}/user/movie/detailMovie?mo_no=${movie.mo_no}">${movie.mo_name}</a></div>
									</div>
								</c:forEach>
						</div> <!-- .movie-list -->
						</div>
						<div id = "replylist"></div>

						<div class="pagination">
							<a href="#" class="page-number prev"><i class="fa fa-angle-left"></i></a>
							<span class="page-number current">1</span>
							<a href="#" class="page-number">2</a>
							<a href="#" class="page-number">3</a>
							<a href="#" class="page-number">4</a>
							<a href="#" class="page-number">5</a>
							<a href="#" class="page-number next"><i class="fa fa-angle-right"></i></a>
						</div>
					</div>
				</div> <!-- .container -->
			</main>
		</div>
		<!-- Default snippet for navigation -->		

<footer>
    <%@ include file="/resources/include/footer_beta.jsp"%>
</footer>
<!-- 플러그인 -->
<%@ include file="/resources/include/plugin_cdn.jsp"%>


</body>
</html>