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


public class noticeDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public noticeDelete() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String[] nidx = request.getParameterValues("ck");
		//System.out.println(Arrays.asList(nidx));
		ArrayList<String> nidxList = new ArrayList<String>();
		nidxList.add("notice_write");
		nidxList.add("nidx");
		nidxList.addAll(Arrays.asList(nidx));
		delete_module dm = new delete_module();
		String result_sign = dm.delete(nidxList).intern();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pr = response.getWriter();
		if(result_sign=="ok") {
			pr.print("<script>"
					+ "alert('공지삭제가 완료되었습니다.'); location.href='./notice_list.do';"
					+ "</script>");
			
		}else {
			pr.print("<script>"
					+ "alert('올바른 값이 아닙니다.'); history.go(-1);"
					+ "</script>");
		}
	}

}
