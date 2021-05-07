<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%--★ header에 썼어도, 여기에 또 써야지 한글 안 깨짐 --%>

<jsp:include page="../layouts/header.jsp" />
<!-- .. 현재 jsp 파일 기준으로 경로 찾아가기 (상대경로)
boards 폴더 밖에서, layouts 폴더를 찾아가는거니까
앞에 /views/는 필요 x -->


<h3>게시글 상세보기</h3> <br>

<table border="1" width="880" id="boardShow_table">
	<tr>
		<td width="77">
		    <p align="center">게시글번호</p>
		</td>
		
		<td width="327">
		    <p align="center">제목</p>
		</td>
		
		<td width="197">
		    <p align="center">내용</p>
		</td>
		
		<td width="155">
		    <p align="center">글쓴이</p>
		</td>
		
		<td width="90">
		    <p align="center">게시날짜</p>
		</td>
		
		<td width="90">
		    <p align="center">이미지</p>
		</td>				
	</tr>
	
	<tr>
        <td>${board.board_id}</td>
        <td>${board.title}</td>
        <td>${board.content}</td>
        <td>${board.writer}</td>
        <td>${board.date}</td>
        <td><img src="/uploadsBoard/${board.imagename}" alt=""></td>
	</tr>

</table>


<a class="btn btn-primary" href="/boardAll">목록</a>
<a class="btn btn-primary" href="/boardEdit?board_id=${board.board_id}">수정</a>

<form method = "post" action="/boardDelete?board_id=${board.board_id}">
	<button type="submit" class="btn btn-danger">삭제</button>
</form>








<!-- 댓글 목록 -->
<c:if test="${!empty comments}">
<div class="comment-mid">
    <ul class="list-unstyled">
    
        <c:forEach items="${comments}" var="comment">
            <li class="media mt-4" id="comment-${comment.comment_id}">

                <!-- svg의 가로 세로 css로 옮겨보기 (되는지 모름) -->
                <svg width="50" height="50" data-jdenticon-value="${comment.writer}"></svg>

                <div class="media-body">
                    <!-- 댓글 -->
                    <h5 class="mt-0 mb-1">${comment.writer}

                        <!-- 수정 버튼 => 이걸 누르면, 수정할 수 있는 창이 생겨남 -->
                        <!-- 부트스트랩 collapse 활용, https://getbootstrap.com/docs/4.5/components/collapse/ -->
                        <small>
                            <a href="#" class="comment-edit-btn" data-toggle="collapse" data-target=".multi-collapse-${comment.comment_id}">수정</a>

                            <!-- a href="#comments" class="comment-destroy-btn" value="${comment.comment_id}">삭제</a> -->
                            <form method="post" action="/boardCmtDelete">
                            	<input type="hidden" name="comment_id" value="${comment.comment_id}">
                            	<input type="hidden" name="member_id" value="${comment.member_id}">
                            	<input type="hidden" name="board_id" value="${comment.board_id}">
                            	<button type="submit">댓글삭제(form)</button>
                            </form>
                            
                            <a href="/boardCmtDelete?comment_id=${comment.comment_id}">댓글삭제(a태그)</a>
                        </small>
                    </h5>

                    <!-- 보기 모드 -->
                    <p class="collapse multi-collapse-${comment.comment_id} show">${comment.content}</p>

                    <!-- 수정 모드 => 수정할 수 있는 창 -->
                    <form method="post" action="/boardCmtEdit" 
                    	class="collapse multi-collapse-${comment.comment_id}">
                        <div class="form-group">
                            <textarea class="form-control" id="comment-content" 
                            	name="content" rows="3">${comment.content}</textarea>
                        </div>

                        <input type="hidden" id="comment-id" 
                        	name="comment_id" value="${comment.comment_id}">
                        <input type="hidden" id="comment-author" 
                        	name="member_id" value="${comment.member_id}">
                        <input type="hidden" name="board_id" value="${comment.board_id}">                        	

                        <!-- 수정 완료 버튼 -->
                        <button type="submit" class="btn btn-info comment-update-btn">댓글수정</button>
                    </form>

                </div>
            </li>
        </c:forEach>
        
    </ul>
</div>
</c:if>



<hr>

<!-- 댓글 작성 -->
<div class="card show-mid" id="comments">
    <div class="card-body show-mid-body">

        <!-- 댓글 생성후, 새로고침시 스크롤 여기로 -->
        <a href="#comment"></a>

        <!-- 댓글 작성 창 -->
        <form method="post" action="/boardCmtForm">
            <input type="hidden" id="comment-author" name="member_id" value="${member.member_id}">
            <input type="hidden" name="board_id" value="${board.board_id}">

            <div class="form-group">
                <!-- <label>댓글 작성</label> -->
                <textarea class="form-control" id="comment-content" name="content" rows="3"></textarea>
                <button type="submit" class="btn comment-btn" id="comment-create-btn">댓글등록</button>
            </div>
        </form>

    </div>
</div>







<jsp:include page="../layouts/footer.jsp" />
