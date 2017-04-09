<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Sharing Parking Info</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" />
		<script src="<%=request.getContextPath()%>/js/index.js"></script>
		<script>
			function bring_value(){
				tab_load(2);				
				
				var len1 = document.f.startTime.options.length;
				var len2 = document.f.endTime.options.length;
				var len3 = document.f.cam.options.length;

				for(i=0; i<len1; i++){
					if(document.f.startTime.options[i].value == "${project.startTime}") {
						document.f.startTime.options[i].selected = true;
						break;
					}
				
				}
				for(i=0; i<len2; i++){
					if(document.f.endTime.options[i].value == "${project.endTime}") {
						document.f.endTime.options[i].selected = true;
						break;
					}
				
				}
				for(i=0; i<len3; i++){
					if(document.f.cam.options[i].value == "${project.cam}") {
						document.f.cam.options[i].selected = true;
						break;
					}
				
				}
			}
		</script>
	</head>
	<body onload="bring_value()">
	
		<jsp:include page="../header.jsp"/>

		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Main -->
					<div id="main">
						<!-- Four -->
							<section id="four">
								<div class="container">
									<h3>Sharing Parking Info</h3>
									<p>공유 주차공간 변경내역은 정확히 입력해주세요.</p><hr/>
									
									<form name="f">
										<div class="row uniform">
											<div class="3u 12u(xsmall)">프로젝트 번호.</div>										
											<div class="3u 12u(xsmall)"><input type="text" name="project_no" id="project_no" value="${project.project_no}" readonly/></div>
											<div class="3u 12u(xsmall)">이름</div>
											<div class="3u 12u(xsmall)"><input type="text" name="name" id="name" value="${project.name}" readonly/></div>
										</div>
										<div class="row uniform">
											<div class="3u 12u(xsmall)">제공자 전화번호</div>
											<div class="3u 12u(xsmall)"><input type="text" name="phone" id="phone" value="${project.phone}" readonly/></div>
											<div class="3u 12u(xsmall)">주차 면수</div>
											<div class="3u 12u(xsmall)"><input type="text" name="lot" id="lot" value="${project.lot}" readonly/></div>
										</div>
										<div class="row uniform">
											<div class="6u 12u(xsmall)">제공자 이메일</div>
											<div class="6u 12u(xsmall)"><input type="text" name="email" id="email" value="${project.email}" readonly/></div>

										</div>
										<div class="row uniform">
											<div class="6u 12u(xsmall)">이용가능 시간</div>
											<div class="2u">
												<select name="startTime" disabled>
													<option>선택</option>
													<option id="00" value="00">00</option>
													<option id="00" value="01">01</option>
													<option id="00" value="02">02</option>
													<option id="00" value="03">03</option>
													<option id="00" value="04">04</option>
													<option id="00" value="05">05</option>
													<option id="00" value="06">06</option>
													<option id="00" value="07">07</option>
													<option id="00" value="08">08</option>
													<option id="00" value="09">09</option>
													<option id="00" value="10">10</option>
													<option id="00" value="11">11</option>
													<option id="00" value="12">12</option>
													<option id="00" value="13">13</option>
													<option id="00" value="14">14</option>
													<option id="00" value="15">15</option>
													<option id="00" value="16">16</option>
													<option id="00" value="17">17</option>
													<option id="00" value="18">18</option>
													<option id="00" value="19">19</option>
													<option id="00" value="20">20</option>
													<option id="00" value="21">21</option>
													<option id="00" value="22">22</option>
													<option id="00" value="23">23</option>
												</select>
											</div>
											<div class = "2u" style="text-align:center;"><h4>~</h4></div>
											<div class = "2u">
												<select name="endTime" disabled>
													<option>선택</option>
													<option id="00" value="00">00</option>
													<option id="00" value="01">01</option>
													<option id="00" value="02">02</option>
													<option id="00" value="03">03</option>
													<option id="00" value="04">04</option>
													<option id="00" value="05">05</option>
													<option id="00" value="06">06</option>
													<option id="00" value="07">07</option>
													<option id="00" value="08">08</option>
													<option id="00" value="09">09</option>
													<option id="00" value="10">10</option>
													<option id="00" value="11">11</option>
													<option id="00" value="12">12</option>
													<option id="00" value="13">13</option>
													<option id="00" value="14">14</option>
													<option id="00" value="15">15</option>
													<option id="00" value="16">16</option>
													<option id="00" value="17">17</option>
													<option id="00" value="18">18</option>
													<option id="00" value="19">19</option>
													<option id="00" value="20">20</option>
													<option id="00" value="21">21</option>
													<option id="00" value="22">22</option>
													<option id="00" value="23">23</option>
												</select>
											</div>
										</div>
										<div class="row uniform">
											<div class="6u 12u(xsmall)">CCTV 설치여부</div>
											<div class="6u 12u(xsmall)">
												<select name="cam" disabled>
													<option>선택</option>
													<option id="yes" value="yes">Yes</option>
													<option id="no" value="no">No</option>
												</select>
											</div>
										</div>
										<div class="row uniform">
											<div class="6u 12u(xsmall)">CCTV 개수</div>
											<div class="3u 12u(xsmall)"><input type="text" name="camnum" id="camnum" value="${project.camnum}" readonly/></div>
											<div class="3u 12u(xsmall)">
												<input type="button" value="Show CCTV"onclick="window.open('../album/cam_images.jsp?pnum=${project.project_no}&cnum=${project.camnum}')"/>
											</div>
										</div>
										<div class="row uniform">
											<div class="6u 12u(xsmall)">정확한 주소검색을 위해 우측 버튼을 클릭하세요.</div>
											<div class="6u 12u(xsmall)"><input type="button" onClick="goPopup();" value="주소검색"/></div>
										</div>
										<div class="row uniform">
											<div id="list"></div>
											<div class="12u" id="callBackDiv">
												<table>
													<tr><td>도로명주소 전체</td><td><input type="text" id="roadFullAddr"  name="roadFullAddr" value="${project.roadFullAddr}" readonly /></td></tr>
													<tr><td>도로명주소           </td><td><input type="text" id="roadAddrPart1"  name="roadAddrPart1" value="${project.roadAddrPart1}" readonly /></td></tr>
													<tr><td>고객입력 상세주소    </td><td><input type="text" id="addrDetail"  name="addrDetail" value="${project.addrDetail}" readonly /></td></tr>
												</table>
											</div>
										</div>
										<div class="row uniform">
											<div class="6u 12u(xsmall)">위치정보</div>
											<div class="3u 12u(xsmall)"><input type="text" name="lat" id="lat" value="${project.lat}" required/></div>
											<div class="3u 12u(xsmall)"><input type="text" name="lng" id="lng" value="${project.lng}" required/></div>
										</div>
										<div class="row uniform">
											<div class="12u"><textarea name="message" id="message" rows="6" readonly>${project.message}</textarea></div>
										</div>
										<hr/>
										<div class="row uniform">
											<div class="12u" id="align-center">
												<ul class="actions">
													<li><input type="button" value="Update" class="special" onclick='location.href="projectupdate.do?project_no=${project.project_no}";'/></li>
													<li><input type="button" value="Delete" onclick='location.href="projectdelete.do?project_no=${project.project_no}";'/></li>
													<li><input type="button" value="Cancel" onClick="history.back()"/></li>
												</ul>
											</div>
										</div>
									</form>
								</div>
							</section>
					</div>
			</div>
	</body>
</html>