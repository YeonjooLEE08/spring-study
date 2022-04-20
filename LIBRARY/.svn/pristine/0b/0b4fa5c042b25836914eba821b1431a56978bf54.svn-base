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
	margin: 0 auto;
}
</style>
</head>
<body>
<div>
제목 : ${clubBoard.cbBoardTitle } <br>
작성자 : ${clubBoard.memName }<br>
날짜 : ${clubBoard.cbBoardDate }<br>
내용 : ${clubBoard.cbBoardContent }<br>

<input type="button" value="목록" onclick="location.href='/club/clubDetail?clubCode=${clubBoard.clubCode}';">
<input type="button" value="수정" onclick="location.href='/club/clubBoardUpdate?cbBoardNum=${clubBoard.cbBoardNum}&&clubCode=${clubBoard.clubCode }';">
<input type="button" value="삭제" onclick="location.href='/club/clubBoardDelete?cbBoardNum=${clubBoard.cbBoardNum}&clubCode=${clubBoard.clubCode }';"> <br>

n개의 댓글<br>
<textarea rows="2" cols="30" name="cbCmtContent" style="resize: none;"></textarea> <br>
<input type="submit" value="댓글 등록" onclick="clubBoardRegCmt();">
</div>
</body>
</html>