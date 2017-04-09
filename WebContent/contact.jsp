<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Contact</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" />
		<script src="<%=request.getContextPath()%>/js/index.js"></script>
	</head>
	<body onload="tab_load(4)">

		<jsp:include page="./header.jsp"/>
		<!-- Wrapper -->
		<div id="wrapper">

				<!-- Main -->
				<div id="main">
					<!-- Four -->
							<section id="four">
								<div class="container">
									<h3>Developer</h3>
									<p>플랫폼 사용에 있어 문제가 생기신 경우에는 아래의 담당 개발자에게 연락주세요.</p><hr/>
									<div class="features">
										<article>
											<a href="" class="image"><img src="./images/pic01.jpg" alt="" /></a>
											<div class="inner">
												<h4>유제봉</h4>
												<p>Responsibilities : Android<br/>
												<ul class="feature-icons">
													<li class="fa-phone">010-2926-1992</li><br/>
													<li class="fa-envelope">jebong92@naver.com</li>
												</ul>
											</div>
										</article>
										<article>
											<a href="" class="image"><img src="./images/pic02.jpg" alt="" /></a>
											<div class="inner">
												<h4>이충기</h4>
												<p>Responsibilities : Raspberry Pi(CCTV)</p>
												<ul class="feature-icons">
													<li class="fa-phone">010-5678-9712</li><br/>
													<li class="fa-envelope">cndrlekd3@gmail.com</li>
												</ul>
											</div>
										</article>
										<article>
											<a href="" class="image"><img src="./images/pic03.jpg" alt="" /></a>
											<div class="inner">
												<h4>신창환</h4>
												<p>Responsibilities : Web Appication</p>
												<ul class="feature-icons">
													<li class="fa-phone">010-9900-3975</li><br/>
													<li class="fa-envelope">tprp5950@gmail.com</li>
												</ul>
											</div>
										</article>
									</div>
								</div>
							</section>


				</div>
		</div>
	</body>
</html>