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
<label for="select">소장자료검색</label>
<form action="/book/searchBook" method="post" id="searchBook">
<!-- 검색구분 선택 -->
<label for="select">소장자료검색</label>
	<select name="searchSub">
		<option value="all" >전체</option>
		<option value="title">도서명</option>
		<option value="writer">저자</option>
		<option value="publisher">출판사</option>
		<option value="keyword">키워드</option>
	</select>
	<input type="text" name="searchTxt" placeholder="소장자료 검색">
	<input type="submit" value="검색">
</form>
<c:if test="${sessionScope.loginInfo.isAdmin eq 'Y' }" >
	<a href="/book/regBookForm">등록</a>
</c:if>
<a href="/book/hopeBookForm">희망도서</a>
<a href="/book/bookList">등록도서확인</a>
</body>
</html>