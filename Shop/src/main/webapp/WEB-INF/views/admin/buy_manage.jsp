<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.searchTable{
	text-align: center;
}
.searchTable > :not(:first-child) {
  /*   border-top: 2px solid currentColor; */
    border-top: 1px solid #dee2e6;
}
.searchTable .searchTitle{
	background-color: #eeeeee;
}
.buyListTable{
	text-align: center;
}
</style>
</head>
<body>
<div class="row">
	<div class="col">
		<div class="row">
			<div class="col">
				<form action="/admin/buyManage" method="post" id="searchForm">
					<input type="hidden" value="1" id="nowPage" name="nowPage">
					<input type="hidden" name="menuCode" value="${selectedMenu }">
					<input type="hidden" name="subMenuCode" value="${selectedSubMenu }">
					<table class="table align-middle searchTable">
					  <colgroup>
					  	<col width="15%">
					  	<col width="">
					  	<col width="15%">
					  	<col width="*">
					  	<col width="15%">
					  </colgroup>
					  <tbody>
		  				<tr>
					      <td class="searchTitle">주문번호</td>
					      <td><input type="text" class="form-control" name="searchOrderNum" value="${buySearchVO.searchOrderNum }"></td>	
					      <td class="searchTitle">구매자</td>
					      <td><input type="text" class="form-control" name="searchBuyer" value="${buySearchVO.searchBuyer }"></td>
					      <td rowspan="2">
							<button type="submit" class="btn btn-secondary w-100" style="height: 90px;">검 색</button>
					      </td>
					    </tr>
					    <tr>
					      <td class="searchTitle">구매일시</td>
					      <td colspan="3">
					      <div class="row">
					      	<div class="col-5">
					      		<%-- <input type="date" name="searchFromDate" class="form-control" value="${firstDate }"> --%>
					      		<input type="date" name="searchFromDate" class="form-control" value="${buySearchVO.searchFromDate }">
					      	</div>
					      	<div class="col-1 text-center align-self-center">
					      		~
					      	</div>
					      	<div class="col-5">
					      		<%-- <input type="date" name="searchToDate" class="form-control" value="${nowDate }"> --%>
					      		<input type="date" name="searchToDate" class="form-control" value="${buySearchVO.searchToDate }">
					      	</div>
					      </div>
					      </td>	
					    </tr>
					    </tbody>
					</table>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<table class="table table-striped table-hover align-middle buyListTable">
				  <colgroup>
				  	<col width="10%">
				  	<col width="*">
				  	<col width="*">
				  	<col width="*">
				  </colgroup>
				  <thead>
				    <tr>
				      <th scope="col">No</th>
				      <th scope="col">주문번호</th>
				      <th scope="col">구매자</th>
				      <th scope="col">구매일시</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${buyList }" var="buyInfo" varStatus="status">
		  				<tr>       
					      <td>${buySearchVO.totalCnt - buyInfo.rowNum + 1 }</td>
					      <td><span style="cursor: pointer;" onclick="selectBuyListDetail('${buyInfo.orderNum }');">${buyInfo.orderNum }</span></td>	
					      <td>${buyInfo.memId }(${buyInfo.memberVO.memName })</td>
					      <td>${buyInfo.buyDate }</td>
					    </tr>
				  	</c:forEach>
				  </tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<nav aria-label="Page navigation example">
				  <ul class="pagination justify-content-center">
				    <li class="page-item <c:if test="${!buySearchVO.prev }">disabled</c:if>">
				      <a class="page-link" href="/admin/buyManage?nowPage=${buySearchVO.beginPage - 1 }" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				    <c:forEach begin="${buySearchVO.beginPage }" end="${buySearchVO.endPage }" var="pageIndex">
				    	<li class="page-item <c:if test="${buySearchVO.nowPage eq pageIndex }">active</c:if>"><a class="page-link" href="javascript:search(${pageIndex });">${pageIndex }</a></li>
				    </c:forEach>
				    <li class="page-item <c:if test="${!buySearchVO.next }">disabled</c:if>">
				      <a class="page-link" href="/admin/buyManage?nowPage=${buySearchVO.endPage + 1 }" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				  </ul>
				</nav>
			</div>
		</div>
	</div>
</div>






<!-- Modal -->
<div class="modal fade" id="buyInfoModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">구매 내역</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      	
      </div>
    </div>
  </div>
</div>
<script type="text/javascript" src="/resources/js/admin/buy_manage.js?ver=14"></script>
</body>
</html>











