//도서 등록 버튼 클릭 시 실행
function regBook(){
	var selectBox = document.getElementById("categorySeletor").value;
	
	//카테고리 미 선택 시 alert
	if(selectBox == 1){
		alert('카테고리를 선택해주세요!');
		return ;
	}
	
	//도서명 미기입 시 alert
	var bookName = document.getElementById('bookName').value;
	if(bookName == ''){
		alert('도서명은 필수입력입니다.');
		return ;
	}	
	
	//submit
	var formTag = document.getElementById('regBookForm');
	formTag.submit();
}

//도서 수정
function updateBook(){
	
	//모달창고려중

	alert('수정되었습니다.')

	//submit
	var formTag = document.getElementById('updateBookForm');
	formTag.submit();
}

//도서 삭제
function deleteBook(){
	
	
}