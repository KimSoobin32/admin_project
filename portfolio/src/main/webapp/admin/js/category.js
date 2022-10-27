function plus(){
	var categorycode = f.b_catecode.value + f.s_catecode.value;
	f.categorycode.value = categorycode;
}



function createCategory(){

	var code = /[0-9]{2,}/;
	if(f.categorycode.value==""){
		alert("분류코드를 입력하세요.");
	}else if(f.b_catecode.value==""){
		alert("대메뉴 코드 입력하세요.");
	}else if(code.test(f.b_catecode.value)==false){
		alert("대메뉴 코드는 숫자 2자리 입니다.");
	}	
	else if(f.b_catenm.value==""){
		alert("대메뉴명을 입력하세요.");
	}else if(f.onlyb.checked == false){
		if(f.s_catecode.value==""){
			alert("소메뉴 코드를 입력하세요.");
		}else if(code.test(f.s_catecode.value)==false){
			alert("소메뉴 코드는 숫자 2자리 입니다.");
		}		
		else if(f.s_catenm.value==""){
			alert("소메뉴명을 입력하세요.");
		}else{
			
			f.action="categoryWrite.do";
			f.submit();
		}
	}
	else{
		
		
	
		f.s_catecode.value=="";
		f.s_catenm.value=="";
		f.action="categoryWrite.do";
		f.submit();
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

function deleteCategory(ea){

	var count = 0;
	
	if(ea==1){
		if(f.ck.checked==false){
		 alert("삭제할 카테고리를 체크해 주세요.");
		}
	}else{
		for (var ii = 0; ii < ea; ii++) {
         if (f.ck[ii].checked == true) {
            count++;
         }
      }
      if (count < 1) {
		//console.log(ea);
         alert("삭제할 카테고리를 체크해 주세요.");
      } else {
		
		f.method="POST";
		f.action="categoryDelete.do";
        f.submit();
        
      }
	}
	
	
}

function onlyBcheck() {
	if(f.onlyb.checked == true) {
		f.s_catecode.value="";		
		f.s_catenm.value="";	
		f.categorycode.value = f.b_catecode.value;
		f.s_catecode.readOnly = true;
		f.s_catenm.readOnly = true;
		
	}else {
		f.s_catecode.readOnly = false;
		f.s_catenm.readOnly = false;
	}
}


function pagemove(page,pn,op){
	
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
			location.href="./category_list.do?page="+prev;
		}
		
	}else if(op==3){	//다음
		if(next>pn){
			next=pn;
		}
		if(search.indexOf("sel")>-1) {
			const target = document.getElementById('nxt');
			target.disabled = true;
		}else {
			
			location.href="./category_list.do?page="+next;
		}
		
		
	}else{	//페이지 번호버튼, 최상,최하
		
		//location.href="./category_list.do?page="+page;
		if(search.indexOf("sel")>-1) {
			location.href="./category_list.do?page="+page+(search.replace(/\b(page=).+?\b/g,"").replace("?&sel=",'&sel=').replace("?sel=",'&sel='));
		}else {
			location.href="./category_list.do?page="+page;
		}
	}
}

function searchSubmit(){
	console.log(frm.search.value);
	if(frm.search.value==""){	
		alert("검색어를 입력하세요.");
		return false;
	}else{
		frm.method="GET";
		frm.action="category_list.do";
		frm.enctype="application/x-www-form-urlencoded";
		frm.submit();
	}
}