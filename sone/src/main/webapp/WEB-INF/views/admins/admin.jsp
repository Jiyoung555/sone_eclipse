<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%--★ header에 썼어도, 여기에 또 써야지 한글 안 깨짐 --%>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="s" %>
<!-- 스프링 시큐리티 -->

<jsp:include page="../layouts/header.jsp" />

<h1>/sample/admin page</h1> 
<p>principal : <sec:authentication property="principal" /></p> 
<p>MemberVO : <sec:authentication property="principal.member"/></p> 
<p>사용자 이름 : <sec:authentication property="principal.member.userName"/></p> 
<p>사용자 아이디 : <sec:authentication property="principal.username"/></p> 
<p>사용자 권한 리스트 : <sec:authentication property="principal.member.authList"/></p> 

<form action="/customLogout" method="post"> 
	<input type="submit" value="Logout"> 
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
</form>

<jsp:include page="../layouts/footer.jsp" />