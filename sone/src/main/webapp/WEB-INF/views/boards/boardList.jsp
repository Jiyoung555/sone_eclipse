<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 


<jsp:include page="../layouts/header.jsp" />


<h3>게시판 목록 (페이징)</h3> <br>

<a href = "/board/list?pageNum=${page.firstPage}">[처음]</a>

<c:if test="${page.prev > 0 }">
	<a href = "/board/list?pageNum=${page.prev}">[이전]</a>
</c:if>	


<c:forEach begin="${page.startPage}" end="${page.endPage}" step="1" var="no">
    <c:choose>
        <c:when test="${no eq page.pageNum}">
        		<a href = "/board/list?pageNum=${no}"
        			 style="color: red; font-weight: bold;">${no}</a>
        </c:when>
        
        <c:otherwise>
        	<a href = "/board/list?pageNum=${no}">${no}</a>
        </c:otherwise>       
    </c:choose>
</c:forEach>


<c:if test="${page.next <= page.lastPage}">
	<a href = "/board/list?pageNum=${page.next}">[다음]</a>
</c:if>	

<a href = "/board/list?pageNum=${page.lastPage}">[끝]</a>





<table border="1" width="880" id="boardAll_table">
	<tr>
		<td width="77">
		    <p align="center">게시글번호</p>
		</td>
		
		<td width="327">
		    <p align="center">제목</p>
		</td>
		
		<td width="197">
		    <p align="center">작성자</p>
		</td>
		
		<td width="90">
		    <p align="center">게시날짜</p>
		</td>			
	</tr>
	
	<c:forEach items="${boardList}" var="board">
		<tr>
	        <td>${board.board_id}</td>
	        <td><a href='/boardShow?board_id=${board.board_id}'>${board.title}</a></td>
	        <td>${board.writer}</td>
	        <td>${board.date}</td>
		</tr>
	</c:forEach>
</table>

<jsp:include page="../layouts/footer.jsp" />