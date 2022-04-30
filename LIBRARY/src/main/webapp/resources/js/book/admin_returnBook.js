function showModal(selectedTag){
	
	var isbn = $(selectedTag).closest('tr').children().eq(3).text();
	var memId = $(selectedTag).closest('tr').children().eq(1).text();
	var brCode = $(selectedTag).closest('tr').children().eq(0).text();
	
	$('#returnBook #originIsbn' ).val(isbn);
	$('#returnBook #originBrCode' ).val(brCode);
	$('#returnBook #originMemId' ).val(memId);
	
	$('#returnBook').modal('show');
	
}

function returnBook(){
	var originIsbn = $('#returnBook #originIsbn').val();
	var originBrCode = $('#returnBook #originBrCode').val();
	var originMemId = $('#returnBook #originMemId').val();
	
	location.href = '/book/returnBook?isbn='+originIsbn+'&brCode='+originBrCode+'&memId='+originMemId;
	alert('반납되었습니다.');
	
}

/*!!!!!!!!!!!!!!!!!! 연체 도서 반납 !!!!!!!!!!!!!!!!!!*/
function showModalOD(selectedTag){
	
	
	var brCode = $(selectedTag).closest('tr').children().eq(0).text();
	var memId = $(selectedTag).closest('tr').children().eq(1).text();
	var isbn = $(selectedTag).closest('tr').children().eq(3).text();
	var rtDate = $(selectedTag).closest('tr').children().eq(5).text();
	
	var now = new Date();
	var rtDateT =new Date(rtDate);
	alert(now);
	alert(rtDateT);
	
	//var rtDate_arr = rtDate.split("-");
	
	/*var year = now.getFullYear();
	var month = now.getMonth();
	var day = now.getDate();
	
	var stDate = new Date(rtDate_arr[0], rtDate_arr[1], rtDate_arr[2]);
	alert(stDate);
	var endDate = new Date(year, month, day);*/
	
//	alert(endDate);
	var limitMs = now.getTime() - rtDateT.getDate();
	alert(limitMs);
	var limitDate = Math.floor(limitMs/(1000*60*60*24));
	
	alert(limitDate);
	

	
	$('#returnOverdue #originBrCode' ).val(brCode);
	$('#returnOverdue #originMemId' ).val(memId);
	$('#returnOverdue #originIsbn' ).val(isbn);
	$('#returnOverdue #originRtDate' ).val(rtDate);
	
	
	$('#returnOverdue').modal('show');
	
}	

$('#closeModalBtn').on('click', function(){
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