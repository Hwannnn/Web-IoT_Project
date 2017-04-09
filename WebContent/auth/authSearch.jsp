<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Sharing Parking</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" />
		<script src="<%=request.getContextPath()%>/js/index.js"></script>
	</head>
	<body onload="tab_load(3)">

		<jsp:include page="../header.jsp"/>
		<!-- Wrapper -->
		<div id="wrapper">

				<!-- Main -->
				<div id="main">
					<section id="three">
						<div class="container">
							<div class="row uniform">
								<div class="10u"><h3>회원 등록</h3></div>									
								<div class="2u"><input type="button" class="special" onClick="location.href='./authJoin.jsp'" value="SignUp" /></div>
							</div><hr/>
							<form method="get" action="./authsearch.do">
								<div class="row uniform">
									<div class="3u"><h3>회원 검색</h3></div>
									<div class="7u"><input type="text" name="auth_id" id="auth_id" placeholder="아이디" required/></div>										
									<div class="2u"><input type="submit" value="Search" /></div>
								</div><hr/>
							</form>
							<div class="row uniform">
								<div class="6u 12u(xsmall)">No.</div>	
								<div class="6u 12u(xsmall)"><input type="text" name="auth_no" id="auth_no" value="${member.auth_no}" required readonly/></div>
							</div>
							<div class="row uniform">
								<div class="6u 12u(xsmall)">아이디</div>
								<div class="6u 12u(xsmall)"><input type="email" name="auth_id" id="auth_id" value="${member.auth_id}" required readonly/></div>
							</div>
							<div class="row uniform">
								<div class="6u 12u(xsmall)">이름</div>
								<div class="6u 12u(xsmall)"><input type="text" name="name" id="name" value = "${member.name}" required readonly/></div>
							</div>
							<div class="row uniform">
								<div class="6u 12u(xsmall)">주민등록번호</div>
								<div class="6u 12u(xsmall)"><input type="text" name="resident_num" id="resident_num" value = "${member.resident_num}" required readonly/></div>
							</div>
							<div class="row uniform">
								<div class="6u 12u(xsmall)">전화번호</div>
								<div class="6u 12u(xsmall)"><input type="text" name="phone" id="phone" value = "${member.phone}" required readonly/></div>
							</div><hr/>
						</div>
					</section>
				</div>
		</div>
	</body>
</html>