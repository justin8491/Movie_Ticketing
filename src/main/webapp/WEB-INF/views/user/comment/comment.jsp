<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<div class="container">
    <form id="commentAdd" name="commentAdd" method="post">
    <br><br>
        <div>
            <div>
                <span><strong>Comments</strong></span> 
            </div>
            <div>
                <table class="table">                    
                    <tr>
                        <td>
                            <textarea style="width: 1100px" rows="3" cols="30" id="content" name="content" placeholder="댓글을 입력하세요"></textarea>
                            <br>
                            <div>
                                <input type="button" value="작성" onclick = "commentSubmit()">
                            </div>
                            <script type="text/javascript">
                            
                            function commentSubmit() {
                            var url = "${pageContext.request.contextPath}/user/comment/commentAdd";
                            var paramData = {
                                  "mem_id" : '${member.mem_id}',
                                  "bo_no" : ${freeBoard.bo_no} ,
                                  "com_content" : $('#content').val()
                            }; // 추가데이터
                            
                            $.ajax({
                               type: "POST",
                               url: url,
                               data : paramData,
                               dataType : 'json',
                               success:function(map){ // result<=>data <=> log
                            	   alert("댓글 등록이 완료됐습니다.");
                               },
                               error : function(){
                                  alert("로그인 후 이용 가능합니다.");
                               }
                            });
                            }
                            </script>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <input type="hidden" id="mem_id" name="mem_id" value="${member.mem_id}" />
        <input type="hidden" id="bo_no" name="bo_no" value="${freeBoard.bo_no}" />        
    </form>
</div>
<div class="container">
    <form id="commentList" name="commentList" method="get">
        <div id="commentList">
        </div>
    </form>
</div>				

    <br>
						<c:forEach var="item" items="${commentList}">
                            <div class="comment-item" id="comment-${item.com_no}">
                                <span>${item.mem_id}</span>
                                <span class="comment-content" id="comment-content-${item.com_no}">${item.com_content}</span>
                                <span>${item.com_createdAt}</span>
                                <c:if test="${member.mem_id == item.mem_id}">
                                    <button onclick="commentUpdate(${item.com_no})">수정</button>
                                    <button onclick="commentDelete(${item.com_no})">삭제</button>
                                </c:if>
                                    <form class="edit-form" id="edit-form-${item.com_no}" style="display:none;" onsubmit="return false;">
                                    <input id="mem_id" name="mem_id" value="${member.mem_id}" readOnly/>
                                    <textarea id="edit-content-${item.com_no}">${item.com_content}</textarea>
                                    <button type="submit" onclick="commentUpdateSave(${item.com_no});">저장</button>
                                    <button type="button" onclick="hideEditForm(${item.com_no});">취소</button>
                                </form>
                                </div>
                                <br>
                            </div>
                        </c:forEach>
					
					<script type="text/javascript">
					function commentDelete(comNo) {
					    var url = "${pageContext.request.contextPath}/user/comment/commentDelete";
					    var paramData = {
					        "com_no": comNo
					    };

					    $.ajax({
					        type: "POST",
					        url: url,
					        data: paramData,
					        dataType: 'json',
					        success: function(response) {
					            if(response.status != 0) {
					            	alert("삭제 처리되었습니다.");
					            	$('#comment-' + comNo).hide();
					            } else{
					            	 alert("삭제 중 오류가 발생했습니다." );
					            }
					        },
					        error: function() {
					            alert("삭제 중 오류가 발생했습니다.");
					        }
					    });
					}
					
					function commentUpdateSave(commentId) {
						var url = "${pageContext.request.contextPath}/user/comment/commentUpdate";
						console.log("코멘트업데이트");
						var editedContent = $('#edit-content-' + commentId).val();
					    var paramData = {
					        "com_no": commentId,
					        "com_content" :editedContent
					    };
					    console.log(editedContent);
					    $.ajax({
					        type: "POST",
					        url: url,
					        data: paramData,
					        dataType: 'json',
					        success: function(response) {
					            alert("수정 처리되었습니다.");
					            $('#comment-content-' + commentId).text(editedContent); // 수정된 내용 반영
					        },
					        error: function() {
					            alert("수정 중 오류가 발생했습니다.");
					        }
					    });
					}
					
					function commentUpdate(commentId) {
				        $('#edit-form-' + commentId).show(); // 해당 리뷰의 수정 폼 표시
				        $('#comment-' + commentId + ' .comment-content').hide(); // 기존 리뷰 내용 숨김
				    };

				    function hideEditForm(commentId) {
				        $('#edit-form-' + commentId).hide(); // 해당 리뷰의 수정 폼 숨김
				        $('#comment-' + commentId + ' .comment-content').show(); // 기존 리뷰 내용 표시
				    };
					
					</script>
					
</body>
</html>