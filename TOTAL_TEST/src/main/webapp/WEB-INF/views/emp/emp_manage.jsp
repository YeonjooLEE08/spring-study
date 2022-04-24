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
<form action="/emp/regEmp" method="post">
	<table>
		<tr>
			<td>
				사원명</td>
			<td><input type="text" name="eName"></td>
		</tr>
		<tr>
			<td>
				직급</td>
			<td>
				<select name="job">
					<option value="부장">부장</option>
					<option value="과장">과장</option>
					<option value="대리">대리</option>
					<option value="사원">사원</option>
				</select></td>
			<td>
				부서</td>
			<td>
				<select name="dNum">
					<c:forEach items="${deptList }" var="dept">
						<option value="${dept.dNum }">${dept.dName }</option>
					</c:forEach> 
				</select></td>
		</tr>
		<tr>
			<td>
				성별</td>
			<td>
				<input type="radio" name="gender" value="남" checked>남 
				<input type="radio" name="gender" value="여">여</td>
			<td>
				나이</td>
			<td>
				<input type="number" min="1" max="70" name="eAge" value="20"></td>
		</tr>
		<tr>
			<td>
				연락처</td>
			<td>
				<input type="text" name="tell"> <input type="text" name="tell"> <input type="text" name="tell"></td>
		</tr>
	</table>
	<input type="submit" value="전송">
</form>
</body>
</html>