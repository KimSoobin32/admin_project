$(function(){
    $("#couponStartDate").datepicker();
    $("#couponEndDate").datepicker();
});

function addCoupon(){
	if(f.conm.value==""){
		alert("쿠폰명을 입력하세요.");
	}else if(f.cokind.value==""){
		alert("쿠폰종류를 입력하세요.");
	}else if(f.costartdate.value==""){
		alert("사용 시작일을 입력하세요.");
	}else if(f.coenddate.value==""){
		alert("사용 종료일을 입력하세요.");
	}
	else if(f.coenddate.value<f.costartdate.value){
		alert("시작일이 종료일 이후입니다.");
	}
	
	else if(f.cotype.value==""){
		alert("쿠폰타입을 선택하세요.");
	}else if(f.codc.value==""){
		alert("할인금액 및 할인율을 입력하세요.");
	}
	else if(f.cotype.value=="price" && f.codc.value<1000){
		alert("할인금액은 1000 이상 입력하셔야 합니다.");
	}else if(f.cotype.value=="percent" && f.codc.value>100){
		alert("할인율은 100 이상 입력할 수 없습니다.");
	}

	else if(f.co_minorderprice.value==""){
		alert("최소 주문금액을 입력하세요.");
	}else if(f.co_minorderprice.value<10000){
		alert("최소 주문금액은 10000 이상 부터입니다.");
	}
	else if(f.coimg.value==""){
		alert("쿠폰이미지를 등록하세요.");
	}else{
		console.log("상품등록");
		f.method = "POST";
		f.action = "couponWrite.do";
		f.enctype="multipart/form-data";
		f.submit();
	}
}