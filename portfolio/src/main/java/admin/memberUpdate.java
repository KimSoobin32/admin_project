package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.module.update_module;


public class memberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;

    public memberUpdate() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
		
		update_module um = new update_module();
		um.memUpdate(list);
		String memberUpdate_result = um.updateOk.intern();
		response.setContentType("text/html; charset=utf-8");
		this.pw = response.getWriter();
		if(memberUpdate_result=="ok") {
			pw.print("<script>"
					+ "alert('회원정보가 정상적으로 수정 완료되었습니다.'); location.href='./member_list.do';"
					+ "</script>");
		}else {
			pw.print("<script>"
					+ "alert('데이터가 올바르지 않습니다.'); history.go(-1);"
					+ "</script>");
		}
		
	}

}
