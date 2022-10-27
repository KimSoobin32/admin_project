function saveConfig() {
	console.log("ff");
	if(f.hpname.value=="" || f.adminemail.value=="" || f.savedmoney.value=="" || f.level.value==""
		|| f.bankname.value=="" || f.bankaccount.value=="" || f.minpaypoint.value=="" || f.maxpaypoint.value==""
		|| f.deliname.value=="" || f.deliprice.value=="" || f.compname.value=="" || f.compnum.value==""
		|| f.represent_name.value=="" || f.represent_tel.value=="" || f.compmailnum.value==""
		|| f.compaddr.value=="" || f.imname.value=="" || f.imemail.value==""){
		alert("모든 항목을 입력하세요.")
	}else{
		f.submit();
	}
	
}

function saveCancel(){
	console.log("dddd");
}

function updateLoginAccept(idx,sign) {
	if(confirm("승인 여부를 변경하시겠습니까?")){
		//location.href='joinok.do?idx='+idx+'&sign='+sign;
		//ajax get로..
		
		$.ajax({
			url:"joinok.do",
			cache:false,
			type:"GET",
			data:{idx:idx,sign:sign},
			dataType:"text",
			success:function($data){
				if($data=="Yes"){
					alert("로그인 승인으로 변경되었습니다");
					
					
				}else if($data=="No"){
					alert("로그인 미승인으로 변경되었습니다");
				}
				
			},
			error:function(){
				console.log("통신 오류 발생");
			}
			
			
		});
		
	}
}

