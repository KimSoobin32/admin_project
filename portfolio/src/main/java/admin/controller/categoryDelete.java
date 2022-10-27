package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.delete_module;


public class categoryDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public categoryDelete() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pr = response.getWriter();
		
		String[] catecode = request.getParameterValues("ck");
		ArrayList<String> catecodeList = new ArrayList<String>();
		catecodeList.add("category_table");
		catecodeList.add("categorycode");
		catecodeList.addAll(Arrays.asList(catecode));
		
		ArrayList<String> prcatecodeList = new ArrayList<String>();
		prcatecodeList.add("product_table");
		prcatecodeList.add("prcategorycode");
		prcatecodeList.addAll(Arrays.asList(catecode));
		
		delete_module dm = new delete_module();
		String result_sign1 = dm.delete(catecodeList).intern();
		String result_sign2 = dm.delete(prcatecodeList).intern();
		

		
		if((result_sign1=="ok" && result_sign2=="ok")||(result_sign1=="ok" && result_sign2=="no")) {
			pr.print("<script>"
					+ "alert('카테고리 삭제가 완료되었습니다.'); location.href='./category_list.do';"
					+ "</script>");
			
		}else {
			pr.print("<script>"
					+ "alert('올바른 값이 아닙니다.'); history.go(-1);"
					+ "</script>");
		}
		
	}

}
