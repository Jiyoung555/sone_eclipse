<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%--★ header에 썼어도, 여기에 또 써야지 한글 안 깨짐 --%>


<%@ taglib uri="http://www.springframework.org/security/tags" prefix="s" %>
<!-- 스프링 시큐리티 -->

<jsp:include page="../layouts/header.jsp" />
<!-- .. 현재 jsp 파일 기준으로 경로 찾아가기 (상대경로)
members 폴더 밖에서, layouts 폴더를 찾아가는거니까
앞에 /views/는 필요 x -->

<form method = "post" action = "/login"> <!--action = "login" 안 써줘도, 현 url 주소 따라 자동으로 되나봄-->
	<div>
		<label>이메일</label>
		<input type="email" name ="email">
	</div>
	
	<div>
		<label>비밀번호</label>
		<input type="text" name ="password">	
	</div>

	<button type = "submit">로그인</button>
</form>

<jsp:include page="../layouts/footer.jsp" />