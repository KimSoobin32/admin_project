package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.joinok_module;
import admin.updateLoginAccept;


public class joinok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;

    public joinok() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		this.pw = response.getWriter();
		String aidx = request.getParameter("idx");
		String sign = request.getParameter("sign").intern();

		updateLoginAccept ua = new updateLoginAccept();
		String res = ua.changeAccept(aidx,sign).intern();
		if(res=="ok") {
			if(sign=="Y") {
				this.pw.print("Yes");
			}else {
				this.pw.print("No");
			}
						
		}else {
			this.pw.print("<script>"
					+ "alert('데이터 변경 실패');"
					+ "history.go(-1);"
					+ "</script>");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String aid = request.getParameter("aid");
		String apw = request.getParameter("apw");
		String aname = request.getParameter("aname");
		String aemail = request.getParameter("aemail");
		String atel1 = request.getParameter("atel1");
		String atel2 = request.getParameter("atel2");
		String atel3 = request.getParameter("atel3");
		String apart = request.getParameter("apart");
		String aposition = request.getParameter("aposition");
		
		String atel = atel1+atel2+atel3;
		
		ArrayList<String> list = new ArrayList<String>();
		list.add(aid);
		list.add(apw);
		list.add(aname);
		list.add(aemail);
		list.add(atel);
		list.add(apart);
		list.add(aposition);
		
		joinok_module jm = new joinok_module();		
		jm.insert(list);
		String joinok_result = jm.join_msg().intern();
		response.setContentType("text/html; charset=utf-8");
		this.pw = response.getWriter();
		if(joinok_result=="ok") {
			pw.print("<script>"
					+ "alert('회원가입이 정상적으로 등록 완료되었습니다.'); location.href='./index.html';"
					+ "</script>");
		}else {
			pw.print("<script>"
					+ "alert('데이터가 올바르지 않습니다.'); location.href='./add_master.html';"
					+ "</script>");
		}
		
		
	}

}
