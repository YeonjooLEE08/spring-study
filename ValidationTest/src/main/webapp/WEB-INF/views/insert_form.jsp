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
	<div class="row">
		<div class="col-6">
			<form action="/test/insert" method="post" id="insertForm" class="needs-validation">
				<div class="row">
					<div class="col">
						ID <input type ="text" name="id" class="form-control" autocomplete="none"> <!--기록저장X -->
						<div class="valid-feedback">
    						  Looks good!
   						 </div>
					</div>
				</div>
				<div class="row">
					<div class="col">
						PW <input type ="password" name="pw" id="pw"  class="form-control">
					</div>
				</div>
				<div class="row">
					<div class="col">
						PW Confirm <input type ="password" name="pwConfirm"  class="form-control">
					</div>
				</div>
				<div class="row">
					<div class="col">
						EMAIL <input type ="text" name="email" class="form-control">
					</div>
				</div>
				<div class="row">
					<div class="col">
						
					</div>
				</div>
				<div class="row">
					<div class="col">
					<input type="submit" value="전송">
					</div>
				</div>
			</form>
		</div>
	
	</div>

</div>

<!-- 부트스트랩 css -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- jquery 로딩 -->
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<!-- 부트스트랩 js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script> 
<!-- jquery validation 사용 문법 로딩  -->
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="/resources/insert_form.js?ver=7"></script>
</body>
</html>