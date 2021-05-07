<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- spring security -->
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>


<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<!--jQuery 불러오기 / footer도 확인-->
<script src="https://code.jquery.com/jquery-3.4.1.js" type="text/javascript"></script>

<!-- 구글 Icon 연결 -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
rel="stylesheet">

<!-- Random Avatar 링크 (jdenticon) -->
<script src="https://cdn.jsdelivr.net/npm/jdenticon@3.0.1" async></script>

<!-- CSS -->
<link href="<c:url value="/resources/css/header.css"/>" rel='stylesheet' />
<link href="<c:url value="/resources/css/footer.css"/>" rel='stylesheet' />
<link href="<c:url value="/resources/css/itemShow.css"/>" rel='stylesheet' />
<link href="<c:url value="/resources/css/itemAll.css"/>" rel='stylesheet' />
<link href="<c:url value="/resources/css/orderAll.css"/>" rel='stylesheet' />
<link href="<c:url value="/resources/css/orderShow.css"/>" rel='stylesheet' />
<link href="<c:url value="/resources/css/boardShow.css"/>" rel='stylesheet' />
</head>


<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light header-navbar">
		<a class="navbar-brand top-menu" href="#">MENU</a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarNav">
			
			<ul class="navbar-nav">
			
				<li class="nav-item active">
					<a class="nav-link" href="/">MAIN
						<span class="sr-only">(current)</span>
					</a>
				</li>
	
				<li class="nav-item"><a class="nav-link" href="/itemAll">PRODUCT</a></li>
				<li class="nav-item"><a class="nav-link" href="/orderAll">ORDER</a></li>
				<li class="nav-item"><a class="nav-link" href="/mypage">MY PAGE</a></li>
				<li class="nav-item"><a class="nav-link" href="/boardAll">BOARD</a></li>	


		        <!-- 로그인 버튼 -->
		        <sec:authorize access="isAnonymous()">
		            <c:url var="loginUrl" value="/login" />

		            <li class="nav-item"><a href="${ loginUrl }">로그인</a></li>
		        </sec:authorize>

			
				
		        <!-- 로그아웃 버튼 (csrf post 꼭 해야됨) -->
		        <sec:authorize access="isAuthenticated()">
		        	<li class="nav-item">
		        
			            <c:url var="logoutUrl" value="/logout" />
			            
			            <form action="${logoutUrl}" method="post" class="navbar-form navbar-right">
			                <button type="submit" class="btn btn-default">로그아웃</button>
			                
			                <input type="hidden" name="${_csrf.parameterName}"
			                    value="${_csrf.token}" />
			            </form>
		            
		            </li>
		        </sec:authorize>				
				
				
				
				
				<!----------아래는 시큐리티 공부 전에 만듦--------------->
				
				
				
				<!-- c:choose -->
				<c:choose>
				
					<c:when test="${email == null}">
						<li class="nav-item">
							<a class="nav-link nav-goBold" href="/login">LOGIN</a>
						</li>
		
						<li class="nav-item">
							<a class="nav-link nav-goBold" href="/signup">SIGN-UP</a>
						</li>
					</c:when>
					
					<c:otherwise>
						<li class="nav-item">
							<a class="nav-link nav-goBold" href="/logout">LOGOUT</a>
						</li>
						
						<c:if test="${admin != null}">
							<li class="nav-item">
								<a class="nav-link nav-admin" href="/admin">ADMIN</a>
							</li>
						</c:if>				
					</c:otherwise>
				</c:choose> 
                <!-- end c:choose -->	

			</ul>
			
		</div>
	</nav>
	<!-- Navbar END-->