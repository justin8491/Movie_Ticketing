<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
  <head>
        <%@ include file = "/resources/include/head_beta.jsp"%>
  </head>
  <body>
   <header id="header">
        <%@ include file = "/resources/include/header_beta.jsp"%>
   </header>
    <!-- //메인 콘텐츠-->
    <div class="move-review">
      <div class="container">
        <div class="row">
          <h1>영화 리뷰 리스트</h1>
          <table border="1">
              <thead>
                  <tr>
                      <th>리뷰 ID</th>
                      <th>내용</th>
                      <th>작성일</th>
                      <th>평점</th>
                      <th>상태</th>
                      <th>영화 ID</th>
                      <th>회원 ID</th>
                  </tr>
              </thead>
              <tbody>
                  <c:forEach var="review" items="${reviews}">
                      <tr>
                          <td>${review.rev_id}</td>
                          <td>${review.rev_content}</td>
                          <td>${review.rev_createdAt}</td>
                          <td>${review.rev_rating}</td>
                          <td>${review.rev_status}</td>
                          <td>${review.mo_id}</td>
                          <td>${review.mem_id}</td>
                      </tr>
                  </c:forEach>
              </tbody>
          </table>
        </div>
      </div>
    </div>
    <!-- //footer -->
    <footer>
        <%@ include file = "/resources/include/footer_beta.jsp"%>
    </footer>
    <!-- 플러그인 -->
        <%@ include file = "/resources/include/plugin_cdn.jsp"%>
  </body>
</html>
