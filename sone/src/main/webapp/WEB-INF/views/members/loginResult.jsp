<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%--★ header에 썼어도, 여기에 또 써야지 한글 안 깨짐 --%>

<jsp:include page="../layouts/header.jsp" />
<!-- .. 현재 jsp 파일 기준으로 경로 찾아가기 (상대경로)
members 폴더 밖에서, layouts 폴더를 찾아가는거니까
앞에 /views/는 필요 x -->

<h5>로그인 결과</h5>
<hr>
<h3>${loginResult}</h3>
<hr>
<a href="/">메인으로 돌아가기</a>

<jsp:include page="../layouts/footer.jsp" />