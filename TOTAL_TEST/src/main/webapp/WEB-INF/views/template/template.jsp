<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
	<tiles:insertAttribute name="title"/>
</title>
<style type="text/css">
	header, article{
		width: 100%;
		margin: 0px auto;
	}
</style>
</head>
<body>
<header>
	<tiles:insertAttribute name="menu"/>
</header>
<article>
	<tiles:insertAttribute name="body"/>
</article>
</body>
</html>