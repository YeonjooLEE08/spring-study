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
					<label for="categorySeletor" class="form-label">카테고리</label>
					<select class="form-select" id="categorySeletor" name="cateCode">
						<option value="1">선택</option>
						<c:forEach items="${cateList }" var="category">
							<option value="${category.cateCode }">${category.cateName }</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-12">
					<label for="bookCode" class="form-label">도서코드</label>
					<input type="text" class="form-control" id="bookCode" name="bookCode">
				</div>
				<div class="col-12">
					<label for="title" class="form-label">도서명</label>
					<input type="text" class="form-control" id="title" name="title">
				</div>
				<div class="col-12">
					<label for="Writer" class="form-label">저자</label>
					<input type="text" class="form-control" id="Writer" name="Writer">
				</div>
				<div class="col-12">
					<label for="keyword" class="form-label">키워드</label>
					<textarea class="form-control" rows="3" id="keyword" name="keyword"></textarea>
				</div>
				<div class="col-12">
					<label for="publisher" class="form-label">출판사</label>
					<input type="text" class="form-control" id="publisher" name="publisher">
				</div>
				<div class="col-12">
					<label for="bookStock" class="form-label">재고</label>
					<input type="text" class="form-control" id="bookStock" name="bookStock">
				</div>
				<div class="col-12">
					<label for="pubDate" class="form-label">출판일</label>
					<input type="text" class="form-control" id="pubDate" name="pubDate">
				</div>
				<div>
					<label for="file" class="form-label">표지</label>
					<input type="file" class="form-control" id="mainImg" >
					이미지없으면기본이미지임
				</div>
				<div class="col-12 d-grid gap-2">
					<input type="submit" value="도서 등록">
				</div>
			</form>
		</div>
	</div>
</div>
<script src="/resources/js/admin/reg_book.js" type="text/javascript"></script>
</body>
</html>

