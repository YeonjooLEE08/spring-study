<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
img:hover{
	opacity: 0.7;
}
table{
	width:90%;
	padding-bottom: 10px;
}
.searchForm{
	padding-bottom: 10px;
}
.list{
	padding-bottom: 10px;
}
</style>
</head>
<body>
<div >
<%-- 	<c:forEach items="${bookList }" var="book">
		<div class="col-3 text-center" style="margin-bottom: 16px;">
			<div class="card" style="width: 13rem; margin: 0 auto;">
			  <a href="/book/bookDetail?bookCode=${book.bookCode }"><img src="/resources/images/book/${book.bkImg }" class="card-img-top" alt="..." height="250px;"></a>
			  <div class="card-body" style="padding: 0.2rem 1.2rem;">
			    <h5 class="card-title">${book.title }</h5>
			    <p class="card-text">
			    </p>
			  </div>
			</div>
		</div>
	</c:forEach> --%>
<div class="searchForm">
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
</div>

<c:forEach items="${bookList}" var="book">
<div class="list" id="list">
<table>
	<tr>
		
		<td rowspan="3"><a href="/book/bookDetailAdmin?bookCode=${book.bookCode }&memId=${sessionScope.loginInfo.memId}"><img src="/resources/images/book/${book.bkImg }"  alt="..." height="120px;" width="80px;" ></a></td>
		<td colspan="2"><a href="/book/bookDetailAdmin?bookCode=${book.bookCode }"><strong>${book.title }</strong></a></td>
		<td>
			<input type="hidden" id="bookCode" value="${book.bookCode }">
			<button type="button" data-toggle="modal"  data-target="#deleteBook" onclick="showModal(this);">삭제</button>
		</td>
	</tr>
	<tr>
		<td>저자</td>
		<td colspan="2">${book.writer }</td>
	</tr>
	<tr>
		<td>발행처</td>
		<td colspan="2">${book.publisher }</td>
	</tr>
	<tr>
		<td>발행년도</td>
		<td>${book.pubDate }</td>
		<td colspan="2">ISBN<td>
		<td>${book.isbn }<td>
	</tr>
	<tr>
		<td>키워드</td>
		<td colspan="3">${book.keyword }</td>
	</tr>
	<tr>
		<td colspan="4">*자료위치 ${book.area }</td>		
	</tr>

	


</table>
</div>
</c:forEach>
</div>

<!--삭제 확인  Modal -->
<div class="modal fade" id="deleteBook" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
  	<input type="hidden" id="originBookCode" value="">
    <div class="modal-content">
      <div class="modal-body">
      	삭제하시겠습니까?
			          
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" id="closeModalBtn" data-dismiss="modal">닫기</button>
        <button type="button" class="btn btn-primary" onclick="deleteBk();">삭제</button>
      </div>
    </div>
  </div>
 </div>

<script type="text/javascript" src="/resources/js/book/admin_manageBook.js?ver=5"></script>
</body>
</html>
