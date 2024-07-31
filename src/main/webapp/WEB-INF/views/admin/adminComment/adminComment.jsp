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
    <form id="adminCommentList" name="adminCommentList" method="get">
        <div id="adminCommentList">
        </div>
    </form>
</div>				

    <br>
						<c:forEach var="item" items="${adminCommentList}">
                            <div class="comment-item" id="comment-${item.com_no}">
                                <span>${item.mem_id}</span>
                                <span class="comment-content" id="comment-content-${item.com_no}">${item.com_content}</span>
                                <span>${item.com_createdAt}</span>
                                    <button onclick="adminCommentDelete(${item.com_no})">삭제</button>
                                    <form class="edit-form" id="edit-form-${item.com_no}" style="display:none;" onsubmit="return false;">
                                    <input id="mem_id" name="mem_id" value="${member.mem_id}" readOnly/>
                                </form>
                                </div>
                                <br>
                            </div>
                        </c:forEach>
					
					<script type="text/javascript">
					
					function commentSubmit() {
                        var url = "${pageContext.request.contextPath}/admin/comment/adminCommentAdd";
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
                              alert("에러가 발생햇습니다.");
                           }
                        });
                        }
					
					function adminCommentDelete(comNo) {
					    var url = "${pageContext.request.contextPath}/admin/comment/adminCommentDelete";
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
					
					
					</script>
					
</body>
</html>