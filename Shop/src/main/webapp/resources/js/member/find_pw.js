function findPw(){
	//스피너 추가
	var str = '';
	str += '<div class="spinner-border" role="status">';
	str += '<span class="visually-hidden">Loading...</span>';
	str += '</div>';
	
	document.getElementById('spinnerDiv').innerHTML = str;
	
	var memId = document.getElementById('memId').value;
	
	$.ajax({
		url: '/member/findPw', //요청경로
		type: 'post',
		data: {'memId':memId}, //필요한 데이터 '데이터이름':값
		success: function(result) {
			//ajax 실행 성공 후 실행할 코드 작성
			alert('임시비밀번호를 메일로 발송했습니다.');
			document.getElementById('spinnerDiv').innerHTML = '';
		},
		error: function() {
			//ajax 실행 실패 시 실행되는 구간
			alert('실패');
		}
	});
}





