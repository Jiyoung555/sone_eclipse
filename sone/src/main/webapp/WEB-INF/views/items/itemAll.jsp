<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%--★ header에 썼어도, 여기에 또 써야지 한글 안 깨짐 --%>

<jsp:include page="../layouts/header.jsp" />
<!-- .. 현재 jsp 파일 기준으로 경로 찾아가기 (상대경로)
items 폴더 밖에서, layouts 폴더를 찾아가는거니까
앞에 /views/는 필요 x -->

	<form action = "itemForm" method = "get">
	
		<table border="1" width="880" id="itemAll_table">
			<tr>
				<td width="77">
				    <p align="center">상품번호</p>
				</td>
				
				<td width="327">
				    <p align="center">상품명</p>
				</td>
				
				<td width="197">
				    <p align="center">상품설명</p>
				</td>
				
				<td width="155">
				    <p align="center">가격</p>
				</td>
				
				<td width="90">
				    <p align="center">이미지</p>
				</td>
				
				<td width="90">
				    <p align="center">재고</p>
				</td>
				
				<td width="197">
				    <p align="center">판매여부</p>
				</td>				
			</tr>
			
			<c:forEach items="${list}" var="itemVO">
				<tr>
			        <td>${itemVO.item_id}</td>
			        <td><a href='/itemShow?item_id=${itemVO.item_id}'>${itemVO.name}</a></td>
			        <td>${itemVO.content}</td>
			        <td>${itemVO.price}</td>
			        <td><img src="/uploads/${itemVO.imagename}" alt=""></td>
			        <td>${itemVO.stock}</td>
			        <td>${itemVO.useyn}</td>
				</tr>
			</c:forEach>
		</table>
		
		<button type ="submit">상품 등록창</button>
	</form>

<jsp:include page="../layouts/footer.jsp" />