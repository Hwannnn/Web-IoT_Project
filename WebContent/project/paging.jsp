<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<form method="get" action="./projectsearch.do">
	<div class="row uniform" >
		<input type="hidden" name="pageNo" value="1"/>
		<div class="3u">
			<select name="search" id="search" required>
				<option value="">선택</option>
				<option value="auth_id">아이디</option>
				<option value="roadFullAddr">주소</option>
			</select>
		</div>
		<div class="7u"><input type="text" name="con" id="con" required/></div>										
		<div class="2u">
			<ul class="actions">
				<li><input type="submit" value="Search" /></li>
			</ul>
		</div>
	</div>
</form>


<div class="paginate">
    <a href="javascript:goPage(${param.firstPageNo});" class="first">처음</a>
    <a href="javascript:goPage(${param.prevPageNo});" class="prev">이전</a>
    <span>
        <c:forEach var="i" begin="${param.startPageNo}" end="${param.endPageNo}" step="1">
            <c:choose>
                <c:when test="${i eq param.pageNo}"><a href="javascript:goPage(${i});" class="choice">${i}</a></c:when>
                <c:otherwise><a href="javascript:goPage(${i});">${i}</a></c:otherwise>
            </c:choose>
        </c:forEach>
    </span>
    <a href="javascript:goPage(${param.nextPageNo});" class="next">다음</a>
    <a href="javascript:goPage(${param.finalPageNo});" class="last">마지막</a>
</div>


<script>
	function goPage(n){
		var address = "<%=request.getRequestURI()%>" ;
		
		if (address == "/adminWeb/project/projectlist.do") {
			location.href = address + "?pageNo=" + n;
		} else if (address == "/adminWeb/project/projectsearch.do") {
			location.href = address + "?pageNo=" + n + "&search=${paging.search}&con=${paging.con}";

		}
	}
</script>