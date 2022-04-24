<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<thead>
		<tr>
			<td rowspan="2">No.</td>
			<td colspan="4">사원정보</td>
			<td colspan="2">부서정보</td>
		</tr>
		<tr>
			<td>사원명</td>
			<td>연락처</td>
			<td>성별</td>
			<td>나이</td>
			<td>부서명</td>
			<td>지역</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${empList }" var="emp">
			<tr>
				<td>${emp.eNum }</td>
				<td>${emp.eName }</td>
				<td>${emp.tell }</td>
				<td>${emp.eAge }</td>
				<td>${emp.dName }</td>
				<td>${emp.dLoc }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>