//------------ 수량 변경 시 이벤트 진행 코드------------//
//수량 input 태그
var ea = document.getElementById('ea');

//수량 input태그의 값이 변경 될때마다 실행되는 이벤트.
ea.addEventListener('change', setTotalPrice);
ea.addEventListener('keyup', setTotalPrice);

function setTotalPrice(){
	if(ea.value > 10){
		ea.value = 10;
	}
	
	//개당 가격 정보
	var price = document.getElementById('priceSpan').dataset.price;
	//수량
	var cnt = ea.value;
	
	var totalPrice = (price * cnt).toLocaleString();
	document.getElementById('totalPriceSpan').innerHTML ='￦' + totalPrice;
}

//------------ 장바구니 코드------------//
function insertCart(){
	var formTag = document.getElementById('itemForm');
	formTag.action = '/cart/insertCart';
	formTag.submit();
}
















