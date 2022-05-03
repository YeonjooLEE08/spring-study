
//제출 버튼$. 클릭 시 실행
$(document).ready(function (){
	$('#search').click(function (){
		
		var searchTxt = $('#bookName').val();
		alert(searchTxt);
		$.ajax({
			method: 'GET',
			url: "https://dapi.kakao.com/v3/search/book?target=title",
			data: { query: searchTxt },
			headers: {Authorization: "KakaoAK 9ac7c779abb75c8cf021af960faffa9e"},
		})
		
			.done(function(bk){
				var i;
				for(i=0;i<10;i++){

					console.log(bk.documents[i]);
					var authors =bk.documents[i].authors.join();
					$('#coverimg').append("<strong>"+bk.documents[i].title+"</strong>");
					$('#title').append("<img src='"+bk.documents[i].thumbnail+"'/>");
					$('#writer').append(authors);
					$('#publisher').append(bk.documents[i].publisher);
				}
				
			});
				
			});

});

/*let str = '<div class="result-row-thead"><div>이미지</div><div>책 제목</div><div>작가</div></div>';

			if(result != ""){
				for(let i = 0 ; i < result.length ; i++){
					str += '<div class="result-row-tbody" onclick="resultChoice(this)" ><div><img  src="' + result[i].bkImg + '"></div>';
					str += '<div>' + result[i].title + '</div>';
					str += '<div>' + result[i].writer + '</div></div>';
				}
			}
		
			else{
				str += '<div class="result-row-tbody">해당 검색어에 조회되는 도서가 없습니다.</div>';
			}	*/