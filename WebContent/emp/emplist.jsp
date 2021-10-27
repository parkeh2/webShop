<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>직원 목록....scriptLet, EL문법</h1>
	<a href="empinsert">신규직원등록</a>
	<!-- JSP가 합쳐져서 컴파일된다. -->
	<%@ include file="logininfo.jsp"%>
	<br>
	<br>

	<!-- scriptLet:가장오래된 문법 %= -->
	<!-- $ -->
	<table border="1">
		<tr>
			<td>직원번호</td>
			<td>성</td>
			<td>이름</td>
			<td>부서</td>
			<td>직책</td>
			<td>전화번호</td>
			<td>이메일</td>
			<td>매니져</td>
			<td>커미션</td>
			<td>급여</td>
			<td>입사일</td>
		</tr>
		<%
		// EL 문법 ==> ${emplist}
		// ScriptLet 문법 ==> (List<EmployeeVo>)request.getAttribute("emplist")
		// JSTL문법 ==> tag이용 <forEach items="${emplist}" ></forEach>
		%>
		<c:forEach items="${emplist}" var="emp">
			<tr>
				<td><a href="empdetail?empid=${emp.employee_id}">${emp.employee_id}</a></td>
				<td>${emp.last_name}</td>
				<td>${emp.first_name}</td>
				<td>${emp.department_id}</td>
				<td>${emp.job_id}</td>
				<td>${emp.phone_number}</td>
				<td>${emp.email}</td>
				<td>${emp.manager_id}</td>
				<td>${emp.commission_pct}</td>
				<td>${emp.salary}</td>
				<td>${emp.hire_date}</td>
				<td><button onclick="call(${emp.employee_id})">삭제하기</button></td>
			</tr>
		</c:forEach>
	</table>
	<script type="text/javascript">
	function call(empid) {
		location.href="empdelete?empid=" + empid;
	}
	</script>
</body>
</html>