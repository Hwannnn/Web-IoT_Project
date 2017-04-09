<%@ page import="adminWeb.vo.Auth"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     

<c:if test="${empty sessionScope.auth or empty sessionScope.auth.auth_id}">
	<meta http-equiv="Refresh" content="0;url=<%=request.getContextPath()%>/auth/login.do">
</c:if>

<c:if test="${!empty sessionScope.auth or !empty sessionScope.auth.auth_id}">

	<!-- Header -->
	<section id="header">
		<header>
			<span class="image avatar"><img src="<%=request.getContextPath()%>/images/avatar.png" alt="" /></span>
			<h1 id="logo">${sessionScope.auth.auth_id}</h1>
			<p><h4>${sessionScope.auth.name}님 환영합니다.</h4>
			<a href="<%=request.getContextPath()%>/auth/authinfo.do?auth_no=${sessionScope.auth.auth_no}">정보수정</a>&nbsp;&nbsp;&nbsp;
			<a href="<%=request.getContextPath()%>/auth/logout.do">로그아웃</a></p>
		</header>
		
		<c:if test="${sessionScope.auth.auth_id == 'admin01'}">
			<nav id="nav">
				<ul>
					<li><a href="<%=request.getContextPath()%>/index.jsp" id="tab_1">About</a></li>
					<li><a href="<%=request.getContextPath()%>/project/projectlist.do?pageNo=1" id="tab_2">Sharing Parking</a></li>
					<li><a href="<%=request.getContextPath()%>/auth/authSearch.jsp" id="tab_3">Account Mgt</a></li>
					<li><a href="<%=request.getContextPath()%>/contact.jsp" id="tab_4">Contact</a></li>
				</ul>
			</nav>
		</c:if>
		<c:if test="${sessionScope.auth.auth_id != 'admin01'}">
			<nav id="nav">
				<ul>
					<li><a href="<%=request.getContextPath()%>/auth/login.do" id="tab_1">About</a></li>
					<li><a href="<%=request.getContextPath()%>/project/projectlist.do?pageNo=1" id="tab_2">Sharing Parking</a></li>
					<li><a href="<%=request.getContextPath()%>/contact.jsp" id="tab_4">Contact</a></li>
				</ul>
			</nav>
		</c:if>
		
	</section>
	
	<!-- Wrapper -->
	<div id="wrapper">
			<!-- Main -->
			<div id="main">
					<!-- One -->
					<section id="one">
					</section>
			</div>
	</div>
	
</c:if>
