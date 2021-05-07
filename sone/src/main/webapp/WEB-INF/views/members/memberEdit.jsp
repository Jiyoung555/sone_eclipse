<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%--★ header에 썼어도, 여기에 또 써야지 한글 안 깨짐 --%>

<jsp:include page="../layouts/header.jsp" />
<!-- .. 현재 jsp 파일 기준으로 경로 찾아가기 (상대경로)
members 폴더 밖에서, layouts 폴더를 찾아가는거니까
앞에 /views/는 필요 x -->

<h5>회원 정보 수정</h5>

<form action="modify" method = "post">
	<input type="hidden" name="_method" value="put" /> <!--★-->
	
	<div>
		<label>회원번호</label> 
		<input type="text" name ="member_id" value ="${memberVO.member_id}" readonly="readonly">		
	</div>

	<div>
		<label>이메일</label> 
		<input type="email" name ="email" value ="${memberVO.email}" readonly="readonly">		
	</div>

	<div>
		<label>비밀번호</label> 
		<input type="text" name ="password" value ="${memberVO.password}">		
	</div>		
	
	<div>
		<label>이름</label> 
		<input type="text" name="name" value = "${memberVO.name}">		
	</div>
	
	<div>
		<label>권한</label> 
		<input type="text" name ="role" value ="${memberVO.role}" readonly="readonly">		
	</div>
	
	<div>
		<label>우편번호</label> 
		<input type="text" name ="zipcode" value ="${memberVO.zipcode}">		
	</div>
	
	<div>
		<label>주소1</label> 
		<input type="text" name ="addr1" value ="${memberVO.addr1}">		
	</div>		
	
	<div>
		<label>상세주소</label> 
		<input type="text" name ="addr2" value ="${memberVO.addr2}">		
	</div>	
	
    <button type ="submit">완료</button>
</form>

<jsp:include page="../layouts/footer.jsp" />
