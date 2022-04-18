function selectBuyListDetail(orderNum){
	$.ajax({
		url: '/admin/selectBuyListDetail', //요청경로
		type: 'post',
		data: {'orderNum':orderNum}, //필요한 데이터 '데이터이름':값
		success: function(result) {
			//result의 데이터로 모달창 화면을 구성한다.
			//var modalBody = document.getElementById('buyInfoModal').getElementsByClassName('modal-body')[0];
			var modalBody = document.querySelector('#buyInfoModal .modal-body');
			
			var str = '';
			                                                                                                               
			str += '<div class="row">                                                                                      ';
	        str += '    <div class="col text-center">                                                                      ';
	        str += '       <table class="table table-striped table-hover align-middle">                                    ';
	        str += '      <colgroup>                                                                                       ';
	        str += '         <col width="10%">                                                                             ';
	        str += '         <col width="15%">                                                                             ';
	        str += '         <col width="*">                                                                               ';
	        str += '         <col width="10%">                                                                             ';
	        str += '         <col width="15%">                                                                             ';
	        str += '         <col width="15%%">                                                                            ';
	        str += '      </colgroup>                                                                                      ';
	        str += '      <thead>                                                                                          ';
	        str += '        <tr>                                                                                           ';
	        str += '          <th scope="col">No</th>                                                                      ';
	        str += '          <th scope="col">상품이미지</th>                                                              ';
	        str += '          <th scope="col">상품명</th>                                                                  ';
	        str += '          <th scope="col">수량</th>                                                                    ';
	        str += '          <th scope="col">구매가격</th>                                                                ';
	        str += '          <th scope="col">구매자</th>                                                                  ';
	        str += '        </tr>                                                                                          ';
	        str += '      </thead>                                                                                         ';
	        str += '      <tbody>';  

	        for(var i = 0 ; i < result.length ;i++){                                                                                  
		        str += '         <tr>                                                                                          ';
		        str += '          <td>1</td>                                                                                   ';
		        str += '          <td>                                                                                         ';
		        str += '             <img width="50px;" alt="" src="/resources/images/' + result[i].itemVO.imgList[0].attachedImgName + '"> ';   
		        str += '          </td>                                                                                        ';
		        str += '          <td>' + result[i].itemVO.itemName + '</td>';                                                                       
		        str += '          <td>' + result[i].itemCnt + '</td>          ';                                                                       
		        str += '          <td>' + result[i].buyPrice + '</td>           ';                                                              
		        str += '          <td>' + result[i].memId + '(' + result[i].memberVO.memName + ')</td>';                                                                              
		        str += '        </tr> ';   
	        }     
	                                                                                         
	        str += '      </tbody>                                                                                         ';
	        str += '    </table>                                                                                           ';
	        str += '    </div>                                                                                             ';
	        str += ' </div>                                                                                                ';
			
			modalBody.innerHTML = str;
			
			var modalTag = document.getElementById('buyInfoModal');
			var myModal = new bootstrap.Modal(modalTag);
			myModal.show();
			//myModal.hide();
			
		},
		error: function() {
			//ajax 실행 실패 시 실행되는 구간
			alert('실패');
		}
	});
	
}

function search(nowPage){
	document.getElementById('nowPage').value = nowPage;
	
	var formTag = document.getElementById('searchForm');
	formTag.submit();
}

















