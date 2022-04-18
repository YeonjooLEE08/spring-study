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
</style>
</head>
<body>
<div class="row">
	<c:forEach items="${itemList }" var="item">
		<div class="col-3 text-center" style="margin-bottom: 16px;">
			<div class="card" style="width: 13rem; margin: 0 auto;">
			  <a href="/item/itemDetail?itemCode=${item.itemCode }"><img src="/resources/images/${item.attachedImgName }" class="card-img-top" alt="..." height="250px;"></a>
			  <div class="card-body" style="padding: 0.2rem 1.2rem;">
			    <h5 class="card-title">${item.itemName }</h5>
			    <p class="card-text">
			    	<fmt:formatNumber value="${item.itemPrice }" pattern="\#,###"/>
			    </p>
			  </div>
			</div>
		</div>
	</c:forEach>
</div>
</body>
</html>



