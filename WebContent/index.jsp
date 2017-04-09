<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Sharing Parking</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" />
		<script src="<%=request.getContextPath()%>/js/index.js"></script>
		<script>
			function check(){
				var c = "<%=request.getParameter("check")%>";
				if (c == "join") {
					alert("회원가입이 성공.");
				} else if (c == "authupdate") {
					var r = <%=request.getParameter("r")%>;
					if (r == 0) {
						alert("비밀번호를 잘못 입력하셨습니다.");
						location.href="<%=request.getContextPath()%>/auth/authupdate.do?auth_no=${sessionScope.auth.auth_no}";
					} else {
						alert("정보수정이 완료되었습니다. 다시 로그인해주세요.");
						location.href="<%=request.getContextPath()%>/auth/logout.do";
					}
				}
			}
		
		</script>
	</head>
	<body onload="tab_load(1);check();">

		<jsp:include page="./header.jsp"/>
		<!-- Wrapper -->
		<div id="wrapper">

				<!-- Main -->
				<div id="main">
					<section id="two">
						<div class="container">

							<h3>Notice</h3>
							<p>주차공간을 공유하는 플랫폼_관리 웹페이지</p>
							<ul class="feature-icons">
								<li class="fa-hand-o-right" style="width:100%;">관리자는 신청자들의 계정을 등록할 시 "아이디는 이메일, 비밀번호는 주민뒷자리"로 합니다.</li>
								<li class="fa-hand-o-right" style="width:100%;">관리자는 주차공간 정보를 등록할 시 신청자의 회원번호를 제대로 입력하셔야 합니다.</li>
								<li class="fa-hand-o-right" style="width:100%;">관리자는 에러가 발생할 시 Contact 메뉴에 나온 각 담당자에게 연락할 수 있습니다.</li>
							</ul>							
							
						</div>
					</section>
				</div>
		</div>
	</body>
</html>