package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.module.insert_module;
import admin.module.today;


public class categoryWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public categoryWrite() {

    }
    
    


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pr = response.getWriter();
		String categorycode = request.getParameter("categorycode");
		String b_catecode = request.getParameter("b_catecode");
		String b_catenm = request.getParameter("b_catenm");
		String s_catecode = request.getParameter("s_catecode");
		String s_catenm = request.getParameter("s_catenm");
		String usecate = request.getParameter("usecate");
		String onlyb = request.getParameter("onlyb");
		
		
		today now = new today();
		String cindate = now.getDateTimeNow();
		String[] cdata = {"category_table",categorycode,b_catecode,b_catenm,s_catecode,s_catenm,usecate,cindate};
		String[] cdata2 = {"category_table",categorycode,b_catecode,b_catenm,"","",usecate,cindate};
		ArrayList<String> ar = null;
		
		if(onlyb==null) {	//대메뉴만 생성 체크하지 않을 때
			ar = new ArrayList<String>(Arrays.asList(cdata));
		}else {
			ar = new ArrayList<String>(Arrays.asList(cdata2));
		}
		

		insert_module im = new insert_module();
		String result_sign = im.insert(ar).intern();
		if(result_sign=="ok") {
			pr.print("<script>"
					+ "alert('카테고리 등록이 완료되었습니다.'); location.href='./cateWriteList.do';"
					+ "</script>");			
			
			
		}else if(result_sign=="double"){
			pr.print("<script>"
					+ "alert('중복된 카테고리코드입니다.'); history.go(-1);"
					+ "</script>");
		}
		
		else {
			pr.print("<script>"
					+ "alert('올바른 값이 아닙니다.'); history.go(-1);"
					+ "</script>");
		}
		
	}

}
