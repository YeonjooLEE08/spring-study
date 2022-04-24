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
-부서등록
<form action="/emp/regDept" method="post">
<table>
	<tr>
		<td colspan=10%>
			부서명</td>
		<td colspan=35%>
			<input type="text" name="dName"></td>
		<td colspan=10%>
			지역</td>
		<td colspan=35%>
			<select name="dLoc">
				<option value="서울" >서울</option>
				<option value="부산" >부산</option>
				<option value="대전" >대전</option>
				<option value="대구" >대구</option>
				<option value="인천" >인천</option>
			</select></td>
		<td colspan=10%>
			<input type="submit" value="등록"></td>
	</tr>
</table>
</form>
-부서등록 
<table>
	<thead>
		<tr>
			<td>부서번호</td>
			<td>부서명</td>
			<td>지역</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${deptList}" var="dept">
			<tr>
				<td>${dept.dNum }</td>
				<td>${dept.dName }</td>
				<td>${dept.dLoc }</td>
			</tr> 
		</c:forEach>
	</tbody>
</table>
</body>
</html>