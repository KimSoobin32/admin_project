package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.module.delete_module;


public class productDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public productDelete() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String[] pridx = request.getParameterValues("ck");
		ArrayList<String> pridxList = new ArrayList<String>();
		pridxList.add("product_table");
		pridxList.add("pridx");
		pridxList.addAll(Arrays.asList(pridx));
		
		delete_module dm = new delete_module();
		String result_sign = dm.delete(pridxList).intern();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pr = response.getWriter();
		if(result_sign=="ok") {
			pr.print("<script>"
					+ "alert('상품삭제가 완료되었습니다.'); location.href='./product_list.do';"
					+ "</script>");
			
		}else {
			pr.print("<script>"
					+ "alert('올바른 값이 아닙니다.'); history.go(-1);"
					+ "</script>");
		}
	}

}
