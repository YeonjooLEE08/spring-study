<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<c:forEach items="${bookDetail }" var="book">
		<img src="/resources/images/book/${book.bkImg }" class="card-img-top" alt="..." height="250px;">
		<h3>${book.title }</h3>
	<table>
		<tr>
			<td>저자</td>
			<td> ${book.writer }</td>
			<td>발행처</td>
			<td>${book.publisher }</td>
			<td>발행년도</td>
			<td>${book.pubDate }</td>
		</tr>
		<tr>
			<td>청구기호</td>
			<td>청구기호</td>
			<td>ISBN</td>
			<td>ISBN</td>
			<td>키워드</td>
			<td>${book.keyword }</td>
		</tr>
	</table>
	<button type="button" onclick="location.href='/book/plusRcdCnt';">추천 ${book.rcdCnt } </button>
	<button type="button" onclick="location.href='/book/selectStatus';">${book.status } ${book.bookStock }</button>
	
	
	</c:forEach>
</div>
</body>
</html>