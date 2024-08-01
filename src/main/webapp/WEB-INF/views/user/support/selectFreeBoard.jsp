<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<%@ include file = "/resources/include/head_beta.jsp"%>
</head>
<body>
 <header id="header">
        <%@ include file = "/resources/include/header_beta.jsp"%>
   </header>
   <!-- //메인 콘텐츠-->
   <section class="content">
      <div class="container">
        <div class="row">
        <div class="mb-3">
                <h5 class="card-title text-center" style="font-size: 2.5rem;">자유게시판<span class="text-muted fw-normal ms-2"></span></h5>
            </div>
        <div class="col-md-6">
            <div class="d-flex flex-wrap align-items-center justify-content-end gap-2 mb-3">
            </div>
            <div style=" text-align: right; font-size: 1.0rem" ><a href="freeBoardWrite">작성</a></div>
        </div>
        <div class="col-lg-12">
            <div class="">
                <div class="table-responsive">
                    <table class="table project-list-table table-nowrap align-middle table-borderless">
                        <thead>
                            <tr>
                                <th class="text-number">
                                번호
                                </th>
                                <th class="text-center">제목</th>
                                <th class="text-end">작성자ID </th>
                                <th class="text-end">생성일 </th>
                            </tr>
                            <tr>
                                <td>${freeBoard.bo_no}</td>
                                <td>${freeBoard.bo_title}</td>
                                <td class="text-end">${freeBoard.bo_writerId}</td>
                                <td class="text-end">${freeBoard.bo_createAt}</td>
                            </tr>
                        </thead>
                        <tbody>
                              <tr>
                           <td colspan = "4">${freeBoard.bo_content}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
      <div class="container">         
         <c:if test="${member.mem_id!=null and member.mem_id == freeBoard.bo_writerId}">
         <div class="row">
         <a href = "freeBoardUpdate?bo_no=${freeBoard.bo_no}">수정</a>
         <a href = "freeBoardDelete?bo_no=${freeBoard.bo_no}">삭제</a>
         </div>
         </c:if>
         </div>
      </div>
                    <%@ include file="../comment/comment.jsp" %>
         
         </section>
    <!-- //footer -->
    <footer>
        <%@ include file = "/resources/include/footer_beta.jsp"%>
    </footer>
    <!-- 플러그인 -->
        <%@ include file = "/resources/include/plugin_cdn.jsp"%>
         
</body>
</html>