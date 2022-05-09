/*!!!!!!!!!!!!!!!!!! 연체 도서 반납 !!!!!!!!!!!!!!!!!!*/
function showModalOD(selectedTag){
	
	
	var brCode = $(selectedTag).closest('tr').children().eq(0).text();
	var memId = $(selectedTag).closest('tr').children().eq(1).text();
	var isbn = $(selectedTag).closest('tr').children().eq(3).text();
	var rtDate = $(selectedTag).closest('tr').children().eq(5).text();
	var originLimitDate = $('#limitDate').text();
	
	//기존 연체제한 없으면
	if(originLimitDate==''){
		var nowDate = new Date();
		var rtDateT =new Date(rtDate);
		var originLDate = new Date(originLimitDate);
	
		var limitDay = Math.floor((nowDate.getTime() - rtDateT.getTime())/(1000*60*60*24));
		
		var limit = new Date(nowDate);
		limit.setDate(nowDate.getDate()+limitDay);
		
		var limitYear = limit.getFullYear();
		var limitMonth = ('0'+(limit.getMonth()+1)).slice(-2);
		var limitDate = ('0'+limit.getDate()).slice(-2);
		
		var limitDate = limitYear +'-'+ limitMonth +'-'+ limitDate;
		
	
			
		alert('연체일은 총 '+limitDay+'일입니다.\n 대출가능일은 '+limitDate+'입니다.');
		
		$('#returnOverdue #originBrCode' ).val(brCode);
		$('#returnOverdue #originMemId' ).val(memId);
		$('#returnOverdue #originIsbn' ).val(isbn);
		$('#returnOverdue #originLimitDate').val(limitDate);
	}else{
		var nowDate = new Date();
		var rtDateT =new Date(rtDate);
		var originLDate = new Date(originLimitDate);
	
		var limitDay = Math.floor((nowDate.getTime() - rtDateT.getTime())/(1000*60*60*24));
		
		var limit = new Date(nowDate);
		limit.setDate(nowDate.getDate()+limitDay);
		
		var limitYear = limit.getFullYear();
		var limitMonth = ('0'+(limit.getMonth()+1)).slice(-2);
		var limitDate = ('0'+limit.getDate()).slice(-2);
		
		var limitDate = limitYear +'-'+ limitMonth +'-'+ limitDate;
		
	
			
		alert('연체일은 총 '+limitDay+'일입니다.\n 대출가능일은 '+limitDate+'입니다.');
		
		if(originLDate.getTime()>limitDay.getTime()){
			alert('연체일은 총 '+limitDay+'일입니다.\n기존 연체이력으로 인해 대출가능일은 '+originLimitDate+'입니다.');
			$('#returnOverdue #originBrCode' ).val(brCode);
			$('#returnOverdue #originMemId' ).val(memId);
			$('#returnOverdue #originIsbn' ).val(isbn);
			$('#returnOverdue #originLimitDate').val(originLimitDate);
		}
		
	}
	

	
	$('#returnOverdue #originBrCode' ).val(brCode);
	$('#returnOverdue #originMemId' ).val(memId);
	$('#returnOverdue #originIsbn' ).val(isbn);
	$('#returnOverdue #originLimitDate').val(limitDate);
	
	$('#returnOverdue').modal('show');
	
}	

function returnOverdue(){
	var isbn = $('#returnOverdue #originIsbn').val();
	var brCode = $('#returnOverdue #originBrCode').val();
	var memId = $('#returnOverdue #originMemId').val();
	
	var limitDate = $('#returnOverdue #originLimitDate').val();

/*
	var formTag = document.getElementById('rtOverdue');
	formTag.submit();*/

	
	
	
	location.href = '/book/returnOverdue?isbn='+isbn+'&brCode='+brCode+'&memId='+memId+'&limitDate='+limitDate;
	
}
$('#closeModalBtnOD').on('click', function(){
$('#returnOverdue').modal('hide');
console.log("click close");
});
$('#returnOverdue').on('show.bs.modal', function (e) {
console.log("show.bs.modal");
});
$('#returnOverdue').on('shown.bs.modal', function (e) {
console.log("shown.bs.modal");
});
$('#returnOverdue').on('hide.bs.modal', function (e) {
console.log("hide.bs.modal");
});
$('#returnOverdue').on('hidden.bs.modal', function (e) {
console.log("hidden.bs.modal");
});




	


/*var rsvCode="";
var mem*/