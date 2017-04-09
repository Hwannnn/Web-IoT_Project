<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import="org.json.simple.*"
import="java.util.Map"%>

<%
	JSONObject jsonMain = new JSONObject();
	
	jsonMain = (JSONObject) request.getAttribute("mapinfo");

	out.println(jsonMain.toJSONString());
	
%>

