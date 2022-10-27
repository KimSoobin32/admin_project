
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

function deleteNotice(ea){

	var count = 0;
	console.log(count);
	if(ea==1){
		if(fr.ck.checked==false){
		 alert("삭제할 상품을 체크해 주세요.");
		}
	}else{
		for (var ii = 0; ii < ea; ii++) {
         if (f.ck[ii].checked == true) {
            count++;
         }
      }
      if (count < 1) {
		
         alert("삭제할 공지내용을 체크해 주세요.");
      } else {
		f.method="POST";
		f.action="noticeDelete.do";
        f.submit();
      }
	}
	
	
}



function pagemove($page,$pn,$op){
		

		var $nowpage = Number(location.search.replace("?page=",""));
		var $next = $nowpage + 1;
		var $prev = $nowpage - 1;
		
		

		if($op == 2){	//이전			
			if($prev<=0){       	
    			$prev = 1;
    		}
			location.href="./notice_list.do?page="+$prev;
			
		}else if($op==3){	//다음
			if($next>$pn){
    			$next=$pn;
    		}
			location.href="./notice_list.do?page="+$next;
			
		}else{	//페이지 번호버튼, 최상,최하
			location.href="./notice_list.do?page="+$page;
		}
		
		
		
		
}

function writeNoteice(){
		var $ntitle = $("#ntitle").val();
		var $nwriter = $("#nwriter").val();
		
		var $ct = CKEDITOR.instances.ncontent.getData();
		
		if($ntitle==""){
			alert("공지사항 제목을 입력하세요.");
		}else if($ct==""){
			alert("공지내용을 입력하세요.");
		}else{
			
			f.method="POST";
			f.action="noticeWrite.do";
			f.enctype="multipart/form-data";
			f.submit();
			
		}
}


//function go2(np){
//	
//	updateNoteice(np);
//}


