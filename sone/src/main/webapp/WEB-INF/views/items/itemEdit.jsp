<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%--★ header에 썼어도, 여기에 또 써야지 한글 안 깨짐 --%>

<jsp:include page="../layouts/header.jsp" />
<!-- .. 현재 jsp 파일 기준으로 경로 찾아가기 (상대경로)
items 폴더 밖에서, layouts 폴더를 찾아가는거니까
앞에 /views/는 필요 x -->

<h5>상품 수정</h5>

<form action="itemEdit" method = "post" enctype="multipart/form-data">
	<div>
		<label>상품번호</label> 
		<input type="text" name ="item_id" value ="${itemVO.item_id}" readonly="readonly">		
	</div>

	<div>
		<label>상품명</label> 
		<input type="text" name ="name" value ="${itemVO.name}" readonly="readonly">		
	</div>

	<div>
		<label>상세설명</label> 
		<input type="text" name ="content" value ="${itemVO.content}">		
	</div>		
	
	<div>
		<label>가격</label> 
		<input type="text" name="price" value = "${itemVO.price}">		
	</div>
	
	<div>
		<label>이미지(필수 수정하기)</label>
		<img src="/uploads/${itemVO.imagename}" alt="">
		<input name="image" type="file">		
	</div>
	
	<div>
		<label>재고</label> 
		<input type="text" name ="stock" value ="${itemVO.stock}">		
	</div>
	
	<div>
		<label>판매여부</label> 
		<input type="text" name ="useyn" value ="${itemVO.useyn}">		
	</div>		

    <button type ="submit">수정</button>
</form>

<jsp:include page="../layouts/footer.jsp" />
