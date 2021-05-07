<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%--★ header에 썼어도, 여기에 또 써야지 한글 안 깨짐 --%>


<jsp:include page="../layouts/header.jsp" />

<div class="jumbotron">
    <h1>로그인</h1>
</div>

<form action="<c:url value='/user/login' />" method="post">
    <div class="form-group form-group-lg">
        <div class="form-group">
            <label>사용자명</label>
            <input type="text" name="email" class="form-control" placeholder="이메일">
        </div>
        
        <div class="form-group">
            <label>비밀번호</label>
            <input type="password" name="password" class="form-control" placeholder="비밀번호">
        </div>
        
        <div class="form-group">
            <input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }" >
        </div>
        <!-- 스프링 시큐리티가 적용되면 모든 POST방식에서는 csrf토큰이 필요 -->
        
        
        
        <div class="form-action">
            <input type="submit" class="btn btn-primary btn-lg" value="로그인">
            
            <c:url var="signUpPath" value="/signup" />
            <a href="${ signUpPath }" class="btn btn-success btn-lg">회원 가입</a>
        </div>
        
    </div>
</form>

<jsp:include page="../layouts/footer.jsp" />