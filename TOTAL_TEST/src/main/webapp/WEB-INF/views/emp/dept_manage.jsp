<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.list table {
    width: 80%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
    margin: 0 auto;
    padding: 3px;
    text-align: center;
    
  }
 .list  th, td {
    border-bottom: 1px solid #444444;
    border-left: 1px solid #444444;
    padding: 10px;
  }
 .list th:first-child,.list td:first-child {
    border-left: none;
  }


.manage table{
	text-align: center;
	width: 80%;
	margin: 0 auto;
}

.contatiner{
	margin: 0 auto;
	width:80%;
	padding: 10px;
}

</style>
</head>
<body>
<div class="container">
	<div>
	
		-부서등록
	</div>
	<div class="manage">
	
		<form action="/emp/regDept" method="post">
		<table class="manage">
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
	</div>
	<div>
		-부서등록
	</div>
	<div class="list">
	<table >
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
	</div>
</div>

</body>
</html>