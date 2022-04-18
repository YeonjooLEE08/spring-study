/*아이디 중복 체크 */
function checkId(){
const memId = document.getElementById('inputId').value;
let str = '';

$.ajax({
		url: '/member/checkId', //요청경로
		type: 'post',
		data: {'memId':memId}, //필요한 데이터 '데이터이름':값
		success: function(result) {
			console.log(typeof result);
			if(result === ""){
				str += '<form action="" method="post">';
				str += '<div class="row mb-3">';
				str += '<label for="inputId" class="col-sm-2 col-form-label">아이디</label>';
				str += '<div class="col-sm-4">';
				str += '<input type="text" class="form-control" id="inputId">';
				str += '</div>';
				str += '<div class="col-sm-2">';
				str += '<button type="button" class="btn btn-secondary" onclick="checkId();">중복확인</button>';
				str += '</div>';
				str += '</div>';
				str += '사용할 수 있는 아이디입니다.';				
			}
			else if(result != "") {
				str += '<form action="" method="post">';
				str += '<div class="row mb-3">';
				str += '<label for="inputId" class="col-sm-2 col-form-label">아이디</label>';
				str += '<div class="col-sm-4">';
				str += '<input type="text" class="form-control" id="inputId">';
				str += '</div>';
				str += '<div class="col-sm-2">';
				str += '<button type="button" class="btn btn-secondary" onclick="checkId();">중복확인</button>';
				str += '</div>';
				str += '</div>';
				str += '이미 사용 중인 아이디입니다.';
			}
			
			document.querySelector('.joinFormDiv').innerHTML = str;
		},
		error: function() {
			
			alert('실패');
		}
	});
}