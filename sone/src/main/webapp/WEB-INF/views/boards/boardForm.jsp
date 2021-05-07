<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%--★ header에 썼어도, 여기에 또 써야지 한글 안 깨짐 --%>

<jsp:include page="../layouts/header.jsp" />
<!-- .. 현재 jsp 파일 기준으로 경로 찾아가기 (상대경로)
boards 폴더 밖에서, layouts 폴더를 찾아가는거니까
앞에 /views/는 필요 x -->

<form method = "post" action = "/boardForm" enctype="multipart/form-data">
	<div>
		<label>제목</label>
		<input type="text" name ="title">
	</div>
	
	<div>
		<label>내용</label>
		<textarea name="content" rows="3"></textarea>
	</div>
		
	<div>
		<label>이미지</label>
		<input type = "file" name="image">	
	</div>					

	<button type = "submit">등록하기</button>
</form>

<jsp:include page="../layouts/footer.jsp" />