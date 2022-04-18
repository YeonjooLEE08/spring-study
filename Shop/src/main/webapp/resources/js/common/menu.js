//joinModal 선택
var joinModal = document.getElementById('joinModal');
var loginModal = document.getElementById('loginModal');

//joinModal이 닫힐 때 자동시작하는 이벤트
joinModal.addEventListener('hidden.bs.modal', function (event) {
	//joinModal안에 있는 모든 input태드 선택
	var tags = document.querySelectorAll('#joinModal input');
	
	//선택된 태그들의 value값을 빈값으로 세팅
	for(var i = 0; i < tags.length ; i++){
		tags[i].value = '';
	}
});

//lginModal이 닫힐 때 자동시작하는 이벤트
loginModal.addEventListener('hidden.bs.modal', function (event) {
	//joinModal안에 있는 모든 input태드 선택
	var tags = document.querySelectorAll('#loginModal input');
	
	//선택된 태그들의 value값을 빈값으로 세팅
	for(var i = 0; i < tags.length ; i++){
		tags[i].value = '';
	}
});

//우편번호 검색 api
function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            document.getElementById("addr").value = roadAddr;
        }
    }).open();
}