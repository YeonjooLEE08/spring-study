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
<div class="row">
	<div class="col">
		<h4>Registration Book</h4>
	</div>
</div>
<div class="row">
	<div class="col-8">
		<div style="background-color: #eeeeee; padding: 16px; border-radius: 12px;">
			<form class="row g-3" action="/admin/regBook" method="post" id="regBookForm" enctype="multipart/form-data">
				<div class="col-12">
					<label for="bookCode" class="form-label">도서코드</label>
					<input type="text" class="form-control" id="bookCode" name="bookCode">
				</div>
				<div class="col-12">
					<label for="bookName" class="form-label">도서명</label>
					<input type="text" class="form-control" id="bookName" name="bookName">
				</div>
				<div class="col-12">
					<label for="bookContent" class="form-label">도서 소개</label>
					<textarea class="form-control" rows="3" id="bookContent" name="bookContent"></textarea>
				</div>
				<div class="col-12">
					<label for="publisher" class="form-label">저자</label>
					<input type="text" class="form-control" id="publisher" name="publisher">
				</div>
				<div class="col-12">
					<label for="cateCode" class="form-label">카테고리</label>
					<input type="text" class="form-control" id="cateCode" name="cateCode">
				</div>
				<div class="col-12">
					<label for="bookStock" class="form-label">재고</label>
					<input type="text" class="form-control" id="bookStock" name="bookStock">
				</div>
				<div class="col-12">
					<label for="madeDate" class="form-label">출판일</label>
					<input type="text" class="form-control" id="madeDate" name="madeDate">
				</div>
				<div class="col-12">
					<label for="img" class="form-label">대표이미지</label>
					<input type="file" class="form-control" id="img" name="mainImg">
				</div>
				<div class="col-12">
					<label for="subImg" class="form-label">추가이미지</label>
					<input type="file" class="form-control" id="subImg" name="subImg" multiple>
				</div>
				<div class="col-12 d-grid gap-2">
					<button type="button" class="btn btn-primary" onclick="regBook();">도서등록</button>
				</div>
			</form>
		</div>
	</div>
</div>

</body>
</html>

