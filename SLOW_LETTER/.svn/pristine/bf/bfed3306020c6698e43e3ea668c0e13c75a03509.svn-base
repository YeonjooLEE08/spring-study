<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div{
	text-align: center;
}
</style>
</head>
<body>
<div>신청한 회원 리스트</div>
<div>
	<table>
		<thead>
			<tr>
				<td>No</td>
				<td>아이디</td>
				<td>이름</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${applyList }" var="apply">
			<tr>
				<td>1</td>
				<td>${apply.memId }</td>
				<td>${apply.memName }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>

</body>
</html>