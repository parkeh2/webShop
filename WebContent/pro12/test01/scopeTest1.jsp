<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//scope: pageContext(현제페이지) < request(요청마다) < session(브라우져) < application(웹프로그렘)
pageContext.setAttribute("major", "jspServlet박사...pageContext");
request.setAttribute("major", "jspServlet박사...request");
session.setAttribute("major", "jspServlet박사...session");
application.setAttribute("major", "jspServlet박사...application");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>저장하기</h1>
	<h2>default : ${major }</h2>
	<h2>pageContext : ${pageScope.major }</h2>
	<h2>request : ${requestScope.major }</h2>
	<h2>session : ${sessionScope.major }</h2>
	<h2>application : ${applicationScope.major }</h2>
	<hr>
	<%-- request가 전달된다. --%>
	<%--<jsp:forward page="scopeTest2.jsp"></jsp:forward>--%>

	<%--갔다가 다시 온다. include --%>
	<jsp:include page="scopeTest2.jsp"></jsp:include>
	<jsp:include page="scopeTest2.jsp"></jsp:include>
</body>
</html>