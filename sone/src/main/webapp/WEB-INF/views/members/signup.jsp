<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%--★ header에 썼어도, 여기에 또 써야지 한글 안 깨짐 --%>

<jsp:include page="../layouts/header.jsp" />
<!-- .. 현재 jsp 파일 기준으로 경로 찾아가기 (상대경로)
members 폴더 밖에서, layouts 폴더를 찾아가는거니까
앞에 /views/는 필요 x -->

	<form method = "post"> <!--action = "signup" 안 써줘도, 현 url 주소 따라 자동으로 되나봄-->
		<div>
			<label>이메일</label>
			<input type="email" name ="email">
		</div>
		
		<div>
			<label>비밀번호</label>
			<input type="text" name ="password">	
		</div>
		
		<div>
			<label>이름</label>
			<input type="text" name ="name">	
		</div>
		
		<div>
			<input type="hidden" name ="role" value="member">	
		</div>		
		
		<div>
			<label>우편주소</label>
			<input type="text" name ="zipcode">	
		</div>
		
		<div>
			<label>주소1</label>
			<input type="text" name ="addr1">	
		</div>
		
		<div>
			<label>상세주소</label>
			<input type="text" name ="addr2">	
		</div>						

		<button type = "submit">가입하기</button>
	</form>

<jsp:include page="../layouts/footer.jsp" />