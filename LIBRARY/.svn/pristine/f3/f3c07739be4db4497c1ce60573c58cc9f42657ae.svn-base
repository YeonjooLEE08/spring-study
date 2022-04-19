<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.itemDiv{
	width: 400px;
	position: relative;
	height: 500px;
}
.freeMark{
	height: 10px;
	font-size: x-small;
	width: 40px;
	color: blue;
	margin-bottom: 8px;
}
.itemNameDiv{
	font-size: x-large;
	font-weight: bold;
	letter-spacing: 3px;
	word-spacing: 3px;
}
table{
	margin-top: 40px;
	margin-bottom: 20px;
	width: 400px;
}
tr th{
 text-align: right;
 padding-right: 30px;
}
.button{
	position: absolute;
	bottom: 50px;
}
.btn-8 {
  background-color: #f0ecfc;
background-image: linear-gradient(315deg, #f0ecfc 0%, #c797eb 74%);
  line-height: 42px;
  padding: 0;
  border: none;
  margin-bottom: 10px;
  width: 200px;
  text-align: center;
}
.btn-8 span {
  position: relative;
  display: block;
  width: 100%;
  height: 100%;
}
.btn-8:before,
.btn-8:after {
  position: absolute;
  content: "";
  right: 0;
  bottom: 0;
  background: #c797eb;
  /*box-shadow:  4px 4px 6px 0 rgba(255,255,255,.5),
              -4px -4px 6px 0 rgba(116, 125, 136, .2), 
    inset -4px -4px 6px 0 rgba(255,255,255,.5),
    inset 4px 4px 6px 0 rgba(116, 125, 136, .3);*/
  transition: all 0.3s ease;
}
.btn-8:before{
   height: 0%;
   width: 2px;
}
.btn-8:after {
  width: 0%;
  height: 2px;
}
.btn-8:hover:before {
  height: 100%;
}
.btn-8:hover:after {
  width: 100%;
}
.btn-8:hover{
  background: transparent;
}
.btn-8 span:hover{
  color: #c797eb;
}
.btn-8 span:before,
.btn-8 span:after {
  position: absolute;
  content: "";
  left: 0;
  top: 0;
  background: #c797eb;
  /*box-shadow:  4px 4px 6px 0 rgba(255,255,255,.5),
              -4px -4px 6px 0 rgba(116, 125, 136, .2), 
    inset -4px -4px 6px 0 rgba(255,255,255,.5),
    inset 4px 4px 6px 0 rgba(116, 125, 136, .3);*/
  transition: all 0.3s ease;
}
.btn-8 span:before {
  width: 2px;
  height: 0%;
}
.btn-8 span:after {
  height: 2px;
  width: 0%;
}
.btn-8 span:hover:before {
  height: 100%;
}
.btn-8 span:hover:after {
  width: 100%;
}

</style>
</head>
<body>
아이템상세보기예용

<div class="row">
	<div class="col-12">
		<a href="/item/itemList">home</a>/<a>악세사리</a>
		<div class="row">
			<div class="col-6">
				<c:forEach items="${item.itemImgList }" var="img">
					<c:if test="${img.isMain eq 'Y' }">
						<img alt="..." src="/resources/images/item/${img.itemAtImgName }">
					</c:if>
				</c:forEach>	
			</div>
			<div class="col-6 itemDiv">
				<div class="freeMark">무료배송</div>
				<div class="itemNameDiv">${item.itemName}</div>
				<hr>
				<div>
					<table>
					<colgroup>
						<col width="20%">
						<col width="*">
					</colgroup>
						<tr>
							<th>판매가</th>
							<td>${item.itemPrice }</td>
						</tr>
						<tr>
							<th>상품수량</th>
							<td><input type="number"></td>
						</tr>
						<tr>
							<th>배송비</th>
							<td>무료배송</td>
						</tr>
					</table>
				</div>
				<hr>
				<div>총 상품금액 : 10,000원 (n개)</div>
				<div class="button">
					<div class="btn-8">BUY NOW</div>
					<div class="btn-8">ADD TO CART</div>
					<div class="btn-8">WISH LIST</div>
				</div>
			</div>
		</div>
		<div class="row">
			${item.itemDetail }
			<c:forEach items="${item.itemImgList }" var="img">
				<c:if test="${img.isMain eq 'N' }">
					<img alt="..." src="/resources/images/item/${img.itemAtImgName }"><br>
				</c:if>
			</c:forEach>
		</div>
	</div>
</div>

</body>
</html>