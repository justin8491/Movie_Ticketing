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
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/boxicons/2.1.0/css/boxicons.min.css" integrity="sha512-pVCM5+SN2+qwj36KonHToF2p1oIvoU3bsqxphdOIWMYmgr4ZqD3t5DjKvvetKhXGc/ZG5REYTT6ltKfExEei/Q==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/MaterialDesign-Webfont/5.3.45/css/materialdesignicons.css" integrity="sha256-NAxhqDvtY0l4xn+YVa6WjAcmd94NNfttjNsDmNatFVc=" crossorigin="anonymous" />
  <body>
   <header id="header">
        <%@ include file = "/resources/include/headerAdmin_beta.jsp"%>
   </header>
    <!-- //메인 콘텐츠-->
    <section class="content">

    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-6">
                <div class="mb-3">
                    <h5 class="card-title" style="font-size : 3rem;">회원 리스트<span class="text-muted fw-normal ms-2"></span></h5>
                </div>
            </div>
            <div class="col-md-6">
                <div class="d-flex flex-wrap align-items-center justify-content-end gap-2 mb-3">
                    <div style = "text-align: right">
      					<!--<a href="/admin/movie/addMovie" data-bs-toggle="modal" data-bs-target=".add-new" class="btn btn-primary"><i class="bx bx-plus me-1"></i>추가하기</a> -->
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
                                    <th scope="col">아이디</th>
                                    <th scope="col">비밀번호</th>
                                    <th scope="col">이름</th>
                                    <th scope="col">주민번호</th>
                                    <th scope="col">전화번호</th>
                                    <th scope="col">누적금액</th>
                                    <th scope="col">주소</th>
                                    <th scope="col">회원상태</th>
                                </tr>
                            </thead>
                          <tbody>
    						<c:forEach var="member" items="${memberList}">
       						 <tr>
            						<td>${member.mem_id}</td>
                   				    <td>${member.mem_password}</td>
            						<td>${member.mem_name}</td>
                					<td>${member.mem_ssn}</td>
                					<!--
                					<span class="badge fs-6 fw-normal bg-tint-success text-success"></span>
                					<span class="badge fs-6 fw-normal bg-tint-success text-fail">종영</span>
                					-->
                					<td>${member.mem_phoneNumber}</td>
            						<td>${member.mem_accumulatedAmount}</td>
           						    <td>${member.mem_address}</td>
           						    <td>${member.mem_status}</td>
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
    <!— //footer —>
    <footer>
        <%@ include file = "/resources/include/footer_beta.jsp"%>
    </footer>
    <!— 플러그인 —>
        <%@ include file = "/resources/include/plugin_cdn.jsp"%>
  </body>
</html>
