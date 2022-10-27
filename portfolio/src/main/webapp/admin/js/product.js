function dc_cal(){
	
	var price = f.prprice.value;
	var dcpercent = f.prdcpercent.value;
	var dcprice = f.prprice.value - ((price/100)*dcpercent);
	f.prdcprice.value = dcprice.toFixed(0);
	
	
}

function sameCheck(){
	
	if(f.productcode.value==""){
		alert("상품코드를 입력하세요.");
	}else{
		$.ajax({
				url:"sameCheck.do",
				cache:false,
				type:"POST",
				data:{productcode:f.productcode.value},
				dataType:"text",
				success:function($data){	//ok(중복안됨), no(중복됨)
					
					if($data=="no"){
						alert("중복된 상품코드 입니다.");
					}else{
						alert("사용 가능하신 상품코드 입니다.");
						$("#productcode").attr("readonly",true);
						$("#ck").val($data);
					}
				
				},
				error:function(){
					console.log("통신 오류 발생");
				}
				
			});
	}

}


function addProduct(){
	var code = /[0-9]{2,}/;
	var ct = CKEDITOR.instances.contents.getData();
	if(f.b_prcatecode.value==""){
		alert("대메뉴 카테고리코드를 입력하세요.");
	}
	
	else if(code.test(f.b_prcatecode.value)==false){
		alert("대메뉴 카테고리코드는 숫자 2자리 입니다.");
	}
	else if(f.s_prcatecode.value!="" && code.test(f.s_prcatecode.value)==false){
		alert("소메뉴 카테고리코드는 숫자 2자리 입니다.");
	}
	else if(f.productcode.value==""){
		alert("상품코드를 입력하세요.");
	}else if(f.prnm.value==""){
		alert("상품명을 입력하세요.");
	}else if(f.praddex.value==""){
		alert("상품 부가설명을 입력하세요.");
	}else if(f.prprice.value==""){
		alert("판매가격을 입력하세요.");
	}else if(Number(f.prprice.value)<1000){
		alert("판매가격은 최소한 1000원 이상이어야 합니다.");
	}
	
	else if(f.prdcpercent.value==""){
		alert("할인율을 입력하세요.");
	}else if(f.prstock.value==""){
		alert("상품재고를 입력하세요.");
	}else if(f.primg1.value==""){
		alert("상품 대표이미지를 선택하세요.");
	}else if(ct==""){
		alert("상품 상세설명을 입력하세요.");
	}else if(f.ck.value=="" || f.ck.value!="ok"){
		alert("상품코드 중복확인을 완료하세요.");
	}
	else{
		//파일첨부 체크
		var w=1;
		var ct=0;
		while(w<4) {
			var filenm = document.getElementById("primg"+w).value;
			var property = filenm.slice(filenm.indexOf(".")+1).toLowerCase();	//속성명을 소문자로 변환
			
			
			var gopage="yes";
			if(filenm!="") {
				if(property!="jpg" && property!="jpeg" && property!="bmp" && property!="png" && property!="gif" && property!="webp") {
					alert("파일 첨부에는 이미지 파일만 사용하시길 바랍니다.");
					gopage="no";
					document.getElementById("primg"+w).value = "";
					break;
				}else {
					ct++;
				}
			}
			
			
			
			w++;
		}
		
		var z = 1;
		while(z<=ct) {
			
			var ck = document.getElementById("primg"+ct).value;
			if(ck=="") {
				alert("파일 첨부는 순서대로 첨부하시길 바랍니다.");
				gopage="no";
				break;
			}
			z++;
		}
		
		console.log("상품등록");
		if(gopage=="yes") {
			f.method = "POST";
			f.action = "productWrite.do";
			f.enctype="multipart/form-data";
			f.submit();
		}
		
	}
}


function checkAll(ea){
	
	var isck = document.getElementById("allcheck").checked;
	
      if (isck == true) {
         for (var i = 0; i < ea; i++)
            document.getElementsByName("ck")[i].checked = true;
      } else {
         for (var i = 0; i < ea; i++)
            document.getElementsByName("ck")[i].checked = false;
      }
}

function pagemove(page,pn,op){
	console.log(page);
	
	let search = location.search;
	let query = "";
	
	var nowpage = Number(location.search.replace("?page=",""));
	if(nowpage=="") {
		nowpage=1;
	}
	var next = nowpage + 1;
	var prev = nowpage - 1;
		
	if(op == 2){	//이전			
		if(prev<=0){       	
			prev = 1;
		}
		if(search.indexOf("sel")>-1) {
			const target = document.getElementById('pre');
			target.disabled = true;	//검색 시 이전,다음버튼 일단 비활성화
		}else {
			location.href="./product_list.do?page="+prev;
		}
	}else if(op==3){	//다음
		if(next>pn){
			next=pn;
		}
		if(search.indexOf("sel")>-1) {
			const target = document.getElementById('nxt');
			target.disabled = true;	//검색 시 이전,다음버튼 일단 비활성화
		}else {
			location.href="./product_list.do?page="+next;
		}
	}else{	//페이지 번호버튼, 최상,최하
		//location.href="./product_list.do?page="+page;
		if(search.indexOf("sel")>-1) {
			location.href="./product_list.do?page="+page+(search.replace(/\b(page=).+?\b/g,"").replace("?&sel=",'&sel=').replace("?sel=",'&sel='));
		}else {
			location.href="./product_list.do?page="+page;
		}
	}
}

function searchSubmit(){
	console.log(frm.search.value);
	if(frm.searchinput.value==""){	//왜 안될까..
		alert("검색어를 입력하세요.");
		return false;
	}else{
		frm.method="GET";
		frm.action="product_list.do";
		frm.enctype="application/x-www-form-urlencoded";
		frm.submit();
	}
}

function deleteProduct(ea){
	
	var count = 0;
	if(ea==1){
		if(fr.ck.checked==false){
		 alert("삭제할 상품을 체크해 주세요.");
		}
	}else{
		for (var ii = 0; ii < ea; ii++) {
         if (fr.ck[ii].checked == true) {
            count++;
         }
      }
      if (count < 1) {
         alert("삭제할 상품을 체크해 주세요.");
      } else {
		
		fr.method="POST";
		fr.action="productDelete.do";
         fr.submit();
      }
	}
	
	
      
}