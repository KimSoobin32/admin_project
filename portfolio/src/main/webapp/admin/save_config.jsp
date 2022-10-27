<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./db.jsp" %>
<%
	response.setContentType("text/html; charset=utf-8");
	
	ArrayList<String> jpList = new ArrayList<>();
	jpList.add(request.getParameter("hpname"));
	jpList.add(request.getParameter("adminemail"));
	jpList.add(request.getParameter("usepoint"));
	jpList.add(request.getParameter("savedmoney"));
	jpList.add(request.getParameter("level"));
	jpList.add(request.getParameter("bankname"));
	jpList.add(request.getParameter("bankaccount"));
	jpList.add(request.getParameter("usecard"));
	jpList.add(request.getParameter("usetelpay"));
	jpList.add(request.getParameter("usevoucher"));
	jpList.add(request.getParameter("minpaypoint"));
	jpList.add(request.getParameter("maxpaypoint"));
	jpList.add(request.getParameter("usereceipt"));
	jpList.add(request.getParameter("deliname"));
	jpList.add(request.getParameter("deliprice"));
	jpList.add(request.getParameter("usedesiredate"));
	
	
	//ArrayList<String> cList = new ArrayList<>();
	jpList.add(request.getParameter("compname"));
	jpList.add(request.getParameter("compnum"));
	jpList.add(request.getParameter("represent_name"));
	jpList.add(request.getParameter("represent_tel"));
	jpList.add(request.getParameter("telenum"));
	jpList.add(request.getParameter("additionalnum"));
	jpList.add(request.getParameter("compmailnum"));
	jpList.add(request.getParameter("compaddr"));
	jpList.add(request.getParameter("imname"));
	jpList.add(request.getParameter("imemail"));	
	
	String jpSql = "insert into config_table values('0',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	PreparedStatement jpps = null;
	
	PreparedStatement jpcps = null;
	
	
	try{
		
		jpps = con.prepareStatement(jpSql);
		
		
		int w=1;
		while(w<=jpList.size()){
			jpps.setString(w, jpList.get(w-1));
			w++;
		}
		
		int n = 0;
		n = jpps.executeUpdate();
		
		
		//out.print("<script>alert('환경설정 정보 저장 완료'"+cps+");</script>");
		
		
		if(n>0){
			out.print("<script>alert('환경설정 정보 저장 완료');</script>");
		}else{
			out.print("<script>alert('저장 실패');</script>");
		}
		
		
	}catch(Exception e){
		e.getMessage();
	}
	
	ArrayList<String> jpal = null;
	//String jpcSelectSql ="select * from join_pay_config, copyright_config order by join_pay_config.idx desc limit 0,1";
	String jpcSelectSql = "select * from config_table";
	try{
		jpcps = con.prepareStatement(jpcSelectSql);
		ResultSet jpcsrs = jpcps.executeQuery();
		
		while(jpcsrs.next()){
			
			jpal = new ArrayList<>();
			
			jpal.add(jpcsrs.getString("hpname"));		//0
			jpal.add(jpcsrs.getString("adminemail"));	//1
			jpal.add(jpcsrs.getString("join_usepoint"));	//2
			jpal.add(jpcsrs.getString("join_savedmoney"));//3
			jpal.add(jpcsrs.getString("join_level"));	//4
			jpal.add(jpcsrs.getString("bankname"));		//5
			jpal.add(jpcsrs.getString("bankaccount"));	//6
			jpal.add(jpcsrs.getString("usecard"));		//7
			jpal.add(jpcsrs.getString("usetelpay"));		//8
			jpal.add(jpcsrs.getString("usevoucher"));	//9
			jpal.add(jpcsrs.getString("minpaypoint"));	//10
			jpal.add(jpcsrs.getString("maxpaypoint"));	//11
			jpal.add(jpcsrs.getString("usereceipt"));	//12
			jpal.add(jpcsrs.getString("deliname"));		//13
			jpal.add(jpcsrs.getString("deliprice"));		//14
			jpal.add(jpcsrs.getString("usedesiredate"));//15
			
			jpal.add(jpcsrs.getString("compname"));//16
			jpal.add(jpcsrs.getString("compnum"));//17
			jpal.add(jpcsrs.getString("represent_name"));//18
			jpal.add(jpcsrs.getString("represent_tel"));//19
			jpal.add(jpcsrs.getString("telenum"));//20
			jpal.add(jpcsrs.getString("additionalnum"));//21
			jpal.add(jpcsrs.getString("compmailnum"));//22
			jpal.add(jpcsrs.getString("compaddr"));//23
			jpal.add(jpcsrs.getString("imname"));//24
			jpal.add(jpcsrs.getString("imemail"));//25
			
		}
		
		//out.print(cSql);
		//out.print(cps);
	
	}catch(Exception e2){
		e2.getMessage();
	}
	
	
%>
<%con.close(); %>