<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
request.setAttribute("address", "서울시 강남구");
%>

<html>
<head>
<meta charset="UTF-8">
<title>forward</title>
</head>
<body>
	<%--내 페이지가 요청받았는대 다른 페이지가 위임한다. --%>
	<jsp:forward page="member2.jsp"></jsp:forward>
</body>
</html>
