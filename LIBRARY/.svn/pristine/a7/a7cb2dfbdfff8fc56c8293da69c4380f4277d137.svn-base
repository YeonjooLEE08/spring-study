<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table, tr, td{
		border-collapse: collapse;
		border: 1px solid black;
	}
	.myPageDiv{
		width: 80%;
		margin: 0px auto;
		display: flex;
		justify-content: space-between;
	}
	.myPage-simple{
		border: 1px solid black;
		display: flex;
		flex-direction: column;
	}
	.myPage-simple img{
		width: 10rem;
	}
</style>
</head>
<body>
<div class="container">
	<div class="pageName">
		마이페이지
	</div>
	<div class="myPageDiv">
		<section class="myPage-simple">
			<div>
				<img alt="" src="/resources/images/member/profile_sample.jpg">
			</div>
			<div>
			${memberVO.memName }
			회원 정보 대출정보</div>
		</section>
		<div>
			<section>
				<table>
					<tr>
						<td>
							<a href="/WEB-INF/views/member/mypage/my_page_detail.jsp?memId=${sessionScope.loginInfo.memId}">
						내 정보 상세조회</a></td>
					</tr>
					<tr>
						<td>대출목록 상세조회</td>
					</tr>
					<tr>
						<td>구매목록 상세조회</td>
					</tr>
					<tr>
						<td>독서 플래너</td>
					</tr>
					<tr>
						<td>북클럽 조회</td>
					</tr>
				</table>
			
			</section>
		</div>
	</div>
</div>
</body>
</html>