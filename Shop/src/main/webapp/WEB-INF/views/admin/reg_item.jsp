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
			<form class="row g-3" action="/admin/regItem" method="post" id="regItemForm" enctype="multipart/form-data">
				<div class="col-12">
					<label for="categorySeletor" class="form-label">카테고리</label>
					<select class="form-select" id="categorySeletor" name="cateCode">
						<option value="1">선택</option>
						<c:forEach items="${categoryList }" var="category">
							<option value="${category.cateCode }">${category.cateName }</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-12">
					<label for="bookName" class="form-label">도서명</label>
					<input type="text" class="form-control" id="bookName" name="itemName">
				</div>
				<div class="col-12">
					<label for="bookPrice" class="form-label">도서 가격</label>
					<input type="text" class="form-control" id="bookPrice" name="itemPrice">
				</div>
				<div class="col-12">
					<label for="bookIntro" class="form-label">도서 소개</label>
					<textarea class="form-control" rows="3" id="bookIntro" name="itemDetail"></textarea>
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

<script src="/resources/js/admin/reg_item.js" type="text/javascript"></script>
</body>
</html>






























