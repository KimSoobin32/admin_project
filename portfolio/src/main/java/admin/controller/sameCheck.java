package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.module.sameck_module;


public class sameCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public sameCheck() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		String productcode = request.getParameter("productcode");
		
		sameck_module sm = new sameck_module();
		String sameck_result = sm.sameSearch("product_table", "productcode", productcode);
		if(sameck_result==null) {
			pw.print("데이터베이스 오류");
		}else {
			pw.print(sameck_result);
		}
	}

}
