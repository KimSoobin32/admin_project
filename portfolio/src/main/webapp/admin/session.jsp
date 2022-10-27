<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page session="true"%>
<%

String aname = null;
String aid = null;
String aemail = null;
String atel = null;
String apart = null;
String aposition = null;

//session.setMaxInactiveInterval(15*60);
session.setMaxInactiveInterval(60*60);

aname = (String)session.getAttribute("aname");
aid = (String)session.getAttribute("aid");
aemail = (String)session.getAttribute("aemail");
atel = (String)session.getAttribute("atel");
apart = (String)session.getAttribute("apart");
aposition = (String)session.getAttribute("aposition");

if(aname==null){
	out.print("<script>alert('시간 경과로 자동 로그아웃됩니다.'); location.href='./index.html';</script>");
}


%>