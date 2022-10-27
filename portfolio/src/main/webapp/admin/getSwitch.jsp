<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String partNum = request.getParameter("partNum").intern();
	String part = "";
	String positionNum = request.getParameter("positionNum").intern();
	String position = "";
	
	//부서
	switch(partNum){	
	case "1":
		part = "임원";
		break;
	case "2":
		part = "전산팀";
		break;
	case "3":
		part = "디자인팀";
		break;
	case "4":
		part = "CS팀";
		break;
	case "5":
		part = "MD팀";
		break;
	default:
		part = "기타";
		break;
	
	}
	request.setAttribute("part", part);
	
	//직책
	switch(positionNum){	
	case "1":
		position = "대표";
		break;
	case "2":
		position = "부장";
		break;
	case "3":
		position = "팀장";
		break;
	case "4":
		position = "과장";
		break;
	case "5":
		position = "대리";
		break;
	case "6":
		position = "사원";
		break;
	default:
		position = "기타";
		break;
	
	}
	request.setAttribute("position", position);

%>