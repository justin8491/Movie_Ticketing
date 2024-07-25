<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
  <head>
        <%@ include file = "/resources/include/head_beta.jsp"%>
        
<style>
body{margin-top:20px;
}
.project-list-table {
    border-collapse: separate;
    border-spacing: 0 12px
}

.project-list-table tr {
    background-color: #eee;
    text-align : center;
}

.table-nowrap td, .table-nowrap th {
    white-space: nowrap;
}
.table-borderless>:not(caption)>*>* {
    border-bottom-width: 0;
}
.table>:not(caption)>*>* {
    padding: 0.75rem 0.75rem;
    background-color: var(--bs-table-bg);
    border-bottom-width: 1px;
    box-shadow: inset 0 0 0 9999px var(--bs-table-accent-bg);
}

.avatar-sm {
    height: 2rem;
    width: 2rem;
}
.rounded-circle {
    border-radius: 50%!important;
}
.me-2 {
    margin-right: 0.5rem!important;
}
img, svg {
    vertical-align: middle;
}

a {
    color: #3b76e1;
    text-decoration: none;
}
.px-2 text-primary{
	color: #3b76e1;
    text-decoration: none;
}

.badge-soft-danger {
    color: #f56e6e !important;
    background-color: rgba(245,110,110,.1);
}
.badge-soft-success {
    color: #63ad6f !important;
    background-color: rgba(99,173,111,.1);
}

.badge-soft-primary {
    color: #3b76e1 !important;
    background-color: rgba(59,118,225,.1);
}

.badge-soft-info {
    color: #57c9eb !important;
    background-color: rgba(87,201,235,.1);
}

.avatar-title {
    align-items: center;
    background-color: #3b76e1;
    color: #fff;
    display: flex;
    font-weight: 500;
    height: 100%;
    justify-content: center;
    width: 100%;
}
.bg-soft-primary {
    background-color: rgba(59,118,225,.25)!important;
}
table.admMovieDetail button.deleteBtn{
	background-color: transparent;
	padding:0;
	border:none;
	box-shadow: none
	}

 </style>
  </head>
  <body>
   <header id="header">
            <%@ include file="/resources/include/headerAdmin_beta.jsp"%>
   </header>
    <!-- //메인 콘텐츠-->
    <section class="content">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/boxicons/2.1.0/css/boxicons.min.css" integrity="sha512-pVCM5+SN2+qwj36KonHToF2p1oIvoU3bsqxphdOIWMYmgr4ZqD3t5DjKvvetKhXGc/ZG5REYTT6ltKfExEei/Q==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/MaterialDesign-Webfont/5.3.45/css/materialdesignicons.css" integrity="sha256-NAxhqDvtY0l4xn+YVa6WjAcmd94NNfttjNsDmNatFVc=" crossorigin="anonymous" />

<div class="container">
    <div class="row align-items-center">
        <div class="col-md-6">
            <div class="mb-3">
                <h5 class="card-title">영화리스트<span class="text-muted fw-normal ms-2"></span></h5>
            </div>
        </div>
        <div class="col-md-6">
            <div class="d-flex flex-wrap align-items-center justify-content-end gap-2 mb-3">
                <div style = "text-align: right">
  					<a href="/admin/movie/addMovie" data-bs-toggle="modal" data-bs-target=".add-new" class="btn btn-primary"><i class="bx bx-plus me-1"></i>추가하기</a>
				</div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="">
                <div class="table-responsive">
                    <table class="table project-list-table table-nowrap align-middle table-borderless admMovieDetail">
                        <thead>
                            <tr>
                                <th scope="col">영화번호</th>
                                <th scope="col">카테고리</th>
                                <th scope="col" width = 100%;>이름</th>
                                <th scope="col">영화상태</th>
                                <th scope="col">감독</th>
                                <th scope="col" style="width: 200px;">수정/삭제</th>
                            </tr>
                        </thead>
                      <tbody>
						<c:forEach var="movie" items="${movie}">
   						 <tr>
        						<td>${movie.mo_no}</td>
       						 <c:forEach var="category" items="${category}">
            						<c:if test="${movie.cat_no == category.cat_no}">
               						 <td>${category.cat_name}</td>
           						 </c:if>
        						</c:forEach>
        						<td>${movie.mo_name}</td>
        						<c:if test="${movie.mo_status == 1}">
            						<td>
                						<span class="badge fs-6 fw-normal bg-tint-success text-success">상영중</span>
            						</td>
        						</c:if>
        						<c:if test="${movie.mo_status == 0}">
            						<td>
                						<span class="badge fs-6 fw-normal bg-tint-success text-fail">종영</span>
            						</td>
        						</c:if>
        						<td>
            						${movie.mo_director}
        						</td>
       						 <td>
            						<ul class="list-inline mb-0">
                						<li class="list-inline-item">
                    						<a href="/admin/movie/updateMovie?mo_no=${movie.mo_no}" data-bs-toggle="tooltip" data-bs-placement="top" title="Edit" class="px-2 text-primary"><i class="bx bx-pencil font-size-18"></i></a>
                						</li>
                					<li class="list-inline-item">
                    						<!-- Form for delete -->
                    					<form action="/admin/movie/deleteMovie" method="post" style="display: inline;">
                        					<input type="hidden" name="mo_no" value="${movie.mo_no}" />
                        						<button type="submit" class="px-2 text-primary deleteBtn" data-bs-toggle="tooltip" data-bs-placement="top" title="Delete">
                           	 						<i class="bx bx-trash-alt font-size-18 "></i>
                        						</button>
                   		 				</form>
               						 </li>
            						</ul>
        					</td>
    					</tr>
					 </c:forEach>
					</tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
    </section>
    <!-- //footer -->
    <footer>
        <%@ include file = "/resources/include/footer_beta.jsp"%>
    </footer>
    <!-- 플러그인 -->
        <%@ include file = "/resources/include/plugin_cdn.jsp"%>
  </body>
</html>
