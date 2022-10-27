<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>

<%
String ck =(String)jpal.get(2);

%>
<meta charset="UTF-8">
<p>홈페이지 가입환경 설정</p>

<div class="subpage_view">
<ul class="info_form">
    <li>홈페이지 제목</li>
    <li>
        <input type="text" class="in_form1" name="hpname" value="<%=jpal.get(0)%>">
    </li>
</ul>    
<ul class="info_form">
    <li>관리자 메일 주소</li>
    <li>
        <input type="text" class="in_form2" name="adminemail" value="<%=jpal.get(1)%>"> ※ 관리자가 보내고 받는 용도로 사용하는 메일 주소를 입력합니다.(회원가입,인증메일,회원메일발송 등에서 사용)
    </li>
</ul> 
<ul class="info_form">
    <li>포인트 사용 유/무</li>
    <li class="checkcss">
        <em><label><input type="radio" class="ckclass" name="usepoint" value="Y" <%if(jpal.get(2).equals("Y"))out.print("checked");%>>포인트 사용</label></em> 
        <em><label><input type="radio" class="ckclass"  name="usepoint" value="N" <%if(jpal.get(2).equals("N"))out.print("checked");%>>포인트 미사용</label></em>
    </li>
</ul>
<ul class="info_form2" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>회원가입시 적립금</li>
    <li>
        <input type="text" class="in_form3" maxlength="5" name="savedmoney" value="<%=jpal.get(3)%>"> 점
    </li>
    <li>회원가입시 권한레벨</li>
    <li>
        <input type="text" class="in_form3" maxlength="1" name="level" value="<%=jpal.get(4)%>"> 레벨
    </li>
</ul> 
</div>
<p>홈페이지 기본환경 설정</p>
<div class="subpage_view">
<ul class="info_form2">
    <li>회사명</li>
    <li>
        <input type="text" class="in_form0" name="compname" value="<%=jpal.get(16)%>"> 
    </li>
    <li>사업자등록번호</li>
    <li>
        <input type="text" class="in_form0" name="compnum" value="<%=jpal.get(17)%>"> 
    </li>
</ul> 
<ul class="info_form2">
    <li>대표자명</li>
    <li>
        <input type="text" class="in_form0" name="represent_name" value="<%=jpal.get(18)%>"> 
    </li>
    <li>대표전화번호</li>
    <li>
        <input type="text" class="in_form0" name="represent_tel" value="<%=jpal.get(19)%>"> 
    </li>
</ul>
<ul class="info_form2">
    <li>통신판매업 신고번호</li>
    <li>
        <input type="text" class="in_form0" name="telenum" value="<%=jpal.get(20)%>"> 
    </li>
    <li>부가통신 사업자번호</li>
    <li>
        <input type="text" class="in_form0" name="additionalnum" value="<%=jpal.get(21)%>"> 
    </li>
</ul>
<ul class="info_form2">
    <li>사업장 우편번호</li>
    <li>
        <input type="text" class="in_form0" name="compmailnum" value="<%=jpal.get(22)%>"> 
    </li>
    <li>사업장 주소</li>
    <li>
        <input type="text" class="in_form2" name="compaddr" value="<%=jpal.get(23)%>"> 
    </li>
</ul>
<ul class="info_form2" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>정보관리책임자명</li>
    <li>
        <input type="text" class="in_form0" name="imname" value="<%=jpal.get(24)%>"> 
    </li>
    <li>정보책임자 E-mail</li>
    <li>
        <input type="text" class="in_form1" name="imemail" value="<%=jpal.get(25)%>"> 
    </li>
</ul>
</div>
<p>결제 기본환경 설정</p>
<div class="subpage_view">  
<ul class="info_form2">
    <li>무통장 은행</li>
    <li>
        <input type="text" class="in_form0" name="bankname" value="<%=jpal.get(5)%>"> 
    </li>
    <li>은행계좌번호</li>
    <li>
        <input type="text" class="in_form1" name="bankaccount" value="<%=jpal.get(6)%>"> 
    </li>
</ul>
<ul class="info_form">
    <li>신용카드 결제 사용</li>
    <li class="checkcss">
        <em><label><input type="radio" class="ckclass" name="usecard" value="Y" <%if(jpal.get(7).equals("Y"))out.print("checked");%>> 사용</label></em> 
        <em><label><input type="radio" class="ckclass" name="usecard" value="N" <%if(jpal.get(7).equals("N"))out.print("checked");%>> 미사용</label></em> ※ 해당 PG사가 있을 경우 사용으로 변경합니다.
    </li>
</ul>
<ul class="info_form">
    <li>휴대폰 결제 사용</li>
    <li class="checkcss">
        <em><label><input type="radio" class="ckclass" name="usetelpay" value="Y" <%if(jpal.get(8).equals("Y"))out.print("checked");%>> 사용</label></em> 
        <em><label><input type="radio" class="ckclass" name="usetelpay" value="N" <%if(jpal.get(8).equals("N"))out.print("checked");%>> 미사용</label></em> ※ 주문시 휴대폰 결제를 가능하게 할 것인지를 설정합니다.
    </li>
</ul>
<ul class="info_form">
    <li>도서상품권 결제사용</li>
    <li class="checkcss">
        <em><label><input type="radio" class="ckclass" name="usevoucher" value="Y" <%if(jpal.get(9).equals("Y"))out.print("checked");%>> 사용</label></em> 
        <em><label><input type="radio" class="ckclass" name="usevoucher" value="N" <%if(jpal.get(9).equals("N"))out.print("checked");%>> 미사용</label></em> ※ 도서상품권 결제만 적용이 되며, 그 외에 상품권은 결제 되지 않습니다.
    </li>
</ul>
<ul class="info_form2">
    <li>결제 최소 포인트</li>
    <li>
        <input type="text" class="in_form0" maxlength="5" name="minpaypoint" value="<%=jpal.get(10)%>"> 점
    </li>
    <li>결제 최대 포인트</li>
    <li>
        <input type="text" class="in_form0" maxlength="5" name="maxpaypoint" value="<%=jpal.get(11)%>"> 점
    </li>
</ul>
<ul class="info_form">
    <li>현금 영수증 발급사용</li>
    <li class="checkcss">
        <em><label><input type="radio" class="ckclass" name="usereceipt" value="Y" <%if(jpal.get(12).equals("Y"))out.print("checked");%>> 사용</label></em> 
        <em><label><input type="radio" class="ckclass" name="usereceipt" value="N" <%if(jpal.get(12).equals("N"))out.print("checked");%>> 미사용</label></em> ※ 현금영수증 관련 사항은 PG사 가입이 되었을 경우 사용가능 합니다.
    </li>
</ul>
<ul class="info_form2">
    <li>배송업체명</li>
    <li>
        <input type="text" class="in_form0" name="deliname" value="<%=jpal.get(13)%>"> 
    </li>
    <li>배송비 가격</li>
    <li>
        <input type="text" class="in_form0" maxlength="7" name="deliprice" value="<%=jpal.get(14)%>"> 원
    </li>
</ul>
<ul class="info_form" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>희망배송일</li>
    <li class="checkcss">
        <em><label><input type="radio" class="ckclass" name="usedesiredate" value="Y" <%if(jpal.get(15).equals("Y"))out.print("checked");%>> 사용</label></em> 
        <em><label><input type="radio" class="ckclass" name="usedesiredate" value="N" <%if(jpal.get(15).equals("N"))out.print("checked");%>> 미사용</label></em> ※ 희망배송일 사용시 사용자가 직접 설정 할 수 있습니다.
    </li>
</ul>
</div>
<div class="btn_div">
    <button type="button" class="sub_btn1" title="설정 저장" onclick="saveConfig()">설정 저장</button>
    <button type="button" class="sub_btn2" title="저장 취소" onclick="saveCancel()">저장 취소</button>
</div>