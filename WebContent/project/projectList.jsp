<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Sharing Parking Lot List</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" />
		<script src="<%=request.getContextPath()%>/js/index.js"></script>
	</head>
	<body onload="tab_load(2);">
	
		<jsp:include page="../header.jsp"/>

		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Main -->
					<div id="main">
						<section id="two">
							<div class="container">
								<div class="row uniform">
									<div class="10u 12u(xsmall)"><nobr><h3>Sharing Parking List</h3></nobr></div>
									<div class="2u 12u(xsmall)"><input type="button" class="special" onClick="location.href='./projectadd.do'" value="Regist"/></div>
								</div><hr/>
								<table style="table-layout:fixed">
									<tr>
										<th id="col1">번호</th>
										<th id="col3">아이디</th>
										<th id="col4">주소</th>
										<th id="col5">면수</th>
									</tr>
									<c:set var="rowNo" value="${paging.n1}"></c:set>
									<c:forEach var="project" items="${projects}">
										<tr>
											<td class="col6"><nobr>${rowNo}</nobr></td>
											<c:set var="rowNo" value="${rowNo+1}"></c:set>
											<td class="col6"><nobr><a href="./projectinfo.do?project_no=${project.project_no}">${project.auth_id}</a></nobr></td>
											<td class="col6"><nobr>${project.roadFullAddr}</nobr></td>
											<td class="col6"><nobr>${project.lot}</nobr></td>
										</tr>						
									</c:forEach>
								</table>
								
								<jsp:include page="paging.jsp" flush="true">
								    <jsp:param name="firstPageNo" value="${paging.firstPageNo}" />
								    <jsp:param name="prevPageNo" value="${paging.prevPageNo}" />
								    <jsp:param name="startPageNo" value="${paging.startPageNo}" />
								    <jsp:param name="pageNo" value="${paging.pageNo}" />
								    <jsp:param name="endPageNo" value="${paging.endPageNo}" />
								    <jsp:param name="nextPageNo" value="${paging.nextPageNo}" />
								    <jsp:param name="finalPageNo" value="${paging.finalPageNo}" />
								</jsp:include>
							</div>
						</section>
					</div>
			</div>
	</body>
</html>