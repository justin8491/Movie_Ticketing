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
                <h5 class="card-title text-center" style="font-size: 2.5rem;">내가 쓴 글 <span class="text-muted fw-normal ms-2"></span></h5>
            </div>
   <table class="table table-hover">
                  <tr>
                     <th>번호</th><th>제목</th><th>작성자ID</th><th>생성일</th><th> 수정 / 삭제</th>
                  </tr>
            <c:forEach var="inquiry" items="${inquiryView}">
               <c:if test="${member.mem_id == inquiry.bo_writerId}">
                     <tr>
                     <th>${inquiry.bo_no}</th>
                     <th>${inquiry.bo_title}</th>
                     <th>${inquiry.bo_writerId}</th>
                     <th>${inquiry.bo_createAt}</th>
                     <td><a href = "freeBoardUpdate?bo_no=${inquiry.bo_no}">문의글 수정</a></td>
                     <td><a href = "freeBoardDelete?bo_no=${inquiry.bo_no}">문의글 삭제</a></td>
                     
                  </tr>
                  <tr>   
                     <th>내용:</th>
                        <td colspan = "4">${inquiry.bo_content}</td>
                          
               </c:if>
            </c:forEach>
            <c:forEach var="freeBoard" items="${freeBoard}">
               <c:if test="${member.mem_id == freeBoard.bo_writerId}">
                     <tr>
                     <th>${freeBoard.bo_no}</th>
                     <th>${freeBoard.bo_title}</th>
                     <th>${freeBoard.bo_writerId}</th>
                     <th>${freeBoard.bo_createAt}</th>
                     <td><a href = "freeBoardUpdate?bo_no=${freeBoard.bo_no}">자유게시판 수정</a></td>
                     <td><a href = "freeBoardDelete?bo_no=${freeBoard.bo_no}">자유게시판 삭제</a></td>
                  </tr>
                  <tr>   
                     <th>내용:</th>
                        <td colspan = "4">${freeBoard.bo_content}</td>
                          
                  </tr>
               </c:if>
            </c:forEach>   
         </table>
         </section>
    <!-- //footer -->
    <footer>
        <%@ include file = "/resources/include/footer_beta.jsp"%>
    </footer>
    <!-- 플러그인 -->
        <%@ include file = "/resources/include/plugin_cdn.jsp"%>
</body>
</html>