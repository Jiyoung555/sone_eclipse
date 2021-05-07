<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%--★ header에 썼어도, 여기에 또 써야지 한글 안 깨짐 --%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../layouts/header.jsp" />
<!-- .. 현재 jsp 파일 기준으로 경로 찾아가기 (상대경로)
members 폴더 밖에서, layouts 폴더를 찾아가는거니까
앞에 /views/는 필요 x -->

	<form action = "signup" method = "get">
	
		<table border="1" width="880">
			<tr>
				<td width="77">
				    <p align="center">회원번호</p>
				</td>
				
				<td width="327">
				    <p align="center">이메일</p>
				</td>
				
				<td width="197">
				    <p align="center">비밀번호</p>
				</td>
				
				<td width="155">
				    <p align="center">이름</p>
				</td>
				
				<td width="90">
				    <p align="center">권한</p>
				</td>
				
				<td width="90">
				    <p align="center">우편번호</p>
				</td>
				
				<td width="197">
				    <p align="center">주소</p>
				</td>
				
				<td width="197">
				    <p align="center">상세주소</p>
				</td>								
								
			</tr>
			
			<c:forEach items="${list}" var="memberVO">
				<tr>
			        <td>${memberVO.member_id}</td>
			        <td><a href='/memberShow?member_id=${memberVO.member_id}'>${memberVO.email}</a></td>
			        <td>${memberVO.password}</td>
			        <td>${memberVO.name}</td>
			        <td>${memberVO.role}</td>
			        <td>${memberVO.zipcode}</td>
			        <td>${memberVO.addr1}</td>
			        <td>${memberVO.addr2}</td>
				</tr>
			</c:forEach>
		</table>
		
		<button type ="submit">회원가입</button>
		<a href="/login">로그인</a>
	</form>
	
<jsp:include page="../layouts/footer.jsp" />
