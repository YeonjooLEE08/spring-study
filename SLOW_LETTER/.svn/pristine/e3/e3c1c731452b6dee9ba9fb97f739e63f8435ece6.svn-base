<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div{
	text-align: center;
}
</style>
</head>
<body>
<div>모임명 : ${club.clubName }</div>
<div>모임소개 : ${club.clubIntro }</div>

<form action="/club/clubJoin" method="post" id="clubJoinForm">
<input type="hidden" name="clubCode" value="${club.clubCode }">
<input type="hidden" name="memId" value="${sessionScope.memId }">
<input type="hidden" name="memName" value="${sessionScope.memName }">
<div>
	<input type="button" value="가입하기" onclick="clubJoin(this);">
	<input type="button" value="뒤로가기" onclick="history.back();">
</div>
</form>
<script type="text/javascript" src="/resources/js/club/club_join.js?ver=3"></script>
</body>
</html>