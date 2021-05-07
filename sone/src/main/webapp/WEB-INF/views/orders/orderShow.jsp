<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%--★ header에 썼어도, 여기에 또 써야지 한글 안 깨짐 --%>

<jsp:include page="../layouts/header.jsp" />
<!-- .. 현재 jsp 파일 기준으로 경로 찾아가기 (상대경로)
orders 폴더 밖에서, layouts 폴더를 찾아가는거니까
앞에 /views/는 필요 x -->

<h3>나의 주문 상세보기</h3> <br>

<table border="1" width="880" id="orderShow_table">
	<tr>
		<td width="77">
		    <p align="center">주문번호</p>
		</td>
		
		<td width="327">
		    <p align="center">상품명</p>
		</td>
		
		<td width="197">
		    <p align="center">주문날짜</p>
		</td>
		
		<td width="155">
		    <p align="center">주문상태</p>
		</td>
		
		<td width="90">
		    <p align="center">이미지</p>
		</td>
		
		<td width="90">
		    <p align="center">총 가격</p>
		</td>				
	</tr>
	
	<tr>
        <td>${myOrder.order_id}</td>
        <td>${myOrder.name}</td>
        <td>${myOrder.date}</td>
        <td>${myOrder.orderStatus}</td>
        <td><img src="/uploads/${myOrder.imagename}" alt=""></td>
        <td>${myOrder.totalprice}원 (${myOrder.count}개 x ${myOrder.orderprice}원)</td>
	</tr>

</table>

<a class="btn btn-primary" href="/orderAll">주문 목록</a>

<form method = "post" action="/orderDelete?order_item_id=${myOrder.order_item_id}">
	<button type="submit" class="btn btn-danger">주문 취소</button>
</form>


<jsp:include page="../layouts/footer.jsp" />
