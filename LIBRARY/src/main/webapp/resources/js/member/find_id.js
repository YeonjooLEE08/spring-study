function findId(){
	const memName = document.querySelector('input[name="memName"]').value;
	const memEmail = document.querySelector('input[name="memEmail"]').value;
	const showIdDiv = document.querySelector('div.showIdDiv').innerText;

$.ajax({
   url: '/member/findId', //요청경로
    type: 'post',
    data:{'memName':memName, 'memEmail':memEmail}, //필요한 데이터 '데이터이름':값
    success: function(result) {
      //ajax 실행 성공 후 실행할 코드 작성
      alert(result);
      
    },
    error: function(){
      //ajax 실행 실패 시 실행되는 구간
       alert('실패');
    }
});



}