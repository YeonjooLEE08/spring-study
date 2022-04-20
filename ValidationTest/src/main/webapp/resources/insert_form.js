//form태그를 선택
$('#insertForm').validate({
	//true: 유효성 검사 성공 시에도 submit이 되지 않음 
	debug: false,
	
	  //유효성 검사 대상 설정
    rules: {
       id: { //input태그의 name 속성으로 검사 대상 지정 
          required: true, //필수입력
          minlength: 2,	//최소
          maxlength: 6	//최대
          
       },
       email:{ 
			required: true,
			email: true		//이메일 형식
    	},
    	pw:{
			required: true,
		},
		pwConfirm:{
			required: true,
			equalTo: '#pw'
		}
    	
   },
    //유효성 검사 실패 시 나타낼 메시지 설정
    messages:{
      	id: { //input태그의 name 속성으로 검사 대상 지정 
           required: '아이디를 입력하시오.',
           minlength: '아이디는 2자 이상 입력해주세요!', 
           maxlength: '아이디는 6자 이하 입력해주세요! '      
       	},
       email: {
		required: '이메일 입력하시오',
		email: '올바르지 않은 형식입니다'
		},
		pw:{
			required: '입력하시오'
		},
		pwConfirm:{
			required: '입력하시오',
			equalTo: '입력하신 패스워드 값과 다릅니다.'
		}
    },
    //유효성 실패 시 추가할 태그(default: label)
    errorElement:'div',
    //유효성 검사 실패 시 메세지 출력 방식
    errorPlacement: function (error, element){
		//element: 유효성 검사 실패한 태그 (input)
		//error: 검사 실패 시 자동 추가 되는 태크 
        error.insertAfter(element);  
     	error.css('color','red');
     	error.css('font-size','12px');
    },  
    //유효성 검사 성공 시 실행 
    submitHandler: function(form) {
       form.submit();   //유효성 검사를 통과시 전송
    }
      
      
});