<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%--★ header에 썼어도, 여기에 또 써야지 한글 안 깨짐 --%>

<jsp:include page="../views/layouts/header.jsp" />
<!-- 앞에 .. 쓰면 상대경로 (현재 jsp 페이지 기준으로 찾아가는 거)
현재 페이지 기준 위로 한 단계 나가면, views임. views부터 찾아가기
 -->


${sessionScope.email}

<c:if test="${email == null}">
	<p>비로그인 상태입니다.</p>
</c:if>

<c:if test="${email != null }">
	<div>
		<p>${email}님 환영합니다.</p>
	</div>
</c:if>


<!-- 버튼 추가 -->
<form action = "memberAll" method="get">
	<button type ="submit">회원 목록</button>
</form>

<h1>
	Hello world!  
</h1>


<P>  The time on the server is ${serverTime}. </P>


<jsp:include page="../views/layouts/footer.jsp" />