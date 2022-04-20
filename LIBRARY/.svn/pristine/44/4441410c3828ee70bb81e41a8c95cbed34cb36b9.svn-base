<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<h2>희망 도서 신청 폼</h2>
	<div class="row">
		<div class="col-6">
			<form action="/book/regHopeBook" method="post" id="regHopeBookForm">
				<div class="row">
					<div class="col">
						코드 <input type ="text" name="hopeCode" id="hopeCode" class="form-control" autocomplete="none"> <!--기록저장X -->
					</div>
				</div>
				<div class="row">
					<div class="col">
						제목 <input type ="text" name="hopeName" id="hopeName" class="form-control" autocomplete="none"> <!--기록저장X -->
					</div>
				</div>
				<div class="row">
					<div class="col">
						저자 <input type ="text" name="hopeWriter" id="hopeWriter"  class="form-control">
					</div>
				</div>
				<div class="row">
					<div class="col">
						출판사 <input type ="text" name="hopePublisher" id="hopePublisher"  class="form-control">
					</div>
				</div>
				<div class="row">
					<div class="col">
						신청인 <input type="text" name="memId" id="memId" value="${sessionScope.loginInfo.id }" class="form-control" readonly>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<button type = "button" class="btn" onclick="regHopeBook();">제출</button>
					</div>
				</div>
			</form>
		</div>
	
	</div>

</div>

<!-- jquery validation 사용 문법 로딩  -->
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="/resources/js/book/reg_hope_book.js"></script>

</body>
</html>