<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String name2 = (String) session.getAttribute("name");
String address2 = (String) session.getAttribute("address");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session 내장 객체 테스트2</title>
</head>
<body>
	이름은
	<%=name2%>입니다.
	<br> 주소는
	<%=address2%>입니다.
	<%@ include file="../hello.jsp"%>
	<%-- 바람직하지않음  <%@ include file="../gugu.html" %> --%>
	<jsp:include page="../gugu2.jsp">
		<jsp:param value="8" name="dan" />
	</jsp:include>
</body>
</html>
