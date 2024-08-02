<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<%@ include file="/resources/include/head_beta.jsp"%>
<style type="text/css">
.table {
    width: 100%;
    border-collapse: collapse;
}

.table th,
.table td {
    border: 1px solid #ddd; /* 셀 테두리 */
    padding: 12px; /* 셀 안의 여백 */
    text-align: left; /* 텍스트 정렬 */
    font-size: 1rem; /* 폰트 크기 */
}

.table th {
    background-color: #f2f2f2; /* 헤더 셀 배경색 */
    font-weight: bold; /* 헤더 셀 텍스트 굵기 */
}

.table td {
    min-height: 500px;
    padding: 12px; /* 셀 안의 여백 */
    font-size: 1rem; /* 폰트 크기 */
    text-align: left; /* 텍스트 정렬 */
    border: 1px solid #ddd; /* 셀 테두리 */
}

.table tr:nth-child(even) {
    background-color: #f9f9f9; /* 짝수 행 배경색 */
}

.table tr:hover {
    background-color: #e0e0e0; /* 행 호버 색상 */
}
</style>
</head>
<body>
	<header id="header">
		<%@ include file="/resources/include/header_beta.jsp"%>
	</header>
	<!-- //메인 콘텐츠-->
	<section class="content">
		<div class="container">
			<div class="row">
				<div class="mb-3">
					<h5 class="card-title text-center" style="font-size: 2.5rem;">
						1대1 문의보기<span class="text-muted fw-normal ms-2"></span>
					</h5>
				</div>
				<div class="col-md-6">
					<div
						class="d-flex flex-wrap align-items-center justify-content-end gap-2 mb-3">
					</div>
				</div>
				<div class="col-lg-12">
					<div class="">
						<div class="table-responsive">
							<table
								class="table project-list-table table-nowrap align-middle table-borderless">
								<thead>
									<tr>
										<th>번호</th>
										<th>제목</th>
										<th>작성자ID</th>
										<th>생성일</th>
									</tr>
									<c:if test="${member.mem_id == inquiry.bo_writerId}">
										<tr>
											<th>${inquiry.bo_no}</th>
											<th>${inquiry.bo_title}</th>
											<th>${inquiry.bo_writerId}</th>
											<th>${inquiry.bo_createAt}</th>
										</tr>
										<tr>
											<th style = "min-height: 500px;">내용</th>
											<td colspan="4">${inquiry.bo_content}</td>
									</c:if>
							</table>
						</div>
					</div>
				</div>
				<div class="container">
					<c:if test="${member.mem_id!=null and member.mem_id == inquiry.bo_writerId}">
						<div class="row">
							<a href="freeBoardUpdate?bo_no=${inquiry.bo_no}" class="btn btn-primary">수정</a> 
							<a href="freeBoardDelete?bo_no=${inquiry.bo_no}" class="btn btn-primary">삭제</a>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</section>
	<!-- //footer -->
	<footer>
		<%@ include file="/resources/include/footer_beta.jsp"%>
	</footer>
	<!-- 플러그인 -->
	<%@ include file="/resources/include/plugin_cdn.jsp"%>

</body>
</html>