<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%--★ header에 썼어도, 여기에 또 써야지 한글 안 깨짐 --%>

<jsp:include page="../layouts/header.jsp" />
<!-- .. 현재 jsp 파일 기준으로 경로 찾아가기 (상대경로)
boards 폴더 밖에서, layouts 폴더를 찾아가는거니까
앞에 /views/는 필요 x 

절대경로로 바꾸려면 앞에 .. 지우고 이거 비슷하게 추가하면 됨
request.getContext()

최상위는 sone
jsp include prefix 검색해보기
-->

<h3>게시판 목록</h3> <br>

<a href="/boardForm" type="btn btn-primary">글쓰기</a>

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