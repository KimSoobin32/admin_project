<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page session="true" %>
<%@include file="./session.jsp" %>

<%
	if(aname==null || aname==""){
		out.print("<script>alert('로그인 하셔야만 접근 가능합니다.'); location.href='./index.html';</script>");
	}

%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 정보 수정</title>
    <link rel="stylesheet" type="text/css" href="./css/basic.css">
    <link rel="stylesheet" type="text/css" href="./css/login.css?v=1">
    <link rel="stylesheet" type="text/css" href="./css/main.css">
    <link rel="icon" href="./img/logo.png" sizes="128x128">
    <link rel="icon" href="./img/logo.png" sizes="64x64">
    <link rel="icon" href="./img/logo.png" sizes="32x32">
    <link rel="icon" href="./img/logo.png" sizes="16x16">
    <script src="./js/jquery.js"></script>
    <script src="./js/member.js"></script>
</head>
<body>
<header class="headercss">
	<%@include file="./admin_header.html" %><!--admin_header.html-->
</header>
<nav class="navcss">
	<%@include file="./admin_menu.html" %><!--admin_menu.html-->
</nav>
<form name="f" id="f">
<main class="maincss">
<section style="width:100%; height: 480px; background-color: rgb(31, 31, 31); margin-bottom: 20px;">
	<%@include file="./info_view.html" %><!--info_view.html-->
</section>
</main>
</form>
<footer class="main_copyright">
    <%@include file="./admin_footer.html" %><!--admin_footer.html-->
</footer>
</body>
</html>