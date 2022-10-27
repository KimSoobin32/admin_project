var idPattern = /[a-z|A-Z|0-9\\d_-]/g;
var emailPattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

function cancel() {
	location.href="./index.html";
}

$(function() {
	$("#searchId").click(function() {	//아이디 중복체크

		var $id = $("#aid");
		
		if($id.val()==""){
			alert("아이디를 입력하세요.");
			$id.focus();
		}else if($id.val().length!=$id.val().match(idPattern).length){
			alert("올바른 아이디가 아닙니다. 특수문자는 -, _만 사용이 가능합니다.");
		}else{
			//확장함수로 값을 넘김(ajax 실행)
			$.fn.idcheck($id.val());
		}
	});
	
	$.fn.idcheck = function($id) {	//backend로 userid 전달
		$.ajax({
			url:"loginck.do",
			cache:false,
			type:"POST",
			data:{userid:$id},
			dataType:"text",
			success:function($data){	//ok(중복안됨), no(중복됨)
				
				if($data=="no"){
					alert("중복된 아이디 입니다.");
				}else{
					alert("사용 가능하신 아이디 입니다.");
					$("#aid").attr("readonly",true);
					$("#ck").val($data);
				}
			
			},
			error:function(){
				console.log("통신 오류 발생");
			}
			
		});
	}
});



function signUp() {
	var $aid = $("#aid");
	var $apw = $("#apw");
	var $apw_confirm = $("#apw_confirm");
	var $aname = $("#aname");
	var $aemail = $("#aemail");
	var $atel1 = $("#atel1");
	var $atel2 = $("#atel2");
	var $atel3 = $("#atel3");
	var $apart = $("#apart");
	var $aposition = $("#aposition");
	var $ck = $("#ck");
	
	
	if($aid.val()==""){
		alert("아이디를 입력하세요.");
		$aid.focus();
	}else if($aid.val()=="admin" || $aid.val()=="master"){
		alert("사용 불가한 아이디입니다.");
		$aid.focus();
	}else if($aid.val().length!=$aid.val().match(idPattern).length){
		alert("올바른 아이디가 아닙니다. 특수문자는 -, _만 사용이 가능합니다.");
	}
	
	else if($apw.val()==""){
		alert("패스워드를 입력하세요.");			
		$apw.focus();
	}
	
	else if($apw.val().length<4 || $apw.val().length>16){
		alert("패스워드는 4~16자입니다.");
		$apw.focus();
	}else if($apw_confirm.val()=="" || $apw_confirm.val()!=$apw.val()){
		alert("동일한 패스워드를 입력하세요.");
		$apw_confirm.focus();
	}else if($aname.val()==""){
		alert("이름을 입력하세요.");
		$aname.focus();
	}else if($aemail.val()==""){
		alert("이메일을 입력하세요.");
		$aemail.focus();
	}else if(emailPattern.test($aemail.val())==false){
		alert("이메일 형식이 올바르지 않습니다.");
		$aemail.focus();
	}		
	else if($atel1.val()=="" || $atel1.val().length<3){
		alert("올바른 전화번호를 입력하세요.");
		$atel1.focus();
	}else if($atel2.val()=="" || $atel2.val().length<4){
		alert("올바른 전화번호를 입력하세요.");
		$atel2.focus();
	}else if($atel3.val()=="" || $atel3.val().length<4){
		alert("올바른 전화번호를 입력하세요.");
		$atel3.focus();
	}else if($apart.val()==""){
		alert("부서를 선택하세요.");
		$apart.focus();
	}else if($aposition.val()==""){
		alert("직책을 선택하세요.");
		$aposition.focus();
	}else if($ck.val()=="" || $ck.val()!="ok"){
		alert("아이디 중복체크를 완료하세요.");

	}else{
		//console.log("회원가입진행");
		frm.submit();
	}
}

function memberUpdate() {
	
	var $apw = $("#apw");
	var $apw_confirm = $("#apw_confirm");
	var $aname = $("#aname");
	var $aemail = $("#aemail");
	var $atel1 = $("#atel1");
	var $atel2 = $("#atel2");
	var $atel3 = $("#atel3");
	var $apart = $("#apart");
	var $aposition = $("#aposition");
	var $ck = $("#ck");
	
	
	if($apw.val()==""){
		alert("패스워드를 입력하세요.");			
		$apw.focus();
	}
	
	else if($apw.val().length<4 || $apw.val().length>16){
		alert("패스워드는 4~16자입니다.");
		$apw.focus();
	}else if($apw_confirm.val()=="" || $apw_confirm.val()!=$apw.val()){
		alert("동일한 패스워드를 입력하세요.");
		$apw_confirm.focus();
	}else if($aname.val()==""){
		alert("이름을 입력하세요.");
		$aname.focus();
	}else if($aemail.val()==""){
		alert("이메일을 입력하세요.");
		$aemail.focus();
	}else if(emailPattern.test($aemail.val())==false){
		alert("이메일 형식이 올바르지 않습니다.");
		$aemail.focus();
	}		
	else if($atel1.val()=="" || $atel1.val().length<3){
		alert("올바른 전화번호를 입력하세요.");
		$atel1.focus();
	}else if($atel2.val()=="" || $atel2.val().length<4){
		alert("올바른 전화번호를 입력하세요.");
		$atel2.focus();
	}else if($atel3.val()=="" || $atel3.val().length<4){
		alert("올바른 전화번호를 입력하세요.");
		$atel3.focus();
	}else if($apart.val()==""){
		alert("부서를 선택하세요.");
		$apart.focus();
	}else if($aposition.val()==""){
		alert("직책을 선택하세요.");
		$aposition.focus();
	}else{
		//console.log("정보수정");
		
		f.method="POST";
		f.action="memberUpdate.do";
		f.enctype="application/x-www-form-urlencoded";
		f.submit();
		
	}
}

