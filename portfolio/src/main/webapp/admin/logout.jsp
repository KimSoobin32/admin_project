<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.removeAttribute("aid");
session.removeAttribute("aname");
session.removeAttribute("apart");
session.removeAttribute("aposition");
//session.invalidate();
%>
<script>
alert("로그아웃 되셨습니다.");
location.href="./index.html";
</script>