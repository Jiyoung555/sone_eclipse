<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%--★ header에 썼어도, 여기에 또 써야지 한글 안 깨짐 --%>

<jsp:include page="../layouts/header.jsp" />
<!-- .. 현재 jsp 파일 기준으로 경로 찾아가기 (상대경로)
items 폴더 밖에서, layouts 폴더를 찾아가는거니까
앞에 /views/는 필요 x -->

	<form method = "post" action = "/itemForm" enctype="multipart/form-data">
		<div>
			<label>상품명</label>
			<input type="text" name ="name">
		</div>
		
		<div>
			<label>상세설명</label>
			<input type="text" name ="content">	
		</div>
		
		<div>
			<label>가격</label>
			<input type="text" name ="price">	
		</div>
			
		<div>
			<label>이미지</label>
			<input type = "file" name="image">	
		</div>
		
		<div>
			<label>재고</label>
			<input type="text" name ="stock">	
		</div>
		
		<div>
			<label>판매여부</label>
			<input type="text" name ="useyn">	
		</div>						

		<button type = "submit">등록하기</button>
	</form>

<jsp:include page="../layouts/footer.jsp" />