<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

			
	<div class="searchHopeBook">
		<input id="bookName" type="text" placeholder="제목">
		<input id="bookWriter" type="text" placeholder="저자">
		<input id="bookPublisher" type="text" placeholder="출판사">
		<button id="search">검색</button>
	</div>		
	
	<div class="resultHopeBook">
		<div class="result-row-thead">
			<div>표지</div>
			<div>제목</div>
			<div>작가</div>
			<div>출판사</div>
		</div>
	</div>
	
	<form action="/book/regHopeBook" method="post">
		<div class="hpBookForm">
			<table>
				<tr>
					<td>신청인</td>
					<td> ${sessionScope.loginInfo.memName }</td>
					<td>신청일</td>
					<td><%= sf.format(nowTime) %></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" id="title" name="title" value=""></td>
				</tr>
				<tr>
					<td>저자</td>
					<td><input type="text" id="writer" name="writer" value=""></td>
				</tr>
				<tr>
					<td>출판사</td>
					<td><input type="text" id="publisher" name="publisher" value=""></td>
				</tr>
			</table>
			<div>
				<button type="submit">신청하기</button>
			</div>
		</div>
	</form>






<script type="text/javascript" src="/resources/js/book/reg_hope_book.js?ver=20"></script>
</body>
<meta name="referrer" content="unsafe-url" />
</html>