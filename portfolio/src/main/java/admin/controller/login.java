package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.module.login_module;


public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public login() {

    }
//

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String aid = request.getParameter("aid");
		String apw = request.getParameter("apw");

		login_module lm = new login_module();
		
		login_module lm_inst = lm.getter(aid, apw);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pr = response.getWriter();
		if(lm_inst.msg.intern()=="no") {	//로그인 실패
			//pr.print("no");
			pr.write("<script>alert('아이디 및 패스워드를 다시 한번 확인하세요.'); history.go(-1);</script>");
			
		}else if(lm_inst.login_accept.intern()=="N") {
			pr.write("<script>alert('전산 담당자의 승인 후 로그인 할 수 있습니다.'); history.go(-1);</script>");
		}
		
		else{	//로그인 성공
			//pr.print("ok");
			HttpSession session = request.getSession();
			
			session.setAttribute("aid", lm_inst.uid);
			session.setAttribute("aname", lm_inst.uname);
			session.setAttribute("aemail", lm_inst.uemail);
			session.setAttribute("atel", lm_inst.utel);
			session.setAttribute("apart", lm_inst.upart);
			session.setAttribute("aposition", lm_inst.uposition);
			
			lm.saveLoginHistory(lm_inst.uid);
			
			pr.write("<script>alert('로그인 하셨습니다.'); location.href='./member_list.do';</script>");
			
		}
		
		
		
	}

}
