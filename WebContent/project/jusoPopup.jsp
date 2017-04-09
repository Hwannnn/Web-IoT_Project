<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<% 
			request.setCharacterEncoding("UTF-8");  //한글깨지면 주석제거
			String inputYn = request.getParameter("inputYn"); 
			String roadFullAddr = request.getParameter("roadFullAddr"); 
			String roadAddrPart1 = request.getParameter("roadAddrPart1"); 
			String roadAddrPart2 = request.getParameter("roadAddrPart2"); 
			String engAddr = request.getParameter("engAddr"); 
			String jibunAddr = request.getParameter("jibunAddr"); 
			String zipNo = request.getParameter("zipNo"); 
			String addrDetail = request.getParameter("addrDetail"); 
			String admCd    = request.getParameter("admCd");
			String rnMgtSn = request.getParameter("rnMgtSn");
			String bdMgtSn  = request.getParameter("bdMgtSn");
		%>
	</head>
	
	<script language="javascript">
		function init(){
			var url = location.href;
			var confmKey = "U01TX0FVVEgyMDE2MDkyMzE2MDIxODE1MzUz";
			var inputYn= "<%=inputYn%>";
			if(inputYn != "Y"){
				document.form.confmKey.value = confmKey;
				document.form.returnUrl.value = url;
				document.form.action="http://www.juso.go.kr/addrlink/addrLinkUrl.do"; //인터넷망
				document.form.submit();
			}else{
				opener.jusoCallBack("<%=roadFullAddr%>","<%=roadAddrPart1%>","<%=addrDetail%>");
				window.close();
			}
		}
	</script>
	
	<body onload="init();">
		<form id="form" name="form" method="post">
			<input type="hidden" id="confmKey" name="confmKey" value=""/>
			<input type="hidden" id="returnUrl" name="returnUrl" value=""/>
		</form>
	</body>
</html>