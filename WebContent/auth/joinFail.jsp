<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="refresh" content="0.5;url=join.do">
	</head>
	<script>
		function start() {
			var temp = <%=request.getParameter("val")%>;
			if (temp == "id") {
				alert("아이디가 중복되었습니다.");
			} else {
				alert("이메일이 중복되었습니다.");
			}
		}
	</script>
	<body onload = "start()">
	</body>
</html>
